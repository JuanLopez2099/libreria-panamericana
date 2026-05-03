package mundo;

/**
 * Representa un ítem dentro del carrito de compras.
 *
 * Asocia un producto con una cantidad específica, permitiendo gestionar
 * operaciones relacionadas como modificación de cantidad y cálculo de subtotal.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class ItemCarrito
{
    /** Producto asociado a este ítem del carrito */
    private Producto producto;
    
    /** Cantidad del producto en el carrito (debe ser mayor o igual a 1) */
    private int cantidad;

    /**
     * Construye un ítem de carrito con un producto y una cantidad inicial.
     *
     * @pre producto != null && cantidad >= 1
     * @post Se crea un ítem con el producto y la cantidad especificados
     *
     * @param producto Producto que se asocia al ítem
     * @param cantidad Cantidad inicial del producto
     */
    public ItemCarrito(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Obtiene el producto asociado a este ítem.
     *
     * @pre true
     * @post Retorna el producto asociado al ítem
     *
     * @return Producto asociado al ítem
     */
    public Producto getProducto()
    {
        return producto;
    }

    /**
     * Obtiene la cantidad actual del producto en el carrito.
     *
     * @pre true
     * @post Retorna la cantidad actual del producto
     *
     * @return Cantidad del producto en el ítem
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * Establece una nueva cantidad para el producto en el ítem.
     *
     * @pre cantidad >= 1
     * @post La cantidad del ítem es actualizada con el valor proporcionado
     *
     * @param cantidad Nueva cantidad del producto
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Establece el producto asociado a este ítem.
     *
     * @pre producto != null
     * @post El producto del ítem es actualizado con el valor proporcionado
     *
     * @param producto Nuevo producto a asociar
     */
    public void setProducto(Producto producto)
    {
        this.producto = producto;
        validarInvariantes();
    }

    /**
     * Incrementa en una unidad la cantidad del producto en el ítem.
     *
     * @pre true
     * @post La cantidad del producto aumenta en una unidad
     */
    public void incrementarCantidad()
    {
        this.cantidad++;
        validarInvariantes();
    }

    /**
     * Disminuye en una unidad la cantidad del producto en el ítem.
     *
     * @pre true
     * @post La cantidad del producto se reduce en una unidad
     */
    public void decrementarCantidad()
    {
        this.cantidad--;
        validarInvariantes();
    }

    /**
     * Calcula el subtotal del ítem basado en el precio final del producto y la cantidad.
     *
     * @pre producto != null
     * @post Retorna el valor correspondiente a precioFinal * cantidad
     *
     * @return Subtotal del ítem
     */
    public double getSubtotal()
    {
        return producto.getPrecioFinal() * cantidad;
    }
    
    /**
     * Verifica que el producto asociado sea válido.
     *
     * @pre true
     * @post Retorna true si el producto no es null
     *
     * @return true si el producto es válido, false en caso contrario
     */
    private boolean productoValido() 
    {
        return producto != null;
    }

    /**
     * Verifica que la cantidad del producto sea válida.
     *
     * @pre true
     * @post Retorna true si la cantidad es mayor o igual a 1
     *
     * @return true si la cantidad es válida, false en caso contrario
     */
    private boolean cantidadValida() 
    {
        return cantidad >= 1;
    }

    /**
     * Valida las invariantes de la clase para garantizar consistencia interna.
     *
     * @pre true
     * @post Se garantiza que el producto no sea null y la cantidad sea válida
     */
    private void validarInvariantes() 
    {
        assert productoValido() : "El producto no puede ser null";
        assert cantidadValida() : "La cantidad debe ser mayor o igual a 1";
    }
}