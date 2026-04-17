package mundo;


/**
 * Representa un libro digital dentro del sistema.
 * <p>
 * Los libros digitales tienen disponibilidad ilimitada y no manejan stock.
 * Además, incluyen información adicional como el formato del archivo
 * y su tamaño en MB.
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
     * @param codigo Código único del producto.
     * @param titulo Título del libro.
     * @param nombreAutor Nombre del autor.
     * @param precio Precio base del libro.
     * @param categoria Categoría del libro.
     * @param rutaPortada Ruta de la portada.
     * @param sinopsis Sinopsis del libro.
     * @param editorial Editorial del libro.
     * @param numeroPaginas Número de páginas.
     * @param idioma Idioma del libro.
     * @param fechaPublicacion Fecha de publicación.
     * @param tieneDescuento Indica si tiene descuento.
     * @param porcentajeDescuento Porcentaje de descuento.
     * @param numeroVentas Número de veces vendido.
     * @param formatoArchivo Formato del archivo digital.
     * @param tamanoMB Tamaño del archivo en MB.
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
     * @return Formato del archivo.
     */
    public String getFormatoArchivo() 
    {
        return formatoArchivo;
    }

    /**
     * Retorna el tamaño del archivo en MB.
     * @return Tamaño en megabytes.
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
     * @param formatoArchivo Nuevo formato.
     */
    public void setFormatoArchivo(String formatoArchivo) 
    {
        this.formatoArchivo = formatoArchivo;
        validarInvariantes();
    }

    /**
     * Establece el tamaño del archivo en MB.
     * @param tamanoMB Nuevo tamaño en MB.
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
     * @return "Digital"
     */
    @Override
    public String getTipo() 
    {
        return "Digital";
    }

    /**
     * Los libros digitales siempre están disponibles.
     * @return true siempre.
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
     */
    private boolean formatoValido()
    {
        return formatoArchivo != null && !formatoArchivo.equals("");
    }

    /**
     * Verifica que el tamaño del archivo sea válido.
     */
    private boolean tamanoValido()
    {
        return !Double.isNaN(tamanoMB) && !Double.isInfinite(tamanoMB) && tamanoMB > 0;
    }

    /**
     * Verifica las invariantes de la clase.
     */
    private void validarInvariantes()
    {
        assert formatoValido() : "El formato del archivo es invalido";
        assert tamanoValido()  : "El tamaño del archivo debe ser mayor a 0";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() 
    {
        return super.toString() + 
               ", LibroDigital [formatoArchivo=" + formatoArchivo + 
               ", tamanoMB=" + tamanoMB + "]";
    }
}