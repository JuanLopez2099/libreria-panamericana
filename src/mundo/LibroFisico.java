package mundo;

import excepciones.StockInsuficienteException;

/**
 * Representa un libro físico dentro del sistema.
 * <p>
 * Los libros físicos poseen un stock limitado, el cual se reduce
 * únicamente cuando se realiza una compra.
 * </p>
 */
public class LibroFisico extends Producto 
{
    /** Cantidad de unidades disponibles en inventario. */
    private int stock;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un nuevo libro físico.
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
     * @param stock Cantidad inicial en inventario
     * 
     * @pre codigo != null && titulo != null && precio > 0 && stock >= 0
     * @post Se crea un libro físico con el stock especificado
     */
    public LibroFisico(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento, int numeroVentas, int stock) 
    {
        super(codigo, titulo, nombreAutor, precio, categoria, rutaPortada, sinopsis, editorial, numeroPaginas, idioma, fechaPublicacion, tieneDescuento, porcentajeDescuento, numeroVentas);
        this.stock = stock;
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Retorna el stock disponible del libro.
     * 
     * @return Cantidad de unidades en inventario
     * 
     * @pre true
     * @post Se retorna el stock actual
     */
    public int getStock() 
    {
        return stock;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    /**
     * Establece el stock del libro.
     * 
     * @param stock Nuevo valor de stock
     * 
     * @pre stock >= 0
     * @post El stock se actualiza con el valor dado
     */
    public void setStock(int stock) 
    {
        this.stock = stock;
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------------------

    /**
     * Reduce el stock en la cantidad indicada.
     * <p>
     * Si la cantidad solicitada es mayor que el stock disponible,
     * se lanza una excepción.
     * </p>
     *
     * @param cantidad Cantidad a reducir
     * 
     * @throws StockInsuficienteException Si la cantidad supera el stock disponible
     * 
     * @pre cantidad >= 0
     * @post El stock se reduce en la cantidad indicada si es posible
     */
    public void reducirStock(int cantidad) throws StockInsuficienteException 
    {
        if (cantidad > stock) 
        {
            throw new StockInsuficienteException(
                "Stock insuficiente. Disponible: " + stock + ", solicitado: " + cantidad
            );
        }

        stock -= cantidad;

        assert stock >= 0 : "El stock no puede ser negativo";
    }

    // -------------------------------------------------------------------------
    // Métodos sobrescritos
    // -------------------------------------------------------------------------

    /**
     * Retorna el tipo de producto.
     * 
     * @return "Físico"
     * 
     * @pre true
     * @post Se retorna el tipo "Físico"
     */
    @Override
    public String getTipo() 
    {
        return "Físico";
    }

    /**
     * Indica si el libro está disponible para la venta.
     * 
     * @return true si el stock es mayor que 0, false en caso contrario
     * 
     * @pre true
     * @post Se retorna true si hay al menos una unidad disponible
     */
    @Override
    public boolean estaDisponible() 
    {
        return stock > 0;
    }

    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Verifica que el stock sea válido.
     * 
     * @return true si el stock es mayor o igual a 0
     */
    private boolean stockValido()
    {
        return stock >= 0;
    }

    /**
     * Verifica las invariantes de la clase.
     * 
     * @pre true
     * @post Se garantiza que el stock no sea negativo
     */
    private void validarInvariantes()
    {
        assert stockValido() : "El stock no puede ser negativo";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    /**
     * Retorna una representación en texto del libro físico.
     * 
     * @return Cadena con la información del libro físico
     * 
     * @pre true
     * @post Se retorna una cadena con los datos del objeto
     */
    @Override
    public String toString() 
    {
        return super.toString() + ", LibroFisico [stock=" + stock + "]";
    }
}