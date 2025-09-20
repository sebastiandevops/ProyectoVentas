package app;

import util.GeneradorArchivos;
import java.io.IOException;

/**
 * Clase principal para la generación de archivos de datos de ejemplo.
 * Ejecuta la generación de archivos de productos, vendedores y ventas.
 */
public class GenerateInfoFiles {

    /**
     * Método principal que ejecuta la generación de archivos de datos.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            GeneradorArchivos.crearArchivoProductos(5, "data/reporte_productos.txt");
            GeneradorArchivos.crearArchivoVendedores(3, "data/reporte_vendedores.txt");
            System.out.println("✅ Archivos generados exitosamente.");
        } catch (IOException e) {
            System.err.println("❌ Error al generar los archivos: " + e.getMessage());
        }

	}

}