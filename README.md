# Proyecto de Ventas - Segunda Entrega

**Materia:** Conceptos Fundamentales de Programación  
**Institución:** Politécnico Grancolombiano  
**Entrega:** Segunda entrega del trabajo colaborativo

---

## Descripción General

Este proyecto corresponde a la segunda entrega del trabajo colaborativo del módulo de Conceptos Fundamentales de Programación. El objetivo es crear un programa en Java que permita la generación automática de archivos planos de productos, vendedores y ventas, y que posteriormente procese estos archivos para reportar las ventas de los productos por cantidad y las ventas totales por vendedor, de acuerdo con los requisitos de la guía.

En esta entrega, se implementa la generación de archivos de prueba y el procesamiento de ventas para generar reportes en formato CSV, incluyendo validaciones y manejo de errores.

---

## Estructura del Proyecto

- [`src/app/GenerateInfoFiles.java`](src/app/GenerateInfoFiles.java): Clase principal que ejecuta la generación de archivos de datos de prueba (productos, vendedores y ventas).
- [`src/util/GeneradorArchivos.java`](src/util/GeneradorArchivos.java): Clase utilitaria que contiene los métodos para generar los archivos planos de productos, vendedores y ventas, incluyendo métodos pseudoaleatorios para pruebas.
- [`src/app/Main.java`](src/app/Main.java): Clase principal que procesa los archivos generados y crea los reportes solicitados en formato CSV.
- [`src/modelo/Producto.java`](src/modelo/Producto.java): Clase que representa un producto.
- [`src/modelo/Vendedor.java`](src/modelo/Vendedor.java): Clase que representa un vendedor.
- [`data/`](data/): Carpeta donde se generan los archivos planos de datos:
  - [`productos.txt`](data/productos.txt): Lista de productos generados.
  - [`vendedores.txt`](data/vendedores.txt): Lista de vendedores generados.
  - [`ventas_*.txt`](data/): Archivos de ventas por cada vendedor.
  - [`reporte_productos_vendidos.csv`](data/reporte_productos_vendidos.csv): Reporte de productos vendidos por cantidad en formato CSV.
  - [`reporte_vendedores.csv`](data/reporte_vendedores.csv): Reporte de vendedores con el total recaudado en formato CSV.

---

## Ejecución del Proyecto

1. **Compilar el proyecto:**
   - Si usas Eclipse, la compilación es automática.
   - Desde terminal, puedes compilar con:
     ```sh
     javac -d bin -sourcepath src src/app/GenerateInfoFiles.java src/app/Main.java
     ```

2. **Generar los archivos de datos de prueba:**
   - Desde Eclipse: Haz clic derecho sobre `GenerateInfoFiles.java` y selecciona "Run As > Java Application".
   - Desde terminal, ejecuta:
     ```sh
     java -cp bin app.GenerateInfoFiles
     ```
   - Se mostrarán mensajes indicando el éxito o error de la generación.

3. **Procesar los archivos y generar los reportes CSV:**
   - Desde Eclipse: Haz clic derecho sobre `Main.java` y selecciona "Run As > Java Application".
   - Desde terminal, ejecuta:
     ```sh
     java -cp bin app.Main
     ```
   - Se generarán los archivos `reporte_productos_vendidos.csv` y `reporte_vendedores.csv` en la carpeta `data/`.

4. **Verificar los archivos generados:**
   - Los archivos `productos.txt`, `vendedores.txt`, `ventas_*.txt`, `reporte_productos_vendidos.csv` y `reporte_vendedores.csv` aparecerán en la carpeta `data/` del proyecto.
   - Si no los ves en Eclipse, haz clic derecho sobre la carpeta y selecciona "Refresh".

---

## Explicación de los Métodos Principales

### [`GeneradorArchivos.java`](src/util/GeneradorArchivos.java)
- `crearArchivoProductos(int cantidad, String ruta)`: Genera un archivo plano con una lista de productos aleatorios.
- `crearArchivoVendedores(int cantidad, String ruta)`: Genera un archivo plano con una lista de vendedores aleatorios y, para cada uno, un archivo de ventas asociado.
- `crearArchivoVentas(long docNum, int cantidadProductos, String carpeta)`: Genera un archivo de ventas para un vendedor específico, con productos y cantidades aleatorias.
- `createSalesMenFile(int randomSalesCount, String name, long id)`: Genera un archivo de ventas pseudoaleatorio para un vendedor específico.
- `createProductsFile(int productsCount)`: Genera un archivo de productos pseudoaleatorio.
- `createSalesManInfoFile(int salesmanCount)`: Genera un archivo de información de vendedores pseudoaleatorio.

### [`GenerateInfoFiles.java`](src/app/GenerateInfoFiles.java)
- `main(String[] args)`: Método principal que ejecuta la generación de los archivos de datos y muestra mensajes de éxito o error.

### [`Main.java`](src/app/Main.java)
- `main(String[] args)`: Método principal que procesa los archivos de ventas y productos, valida los datos, agrega las cantidades vendidas por producto, detecta errores y genera dos reportes en formato CSV:
  - `reporte_productos_vendidos.csv`: Productos vendidos por cantidad, ordenados de mayor a menor, con nombre, precio y cantidad.
  - `reporte_vendedores.csv`: Vendedores con el total recaudado, ordenados de mayor a menor.

### [`Producto.java`](src/modelo/Producto.java)
- Clase que representa un producto con atributos: id, nombre y precio. Incluye constructor, getters, setters y método `toString()`.

### [`Vendedor.java`](src/modelo/Vendedor.java)
- Clase que representa un vendedor con atributos: tipoDocumento, numeroDocumento, nombres y apellidos. Incluye constructor, getters, setters y método `toString()`.

---

## Novedades de la Segunda Entrega
- Implementación de métodos para generación de archivos de prueba pseudoaleatorios.
- Procesamiento de archivos de ventas y productos para generar reportes en formato CSV.
- Validación de datos y manejo de errores (IDs inexistentes, cantidades negativas, formato incorrecto).
- Reporte de productos vendidos por cantidad, ordenados en forma descendente, con nombre, precio y cantidad.
- Reporte de vendedores con el total recaudado, ordenados de mayor a menor.
- Mensajes claros de éxito y error en consola.

## Novedades de la Tercera Entrega
- Se agrega la carpeta `docs`, la cuál contiene los archivos [`conclusion.txt`](docs/conclusion.txt) y [`Proyecto_Ventas_Entrega_Final.pdf`](docs/Proyecto_Ventas_Entrega_Final.pdf) con la conclusión del proyecto y el informe final respectivamente.

---

## Notas
- Esta entrega cumple con los requisitos de generación y procesamiento automático de archivos planos y reportes solicitados en la segunda entrega.
- Los archivos generados pueden ser utilizados para pruebas y análisis automatizado de ventas.

---

**Autoría:** Trabajo colaborativo - Conceptos Fundamentales de Programación, Politécnico Grancolombiano
