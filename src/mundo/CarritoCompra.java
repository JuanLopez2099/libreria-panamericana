package mundo;

import java.util.ArrayList;

import excepciones.CarritoVacioException;
import excepciones.StockInsuficienteException;

/**
 * Clase que representa el carrito de compras del sistema.
 * <p>
 * Permite agregar, eliminar y gestionar productos seleccionados por el usuario,
 * así como calcular el total de la compra y ejecutar el proceso de compra.
 * </p>
 */
public class CarritoCompra 
{
    /** Lista de ítems que componen el carrito */
    private ArrayList<ItemCarrito> items;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un carrito de compras vacío.
     * 
     * @pre true
     * @post items != null && items está vacía
     */
    public CarritoCompra() 
    {
        items = new ArrayList<>();
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------------------

    /**
     * Busca un ítem dentro del carrito que corresponda al producto dado.
     * La comparación se realiza utilizando el código único del producto.
     * 
     * @param producto Producto que se desea buscar
     * @return El ítem correspondiente si existe, null en caso contrario
     * 
     * @pre producto != null
     * @post Se retorna el ítem asociado al producto si existe
     */
    private ItemCarrito buscarItem(Producto producto) 
    {
        for (ItemCarrito item : items) 
        {
            if (item.getProducto().getCodigo().equals(producto.getCodigo())) 
            {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Agrega un producto al carrito con cantidad 1.
     * 
     * @param producto Producto a agregar
     * 
     * @pre producto != null
     * @post El producto queda agregado al carrito con cantidad 1
     */
    public void agregarProducto(Producto producto)throws StockInsuficienteException
    {
    	if(producto instanceof LibroFisico)
        {
            LibroFisico libroFisico = (LibroFisico) producto;
            ItemCarrito itemExistente = buscarItem(producto);
            int cantidadActual = 0;
 
            if(itemExistente != null)
            {
                cantidadActual = itemExistente.getCantidad();
            }

            if(cantidadActual + 1 > libroFisico.getStock())
            {
                throw new StockInsuficienteException("Stock insuficiente para: " + producto.getTitulo());
            }
        }

        agregarProducto(producto, 1);
    }

    /**
     * Agrega un producto al carrito con una cantidad específica.
     * 
     * @param producto Producto a agregar
     * @param cantidad Cantidad a agregar
     * 
     * @pre producto != null && cantidad >= 1
     * @post Si el producto ya existe, se incrementa su cantidad; 
     *       de lo contrario, se agrega un nuevo ítem al carrito
     */
    public void agregarProducto(Producto producto, int cantidad) 
    {
        ItemCarrito item = buscarItem(producto);
        
        ItemCarrito nuevoItem = new ItemCarrito(producto, cantidad);

        if (item != null) 
        {
            item.setCantidad(item.getCantidad() + cantidad);
        } 
        else 
        {
            items.add(nuevoItem);
        }

        validarInvariantes();
    }

    /**
     * Elimina completamente un producto del carrito.
     * 
     * @param producto Producto a eliminar
     * 
     * @pre producto != null
     * @post El producto deja de estar en el carrito si existía
     */
    public void eliminarProducto(Producto producto) 
    {
        ItemCarrito item = buscarItem(producto);

        if (item != null) 
        {
            items.remove(item);
        }

        validarInvariantes();
    }

    /**
     * Calcula el valor total del carrito.
     * 
     * @return Total a pagar por los productos del carrito
     * 
     * @pre true
     * @post Se retorna la suma de los subtotales de todos los ítems
     */
    public double calcularTotal() 
    {
        double total = 0;

        for (ItemCarrito item : items) 
        {
            total += item.getSubtotal();
        }

        return total;
    }

    /**
     * Realiza la compra de los productos del carrito.
     * 
     * @throws CarritoVacioException Si el carrito está vacío
     * @throws StockInsuficienteException Si no hay suficiente stock de algún producto físico
     * 
     * @pre true
     * @post Si la compra es exitosa, se actualiza el stock (si aplica),
     *       se incrementan las ventas y el carrito queda vacío
     */
    public void comprar() throws CarritoVacioException, StockInsuficienteException 
    {
        if (items.isEmpty()) 
        {
            throw new CarritoVacioException("El carrito está vacío");
        }


        for (ItemCarrito item : items) 
        {
            Producto p = item.getProducto();

            if (p instanceof LibroFisico) 
            {
                LibroFisico libroFisico = (LibroFisico) p;
                libroFisico.reducirStock(item.getCantidad());
            }

            p.incrementarVecesVendido(item.getCantidad());
        }

        items.clear();
        validarInvariantes();
    }

    public ArrayList<ItemCarrito> getItems()
    {
        return items;
    }
    
    /**
     * Indica si el carrito está vacío.
     * 
     * @return true si no hay ítems, false en caso contrario
     * 
     * @pre true
     * @post Se retorna true si el carrito no contiene productos
     */
    public boolean estaVacio() 
    {
        return items.isEmpty();
    }

    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Verifica que la lista de ítems sea válida.
     */
    private boolean itemsValidos() 
    {
        return items != null;
    }

    /**
     * Verifica las invariantes de la clase.
     */
    private void validarInvariantes() 
    {
        assert itemsValidos() : "La lista de items no puede ser null";
    }
}