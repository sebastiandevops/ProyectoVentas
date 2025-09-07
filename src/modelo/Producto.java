/**
 * Clase que representa un producto con identificador, nombre y precio.
 */
package modelo;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    /**
     * Constructor que inicializa un producto con todos sus atributos.
     * @param id Identificador del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     */
    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el identificador del producto.
     * @return id del producto.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     * @param id Nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * @return precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio Nuevo precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación en texto del producto.
     * @return Cadena con los datos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}