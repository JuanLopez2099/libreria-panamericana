package mundo;

import excepciones.StockInsuficienteException;

/**
 * Representa un libro físico dentro del sistema.
 * <p>
 * Los libros físicos tienen un stock limitado, el cual se reduce
 * únicamente al momento de realizar una compra.
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
     * Retorna el stock disponible.
     * @return Cantidad en inventario.
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
     * @param stock Nuevo stock (debe ser >= 0).
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
     * Lanza una excepción si no hay suficientes unidades disponibles.
     * </p>
     *
     * @param cantidad Cantidad a reducir.
     * @throws StockInsuficienteException Si no hay stock suficiente.
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
     * @return "Físico"
     */
    @Override
    public String getTipo() 
    {
        return "Físico";
    }

    /**
     * Indica si el libro está disponible.
     * @return true si stock > 0.
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
     */
    private boolean stockValido()
    {
        return stock >= 0;
    }

    /**
     * Verifica las invariantes de la clase.
     */
    private void validarInvariantes()
    {
        assert stockValido() : "El stock no puede ser negativo";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() 
    {
        return super.toString() + ", LibroFisico [stock=" + stock + "]";
    }
}
