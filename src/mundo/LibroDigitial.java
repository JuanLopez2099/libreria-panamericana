package mundo;

/**
 * Representa un libro digital dentro del sistema.
 *
 * Extiende la clase Producto y modela un producto de tipo digital,
 * el cual no maneja stock y siempre se encuentra disponible.
 * Incluye información adicional como el formato del archivo
 * y su tamaño en megabytes.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class LibroDigitial extends Producto 
{
    /** Formato del archivo digital (por ejemplo: PDF, EPUB, MOBI) */
    private String formatoArchivo;

    /** Tamaño del archivo digital expresado en megabytes */
    private double tamanoMB;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un libro digital con la información especificada.
     *
     * @pre codigo != null && titulo != null && precio > 0 &&
     *      formatoArchivo != null && tamanoMB > 0
     * @post Se crea una instancia de libro digital con los atributos definidos
     *
     * @param codigo Código único del producto
     * @param titulo Título del libro
     * @param nombreAutor Nombre del autor del libro
     * @param precio Precio base del libro
     * @param categoria Categoría del libro
     * @param rutaPortada Ruta de la imagen de portada
     * @param sinopsis Descripción o resumen del libro
     * @param editorial Editorial del libro
     * @param numeroPaginas Número de páginas del libro
     * @param idioma Idioma en el que está escrito el libro
     * @param fechaPublicacion Fecha de publicación del libro
     * @param tieneDescuento Indica si el libro tiene descuento aplicado
     * @param porcentajeDescuento Porcentaje de descuento aplicado
     * @param formatoArchivo Formato del archivo digital
     * @param tamanoMB Tamaño del archivo en megabytes
     */
    public LibroDigitial(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento, String formatoArchivo, double tamanoMB)                    
    {
        super(codigo, titulo, nombreAutor, precio, categoria, rutaPortada, sinopsis, editorial, numeroPaginas, idioma, fechaPublicacion, tieneDescuento, porcentajeDescuento);

        this.formatoArchivo = formatoArchivo;
        this.tamanoMB = tamanoMB;

        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Obtiene el formato del archivo digital.
     *
     * @pre true
     * @post Retorna el formato del archivo asociado al libro digital
     *
     * @return Formato del archivo digital
     */
    public String getFormatoArchivo() 
    {
        return formatoArchivo;
    }

    /**
     * Obtiene el tamaño del archivo digital en megabytes.
     *
     * @pre true
     * @post Retorna el tamaño del archivo en MB
     *
     * @return Tamaño del archivo en megabytes
     */
    public double getTamanoMB() 
    {
        return tamanoMB;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    /**
     * Establece el formato del archivo digital.
     *
     * @pre formatoArchivo != null && !formatoArchivo.equals("")
     * @post El formato del archivo es actualizado con el valor proporcionado
     *
     * @param formatoArchivo Nuevo formato del archivo
     */
    public void setFormatoArchivo(String formatoArchivo) 
    {
        this.formatoArchivo = formatoArchivo;
        validarInvariantes();
    }

    /**
     * Establece el tamaño del archivo digital en megabytes.
     *
     * @pre tamanoMB > 0
     * @post El tamaño del archivo es actualizado con el valor proporcionado
     *
     * @param tamanoMB Nuevo tamaño del archivo en MB
     */
    public void setTamanoMB(double tamanoMB) 
    {
        this.tamanoMB = tamanoMB;
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos sobrescritos
    // -------------------------------------------------------------------------

    /**
     * Obtiene el tipo de producto.
     *
     * @pre true
     * @post Retorna el tipo de producto como "Digital"
     *
     * @return Cadena que representa el tipo de producto
     */
    @Override
    public String getTipo() 
    {
        return "Digital";
    }

    /**
     * Indica si el producto se encuentra disponible.
     *
     * @pre true
     * @post Retorna true, ya que los productos digitales siempre están disponibles
     *
     * @return true siempre
     */
    @Override
    public boolean estaDisponible() 
    {
        return true;
    }

    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Verifica que el formato del archivo sea válido.
     *
     * @pre true
     * @post Retorna true si el formato no es null ni vacío
     *
     * @return true si el formato es válido, false en caso contrario
     */
    private boolean formatoValido()
    {
        return formatoArchivo != null && !formatoArchivo.equals("");
    }

    /**
     * Verifica que el tamaño del archivo sea válido.
     *
     * @pre true
     * @post Retorna true si el tamaño es mayor a 0 y es un valor válido
     *
     * @return true si el tamaño es válido, false en caso contrario
     */
    private boolean tamanoValido()
    {
        return !Double.isNaN(tamanoMB) && !Double.isInfinite(tamanoMB) && tamanoMB > 0;
    }

    /**
     * Valida las invariantes de la clase para garantizar consistencia interna.
     *
     * @pre true
     * @post Se garantiza que el formato y el tamaño del archivo sean válidos
     */
    private void validarInvariantes()
    {
        assert formatoValido() : "El formato del archivo es invalido";
        assert tamanoValido()  : "El tamaño del archivo debe ser mayor a 0";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    /**
     * Genera una representación en texto del libro digital.
     *
     * @pre true
     * @post Retorna una cadena con la información del libro digital
     *
     * @return Representación textual del objeto
     */
    @Override
    public String toString() 
    {
        return super.toString() + 
               ", LibroDigital [formatoArchivo=" + formatoArchivo + 
               ", tamanoMB=" + tamanoMB + "]";
    }
}