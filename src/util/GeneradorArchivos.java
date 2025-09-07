/**
 * Clase utilitaria para generar archivos planos de productos, vendedores y ventas.
 * Proporciona métodos estáticos para crear archivos con datos de ejemplo.
 */
package util;
import modelo.Producto;
import modelo.Vendedor;
import java.io.*;
import java.util.*;

public class GeneradorArchivos {
    /**
     * Nombres de ejemplo para los vendedores.
     */
    private static final String[] NOMBRES = {"Ana", "Luis", "Pedro", "María", "Carlos"};
    /**
     * Apellidos de ejemplo para los vendedores.
     */
    private static final String[] APELLIDOS = {"Gómez", "Rodríguez", "Martínez", "López", "Pérez"};
    /**
     * Nombres de ejemplo para los productos.
     */
    private static final String[] PRODUCTOS = {"Camisa", "Pantalón", "Zapatos", "Chaqueta", "Bolso"};

    /**
     * Crea un archivo de vendedores con datos aleatorios.
     * @param cantidad Número de vendedores a generar.
     * @param ruta Ruta del archivo a crear.
     * @throws IOException Si ocurre un error de escritura.
     */
    public static void crearArchivoVendedores(int cantidad, String ruta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            Random rand = new Random();
            for (int i = 0; i < cantidad; i++) {
                String tipoDoc = "CC";
                long docNum = 10000000 + rand.nextInt(90000000);
                String nombre = NOMBRES[rand.nextInt(NOMBRES.length)];
                String apellido = APELLIDOS[rand.nextInt(APELLIDOS.length)];
                writer.write(tipoDoc + ";" + docNum + ";" + nombre + ";" + apellido);
                writer.newLine();
                crearArchivoVentas(docNum, 3, ruta.replace("vendedores.txt", ""));
            }
        }
    }

    /**
     * Crea un archivo de productos con datos aleatorios.
     * @param cantidad Número de productos a generar.
     * @param ruta Ruta del archivo a crear.
     * @throws IOException Si ocurre un error de escritura.
     */
    public static void crearArchivoProductos(int cantidad, String ruta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            Random rand = new Random();
            for (int i = 1; i <= cantidad; i++) {
                String id = "P" + i;
                String nombre = PRODUCTOS[rand.nextInt(PRODUCTOS.length)];
                double precio = 10 + rand.nextDouble() * 90;
                writer.write(id + ";" + nombre + ";" + String.format("%.2f", precio));
                writer.newLine();
            }
        }
    }

    /**
     * Crea un archivo de ventas para un vendedor específico con productos aleatorios.
     * @param docNum Número de documento del vendedor.
     * @param cantidadProductos Número de productos vendidos.
     * @param carpeta Carpeta donde se creará el archivo.
     * @throws IOException Si ocurre un error de escritura.
     */
    public static void crearArchivoVentas(long docNum, int cantidadProductos, String carpeta) throws IOException {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(carpeta + "ventas_" + docNum + ".txt"))) {
            writer.write("CC;" + docNum);
            writer.newLine();
            for (int i = 1; i <= cantidadProductos; i++) {
                int cantidadVendida = 1 + rand.nextInt(10);
                writer.write("P" + i + ";" + cantidadVendida + ";");
                writer.newLine();
            }
        }
    }
}