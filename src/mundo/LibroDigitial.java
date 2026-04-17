package mundo;

/**
 * Representa un libro digital dentro del sistema.
 * <p>
 * Los libros digitales tienen disponibilidad ilimitada y no manejan stock.
 * Además, incluyen información adicional como el formato del archivo
 * y su tamaño en megabytes.
 * </p>
 */
public class LibroDigitial extends Producto 
{
    /** Formato del archivo digital (PDF, EPUB, MOBI, etc). */
    private String formatoArchivo;

    /** Tamaño del archivo en megabytes. */
    private double tamanoMB;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un nuevo libro digital.
     *
     * @param codigo Código único del producto
     * @param titulo Título del libro
     * @param nombreAutor Nombre del autor
     * @param precio Precio base del libro
     * @param categoria Categoría del libro
     * @param rutaPortada Ruta de la portada
     * @param sinopsis Sinopsis del libro
     * @param editorial Editorial del libro
     * @param numeroPaginas Número de páginas
     * @param idioma Idioma del libro
     * @param fechaPublicacion Fecha de publicación
     * @param tieneDescuento Indica si tiene descuento
     * @param porcentajeDescuento Porcentaje de descuento
     * @param numeroVentas Número de veces vendido
     * @param formatoArchivo Formato del archivo digital
     * @param tamanoMB Tamaño del archivo en MB
     * 
     * @pre codigo != null && titulo != null && precio > 0 &&
     *      formatoArchivo != null && tamanoMB > 0
     * @post Se crea un libro digital con los atributos especificados
     */
    public LibroDigitial(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento, int numeroVentas, String formatoArchivo, double tamanoMB)                    
    {
        super(codigo, titulo, nombreAutor, precio, categoria, rutaPortada, sinopsis, editorial, numeroPaginas, idioma, fechaPublicacion, tieneDescuento, porcentajeDescuento, numeroVentas);

        this.formatoArchivo = formatoArchivo;
        this.tamanoMB = tamanoMB;

        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Retorna el formato del archivo digital.
     * 
     * @return Formato del archivo
     * 
     * @pre true
     * @post Se retorna el formato del archivo
     */
    public String getFormatoArchivo() 
    {
        return formatoArchivo;
    }

    /**
     * Retorna el tamaño del archivo en MB.
     * 
     * @return Tamaño en megabytes
     * 
     * @pre true
     * @post Se retorna el tamaño del archivo
     */
    public double getTamanoMB() 
    {
        return tamanoMB;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    /**
     * Establece el formato del archivo.
     * 
     * @param formatoArchivo Nuevo formato
     * 
     * @pre formatoArchivo != null && !formatoArchivo.equals("")
     * @post El formato del archivo se actualiza
     */
    public void setFormatoArchivo(String formatoArchivo) 
    {
        this.formatoArchivo = formatoArchivo;
        validarInvariantes();
    }

    /**
     * Establece el tamaño del archivo en MB.
     * 
     * @param tamanoMB Nuevo tamaño
     * 
     * @pre tamanoMB > 0
     * @post El tamaño del archivo se actualiza
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
     * Retorna el tipo de producto.
     * 
     * @return "Digital"
     * 
     * @pre true
     * @post Se retorna el tipo de producto como "Digital"
     */
    @Override
    public String getTipo() 
    {
        return "Digital";
    }

    /**
     * Indica si el producto está disponible.
     * <p>
     * Los libros digitales siempre están disponibles.
     * </p>
     * 
     * @return true siempre
     * 
     * @pre true
     * @post Se retorna true
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
     * @return true si el formato no es null ni vacío
     */
    private boolean formatoValido()
    {
        return formatoArchivo != null && !formatoArchivo.equals("");
    }

    /**
     * Verifica que el tamaño del archivo sea válido.
     * 
     * @return true si el tamaño es mayor que 0 y válido
     */
    private boolean tamanoValido()
    {
        return !Double.isNaN(tamanoMB) && !Double.isInfinite(tamanoMB) && tamanoMB > 0;
    }

    /**
     * Verifica las invariantes de la clase.
     * 
     * @pre true
     * @post Se garantiza que el formato y el tamaño sean válidos
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
     * Retorna una representación en texto del libro digital.
     * 
     * @return Cadena con la información del libro digital
     * 
     * @pre true
     * @post Se retorna una cadena con los datos del objeto
     */
    @Override
    public String toString() 
    {
        return super.toString() + 
               ", LibroDigital [formatoArchivo=" + formatoArchivo + 
               ", tamanoMB=" + tamanoMB + "]";
    }
}