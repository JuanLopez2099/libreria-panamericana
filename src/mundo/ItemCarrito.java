package mundo;

/**
 * Representa un ítem dentro del carrito de compras.
 * <p>
 * Un ítem asocia un producto con una cantidad determinada,
 * permitiendo calcular su subtotal dentro del carrito.
 * </p>
 */
public class ItemCarrito
{
    /** Producto asociado a este ítem */
    private Producto producto;
    
    /** Cantidad del producto en el carrito. Siempre debe ser mayor o igual a 1 */
    private int cantidad;

    /**
     * Construye un nuevo ítem de carrito con el producto y la cantidad indicados.
     * 
     * @param producto Producto a asociar
     * @param cantidad Cantidad inicial del producto
     * 
     * @pre producto != null && cantidad >= 1
     * @post Se crea un ítem con el producto y la cantidad especificados
     */
    public ItemCarrito(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Retorna el producto asociado a este ítem.
     * 
     * @return Producto del ítem
     * 
     * @pre true
     * @post Se retorna el producto asociado
     */
    public Producto getProducto()
    {
        return producto;
    }

    /**
     * Retorna la cantidad actual del producto en el carrito.
     * 
     * @return Cantidad actual
     * 
     * @pre true
     * @post Se retorna la cantidad actual del producto
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto en el ítem.
     * 
     * @param cantidad Nueva cantidad
     * 
     * @pre cantidad >= 1
     * @post La cantidad del ítem se actualiza con el valor dado
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
        validarInvariantes();
    }

    /**
     * Establece el producto asociado a este ítem.
     * 
     * @param producto Nuevo producto
     * 
     * @pre producto != null
     * @post El producto del ítem se actualiza con el valor dado
     */
    public void setProducto(Producto producto)
    {
        this.producto = producto;
        validarInvariantes();
    }

    /**
     * Incrementa en 1 la cantidad del producto en el carrito.
     * 
     * @pre true
     * @post La cantidad se incrementa en una unidad
     */
    public void incrementarCantidad()
    {
        this.cantidad++;
        validarInvariantes();
    }

    /**
     * Decrementa en 1 la cantidad del producto en el carrito.
     * <p>
     * La cantidad mínima permitida es 1, por lo que no se reduce
     * si ya se encuentra en ese valor.
     * </p>
     * 
     * @pre true
     * @post La cantidad se reduce en una unidad si es mayor que 1
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
     * Calcula el subtotal de este ítem.
     * <p>
     * El subtotal se obtiene multiplicando el precio final del producto
     * (con o sin descuento) por la cantidad.
     * </p>
     * 
     * @return Subtotal del ítem
     * 
     * @pre producto != null
     * @post Se retorna el valor correspondiente a precioFinal * cantidad
     */
    public double getSubtotal()
    {
        return producto.getPrecioFinal() * cantidad;
    }
    
    /**
     * Verifica que el producto sea válido.
     * 
     * @return true si el producto no es null
     */
    private boolean productoValido() 
    {
        return producto != null;
    }

    /**
     * Verifica que la cantidad sea válida.
     * 
     * @return true si la cantidad es mayor o igual a 1
     */
    private boolean cantidadValida() 
    {
        return cantidad >= 1;
    }

    /**
     * Verifica las invariantes de la clase.
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