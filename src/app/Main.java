package app;

import java.io.*;
import java.util.*;

/**
 * Clase principal para procesar archivos de ventas y generar reportes.
 * Requisito: crear un archivo con la información de los productos vendidos por cantidad, ordenados en forma descendente.
 */
public class Main {

    public static void main(String[] args) {
        try {
            // 1. Leer productos: id -> [nombre, precio]
            Map<String, String[]> productosInfo = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader("data/productos.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        String id = partes[0];
                        String nombre = partes[1];
                        String precio = partes[2];
                        productosInfo.put(id, new String[]{nombre, precio});
                    }
                }
            }

            // 2. Leer archivos de ventas y acumular cantidades por producto
            Map<String, Integer> productosVendidos = new HashMap<>();
            File dataDir = new File("data");
            File[] ventasFiles = dataDir.listFiles((dir, name) -> name.startsWith("ventas_") && name.endsWith(".txt"));
            if (ventasFiles != null) {
                for (File ventasFile : ventasFiles) {
                    try (BufferedReader br = new BufferedReader(new FileReader(ventasFile))) {
                        String linea;
                        boolean firstLine = true;
                        while ((linea = br.readLine()) != null) {
                            if (firstLine) { firstLine = false; continue; } // skip header
                            String[] partes = linea.split(";");
                            if (partes.length >= 2) {
                                String prodId = partes[0];
                                try {
                                    int cantidad = Integer.parseInt(partes[1]);
                                    if (cantidad < 0) {
                                        System.err.println("❌ Cantidad negativa en archivo: " + ventasFile.getName() + " línea: " + linea);
                                        continue;
                                    }
                                    productosVendidos.put(prodId, productosVendidos.getOrDefault(prodId, 0) + cantidad);
                                } catch (NumberFormatException e) {
                                    System.err.println("❌ Formato de cantidad inválido en archivo: " + ventasFile.getName() + " línea: " + linea);
                                }
                            }
                        }
                    }
                }
            }

            // 3. Validar productos y preparar lista para reporte
            List<String[]> reporte = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : productosVendidos.entrySet()) {
                String prodId = entry.getKey();
                int cantidad = entry.getValue();
                String[] info = productosInfo.get(prodId);
                if (info == null) {
                    System.err.println("❌ Producto no encontrado: " + prodId);
                    continue;
                }
                reporte.add(new String[]{info[0], info[1], String.valueOf(cantidad)}); // nombre, precio, cantidad
            }

            // 4. Ordenar por cantidad descendente
            reporte.sort((a, b) -> Integer.parseInt(b[2]) - Integer.parseInt(a[2]));

            // 5. Escribir archivo de reporte en formato CSV
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/reporte_productos_vendidos.csv"))) {
                bw.write("Nombre;Precio;Cantidad"); // encabezado CSV
                bw.newLine();
                for (String[] prod : reporte) {
                    bw.write(prod[0] + ";" + prod[1] + ";" + prod[2]);
                    bw.newLine();
                }
            }

            System.out.println("✅ Reporte generado exitosamente: data/reporte_productos_vendidos.csv");

            // --- REPORTE DE VENDEDORES ---
            // 1. Leer vendedores: docNum -> nombre completo
            Map<Long, String> vendedoresInfo = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader("data/vendedores.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length >= 4) {
                        long docNum = Long.parseLong(partes[1]);
                        String nombreCompleto = partes[2] + " " + partes[3];
                        vendedoresInfo.put(docNum, nombreCompleto);
                    }
                }
            }

            // 2. Calcular total recaudado por vendedor
            List<String[]> reporteVendedores = new ArrayList<>();
            for (Map.Entry<Long, String> entry : vendedoresInfo.entrySet()) {
                long docNum = entry.getKey();
                String nombreCompleto = entry.getValue();
                double totalRecaudado = 0.0;
                File ventasFile = new File("data/ventas_" + docNum + ".txt");
                if (ventasFile.exists()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(ventasFile))) {
                        String linea;
                        boolean firstLine = true;
                        while ((linea = br.readLine()) != null) {
                            if (firstLine) { firstLine = false; continue; }
                            String[] partes = linea.split(";");
                            if (partes.length >= 2) {
                                String prodId = partes[0];
                                int cantidad;
                                try {
                                    cantidad = Integer.parseInt(partes[1]);
                                } catch (NumberFormatException e) {
                                    continue;
                                }
                                String[] prodInfo = productosInfo.get(prodId);
                                if (prodInfo != null) {
                                    double precio = Double.parseDouble(prodInfo[1].replace(",", "."));
                                    totalRecaudado += cantidad * precio;
                                }
                            }
                        }
                    }
                }
                reporteVendedores.add(new String[]{nombreCompleto, String.format("%.2f", totalRecaudado)});
            }

            // 3. Ordenar por total recaudado descendente
            reporteVendedores.sort((a, b) -> Double.compare(Double.parseDouble(b[1].replace(",", ".")), Double.parseDouble(a[1].replace(",", "."))));

            // 4. Escribir archivo de reporte CSV
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/reporte_vendedores.csv"))) {
                bw.write("Vendedor;TotalRecaudado");
                bw.newLine();
                for (String[] vendedor : reporteVendedores) {
                    bw.write(vendedor[0] + ";" + vendedor[1]);
                    bw.newLine();
                }
            }
            System.out.println("✅ Reporte de vendedores generado exitosamente: data/reporte_vendedores.csv");
        } catch (Exception e) {
            System.err.println("❌ Error al generar el reporte: " + e.getMessage());
        }
    }
}