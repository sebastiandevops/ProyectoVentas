/**
 * Clase que representa un vendedor con tipo y número de documento, nombres y apellidos.
 */
package modelo;

public class Vendedor {
    private String tipoDocumento;
    private long numeroDocumento;
    private String nombres;
    private String apellidos;

    /**
     * Constructor que inicializa un vendedor con todos sus atributos.
     * @param tipoDocumento Tipo de documento del vendedor.
     * @param numeroDocumento Número de documento del vendedor.
     * @param nombres Nombres del vendedor.
     * @param apellidos Apellidos del vendedor.
     */
    public Vendedor(String tipoDocumento, long numeroDocumento, String nombres, String apellidos) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el tipo de documento del vendedor.
     * @return Tipo de documento.
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Establece el tipo de documento del vendedor.
     * @param tipoDocumento Nuevo tipo de documento.
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Obtiene el número de documento del vendedor.
     * @return Número de documento.
     */
    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Establece el número de documento del vendedor.
     * @param numeroDocumento Nuevo número de documento.
     */
    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * Obtiene los nombres del vendedor.
     * @return Nombres del vendedor.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del vendedor.
     * @param nombres Nuevos nombres.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene los apellidos del vendedor.
     * @return Apellidos del vendedor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del vendedor.
     * @param apellidos Nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve una representación en texto del vendedor.
     * @return Cadena con los datos del vendedor.
     */
    @Override
    public String toString() {
        return "Vendedor{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}