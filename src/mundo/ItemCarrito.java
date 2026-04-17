package mundo;

/**
 * Representa un ítem dentro del carrito de compras.
 * Asocia un producto con la cantidad seleccionada por el usuario.
 * 
 * 
 * 
 */
public class ItemCarrito
{
    /** Producto asociado a este ítem */
    private Producto producto;
    
    /** Cantidad del producto en el carrito. Siempre debe ser mayor o igual a 1 */
    private int cantidad;

    /**
     * Crea un nuevo ítem de carrito con el producto y cantidad indicados.
     * @param producto Producto a agregar. No puede ser null.
     * @param cantidad Cantidad inicial. Debe ser mayor que 0.
     */
    public ItemCarrito(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Retorna el producto asociado a este ítem.
     * @return producto del ítem
     */
    public Producto getProducto()
    {
        return producto;
    }

    /**
     * Retorna la cantidad actual del producto en el carrito.
     * @return cantidad actual
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     * @param cantidad Nueva cantidad. Debe ser mayor que 0.
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Establece el producto asociado a este ítem.
     * @param producto Nuevo producto. No puede ser null.
     */
    public void setProducto(Producto producto)
    {
        this.producto = producto;
        validarInvariantes();
    }

    /**
     * Incrementa en 1 la cantidad del producto en el carrito.
     */
    public void incrementarCantidad()
    {
        this.cantidad++;
        validarInvariantes();
    }

    /**
     * Decrementa en 1 la cantidad del producto en el carrito.
     * La cantidad mínima es 1, no se reduce si ya está en ese valor.
     */
    public void decrementarCantidad()
    {
        if (this.cantidad > 1)
        {
            this.cantidad--;
        }
        
        validarInvariantes();
    }

    /**
     * Calcula el subtotal de este ítem aplicando el precio final del producto.
     * Si el producto tiene descuento activo, se usa el precio con descuento.
     * @return subtotal = precioFinal * cantidad
     */
    public double getSubtotal()
    {
        return producto.getPrecioFinal() * cantidad;
    }
    
    
    /**
     * Verifica que el producto sea válido.
     */
    private boolean productoValido() 
    {
        return producto != null;
    }

    /**
     * Verifica que la cantidad sea válida.
     */
    private boolean cantidadValida() 
    {
        return cantidad >= 1;
    }

    /**
     * Verifica las invariantes de la clase.
     */
    private void validarInvariantes() 
    {
        assert productoValido() : "El producto no puede ser null";
        assert cantidadValida() : "La cantidad debe ser mayor o igual a 1";
    }
}