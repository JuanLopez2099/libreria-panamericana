package mundo;

import excepciones.StockInsuficienteException;

/**
 * Representa un libro físico dentro del sistema.
 *
 * Extiende la clase Producto y modela un producto que posee
 * disponibilidad limitada mediante un stock. Este stock se reduce
 * únicamente cuando se realiza una compra.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class LibroFisico extends Producto 
{
    /** Cantidad de unidades disponibles en inventario */
    private int stock;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un libro físico con la información especificada.
     *
     * @pre codigo != null && titulo != null && precio > 0 && stock >= 0
     * @post Se crea una instancia de libro físico con el stock inicial definido
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
     * @param stock Cantidad inicial disponible en inventario
     */
    public LibroFisico(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento,  int stock) 
    {
        super(codigo, titulo, nombreAutor, precio, categoria, rutaPortada, sinopsis, editorial, numeroPaginas, idioma, fechaPublicacion, tieneDescuento, porcentajeDescuento);
        this.stock = stock;
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Obtiene el stock disponible del libro.
     *
     * @pre true
     * @post Retorna la cantidad actual de unidades en inventario
     *
     * @return Cantidad de unidades disponibles
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
     * @pre stock >= 0
     * @post El stock es actualizado con el valor proporcionado
     *
     * @param stock Nueva cantidad de unidades en inventario
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
     * Reduce el stock del libro en la cantidad indicada.
     *
     * @pre cantidad >= 0
     * @post El stock se reduce en la cantidad indicada si hay disponibilidad suficiente
     *
     * @param cantidad Cantidad de unidades a descontar del stock
     * @throws StockInsuficienteException Si la cantidad solicitada supera el stock disponible
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
     * Obtiene el tipo de producto.
     *
     * @pre true
     * @post Retorna el tipo de producto como "Físico"
     *
     * @return Cadena que representa el tipo de producto
     */
    @Override
    public String getTipo() 
    {
        return "Físico";
    }

    /**
     * Indica si el libro se encuentra disponible para la venta.
     *
     * @pre true
     * @post Retorna true si existe al menos una unidad disponible en stock
     *
     * @return true si el stock es mayor a 0, false en caso contrario
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
     * Verifica que el stock tenga un valor válido.
     *
     * @pre true
     * @post Retorna true si el stock es mayor o igual a 0
     *
     * @return true si el stock es válido, false en caso contrario
     */
    private boolean stockValido()
    {
        return stock >= 0;
    }

    /**
     * Valida las invariantes de la clase para garantizar consistencia interna.
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
     * Genera una representación en texto del libro físico.
     *
     * @pre true
     * @post Retorna una cadena con la información del libro físico
     *
     * @return Representación textual del objeto
     */
    @Override
    public String toString() 
    {
        return super.toString() + ", LibroFisico [stock=" + stock + "]";
    }
}