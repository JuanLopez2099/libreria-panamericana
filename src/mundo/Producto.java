package mundo;

/**
 * Clase abstracta que representa un producto del sistema.
 *
 * Define los atributos y comportamientos comunes para todos los productos
 * gestionados en el sistema, como libros físicos y digitales. Esta clase
 * no puede ser instanciada directamente, sino que debe ser extendida por
 * clases concretas que implementen su comportamiento específico.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public abstract class Producto 
{
    /** Código único identificador del producto */
    private String codigo;

    /** Título del producto */
    private String titulo;

    /** Nombre del autor del producto */
    private String nombreAutor;

    /** Precio base del producto */
    private double precio;

    /** Categoría del producto */
    private String categoria;

    /** Ruta de la imagen de portada */
    private String rutaPortada;

    /** Descripción o sinopsis del producto */
    private String sinopsis;

    /** Editorial del producto */
    private String editorial;

    /** Número de páginas */
    private String numeroPaginas;

    /** Idioma del producto */
    private String idioma;

    /** Fecha de publicación */
    private String fechaPublicacion;

    /** Indica si el producto tiene descuento */
    private boolean tieneDescuento;

    /** Porcentaje de descuento aplicado */
    private double porcentajeDescuento;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un producto con la información especificada.
     *
     * @pre codigo != null && !codigo.equals("") &&
     *      titulo != null && !titulo.equals("") &&
     *      precio > 0 &&
     *      categoria != null && !categoria.equals("") &&
     *      rutaPortada != null && !rutaPortada.equals("") &&
     *      idioma != null && !idioma.equals("") &&
     *      porcentajeDescuento >= 0 && porcentajeDescuento <= 100
     *
     * @post Se crea un producto con los atributos inicializados correctamente
     *
     * @param codigo Código único del producto
     * @param titulo Título del producto
     * @param nombreAutor Nombre del autor
     * @param precio Precio base del producto
     * @param categoria Categoría del producto
     * @param rutaPortada Ruta de la imagen de portada
     * @param sinopsis Descripción del producto
     * @param editorial Editorial del producto
     * @param numeroPaginas Número de páginas
     * @param idioma Idioma del producto
     * @param fechaPublicacion Fecha de publicación
     * @param tieneDescuento Indica si tiene descuento
     * @param porcentajeDescuento Porcentaje de descuento aplicado
     */
    public Producto(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento) 
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.precio = precio;
        this.categoria = categoria;
        this.rutaPortada = rutaPortada;
        this.sinopsis = sinopsis;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicacion;
        this.tieneDescuento = tieneDescuento;
        this.porcentajeDescuento = porcentajeDescuento;

        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Obtiene el código del producto.
     *
     * @pre true
     * @post Se retorna el código del producto
     *
     * @return Código del producto
     */
    public String getCodigo() 
    {
        return codigo;
    }

    /**
     * Obtiene el título del producto.
     *
     * @pre true
     * @post Se retorna el título del producto
     *
     * @return Título del producto
     */
    public String getTitulo() 
    {
        return titulo;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @pre true
     * @post Se retorna el nombre del autor
     *
     * @return Nombre del autor
     */
    public String getNombreAutor() 
    {
        return nombreAutor;
    }

    /**
     * Obtiene el precio base del producto.
     *
     * @pre true
     * @post Se retorna el precio base
     *
     * @return Precio base
     */
    public double getPrecio() 
    {
        return precio;
    }

    /**
     * Calcula el precio final del producto.
     *
     * @pre true
     * @post Si tiene descuento se aplica, en caso contrario se retorna el precio base
     *
     * @return Precio final del producto
     */
    public double getPrecioFinal()
    {
        if(tieneDescuento)
        {
            return precio * (1 - porcentajeDescuento / 100);
        }
        return precio;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @pre true
     * @post Se retorna la categoría
     *
     * @return Categoría del producto
     */
    public String getCategoria() 
    {
        return categoria;
    }

    /**
     * Obtiene la ruta de la portada.
     *
     * @pre true
     * @post Se retorna la ruta de la portada
     *
     * @return Ruta de la portada
     */
    public String getRutaPortada() 
    {
        return rutaPortada;
    }

    /**
     * Obtiene la sinopsis del producto.
     *
     * @pre true
     * @post Se retorna la sinopsis
     *
     * @return Sinopsis del producto
     */
    public String getSinopsis() 
    {
        return sinopsis;
    }

    /**
     * Obtiene la editorial.
     *
     * @pre true
     * @post Se retorna la editorial
     *
     * @return Editorial del producto
     */
    public String getEditorial() 
    {
        return editorial;
    }

    /**
     * Obtiene el número de páginas.
     *
     * @pre true
     * @post Se retorna el número de páginas
     *
     * @return Número de páginas
     */
    public String getNumeroPaginas() 
    {
        return numeroPaginas;
    }

    /**
     * Obtiene el idioma del producto.
     *
     * @pre true
     * @post Se retorna el idioma
     *
     * @return Idioma del producto
     */
    public String getIdioma() 
    {
        return idioma;
    }

    /**
     * Obtiene la fecha de publicación.
     *
     * @pre true
     * @post Se retorna la fecha de publicación
     *
     * @return Fecha de publicación
     */
    public String getFechaPublicacion() 
    {
        return fechaPublicacion;
    }

    /**
     * Indica si el producto tiene descuento.
     *
     * @pre true
     * @post Se retorna el estado del descuento
     *
     * @return true si tiene descuento, false en caso contrario
     */
    public boolean isTieneDescuento() 
    {
        return tieneDescuento;
    }

    /**
     * Obtiene el porcentaje de descuento.
     *
     * @pre true
     * @post Se retorna el porcentaje de descuento
     *
     * @return Porcentaje de descuento
     */
    public double getPorcentajeDescuento() 
    {
        return porcentajeDescuento;
    }

    // -------------------------------------------------------------------------
    // Métodos abstractos
    // -------------------------------------------------------------------------

    /**
     * Obtiene el tipo de producto.
     *
     * @pre true
     * @post Se retorna una cadena que identifica el tipo de producto
     *
     * @return Tipo de producto
     */
    public abstract String getTipo();

    /**
     * Indica si el producto está disponible.
     *
     * @pre true
     * @post Se retorna el estado de disponibilidad
     *
     * @return true si está disponible, false en caso contrario
     */
    public abstract boolean estaDisponible();

    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Valida las invariantes de la clase.
     *
     * @pre true
     * @post Se garantiza que el objeto mantiene un estado válido
     */
    private void validarInvariantes()
    {
        assert codigo != null && !codigo.equals("") : "Codigo invalido";
        assert titulo != null && !titulo.equals("") : "Titulo invalido";
        assert !Double.isNaN(precio) && !Double.isInfinite(precio) && precio > 0 : "Precio invalido";
        assert categoria != null && !categoria.equals("") : "Categoria invalida";
        assert rutaPortada != null && !rutaPortada.equals("") : "Ruta portada invalida";
        assert idioma != null && !idioma.equals("") : "Idioma invalido";
        assert porcentajeDescuento >= 0 && porcentajeDescuento <= 100 : "Descuento invalido";
    }
}