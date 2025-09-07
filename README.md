# Proyecto de Ventas - Primera Entrega

**Materia:** Conceptos Fundamentales de Programación  
**Institución:** Politécnico Grancolombiano  
**Entrega:** Primera entrega del trabajo colaborativo

---

## Descripción General

Este proyecto corresponde a la primera entrega del trabajo colaborativo del módulo de Conceptos Fundamentales de Programación. El objetivo es crear un programa en Java que permita el ingreso de datos de productos vendidos por vendedor, vendedores y productos, y que posteriormente reporte las ventas de los vendedores y los productos vendidos por cantidad, de acuerdo con la guía "Generación y clasificación de datos.pdf".

En esta primera entrega, se implementa el mecanismo de ingreso de datos mediante la generación automática de archivos planos con información de ejemplo, cumpliendo así con los requisitos del módulo.

---

## Estructura del Proyecto

- [`src/app/GenerateInfoFiles.java`](src/app/GenerateInfoFiles.java): Clase principal que ejecuta la generación de archivos de datos.
- [`src/util/GeneradorArchivos.java`](src/util/GeneradorArchivos.java): Clase utilitaria que contiene los métodos para generar los archivos planos de productos, vendedores y ventas.
- [`src/modelo/Producto.java`](src/modelo/Producto.java): Clase que representa un producto.
- [`src/modelo/Vendedor.java`](src/modelo/Vendedor.java): Clase que representa un vendedor.
- [`data/`](data/): Carpeta donde se generan los archivos planos de datos:
  - [`productos.txt`](data/productos.txt): Lista de productos generados.
  - [`vendedores.txt`](data/vendedores.txt): Lista de vendedores generados.
  - [`ventas_*.txt`](data/): Archivos de ventas por cada vendedor.

---

## Ejecución del Proyecto

1. **Compilar el proyecto:**
   - Si usas Eclipse, la compilación es automática.
   - Desde terminal, puedes compilar con:
     ```sh
     javac -d bin -sourcepath src src/app/GenerateInfoFiles.java
     ```

2. **Ejecutar la generación de archivos:**
   - Desde Eclipse: Haz clic derecho sobre `GenerateInfoFiles.java` y selecciona "Run As > Java Application".
   - Desde terminal, ejecuta:
     ```sh
     java -cp bin app.GenerateInfoFiles
     ```
   - Se mostrarán mensajes indicando el éxito o error de la generación.

3. **Verificar los archivos generados:**
   - Los archivos `productos.txt`, `vendedores.txt` y `ventas_*.txt` aparecerán en la carpeta `data/` del proyecto.
   - Si no los ves en Eclipse, haz clic derecho sobre la carpeta y selecciona "Refresh".

---

## Explicación de los Métodos Principales

### [`GeneradorArchivos.java`](src/util/GeneradorArchivos.java)
- `crearArchivoProductos(int cantidad, String ruta)`: Genera un archivo plano con una lista de productos aleatorios.
- `crearArchivoVendedores(int cantidad, String ruta)`: Genera un archivo plano con una lista de vendedores aleatorios y, para cada uno, un archivo de ventas asociado.
- `crearArchivoVentas(long docNum, int cantidadProductos, String carpeta)`: Genera un archivo de ventas para un vendedor específico, con productos y cantidades aleatorias.

### [`GenerateInfoFiles.java`](src/app/GenerateInfoFiles.java)
- `main(String[] args)`: Método principal que ejecuta la generación de los archivos de datos y muestra mensajes de éxito o error.

### [`Producto.java`](src/modelo/Producto.java)
- Clase que representa un producto con atributos: id, nombre y precio. Incluye constructor, getters, setters y método `toString()`.

### [`Vendedor.java`](src/modelo/Vendedor.java)
- Clase que representa un vendedor con atributos: tipoDocumento, numeroDocumento, nombres y apellidos. Incluye constructor, getters, setters y método `toString()`.

---

## Notas
- Esta entrega cumple con el requisito de definir e implementar el ingreso de datos mediante la generación automática de archivos planos.
- Los archivos generados pueden ser utilizados en futuras entregas para el procesamiento y reporte de ventas.

---

**Autoría:** Trabajo colaborativo - Conceptos Fundamentales de Programación, Politécnico Grancolombiano
