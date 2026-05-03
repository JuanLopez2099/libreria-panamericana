package mundo;

import java.util.ArrayList;

import excepciones.CarritoVacioException;
import excepciones.StockInsuficienteException;

/**
 * Representa el carrito de compras del sistema.
 *
 * Permite gestionar los productos seleccionados por el usuario, incluyendo
 * operaciones de agregado, eliminación, cálculo del total y ejecución de la compra.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
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
     * @post Se inicializa la lista de ítems y queda vacía
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
     * Busca un ítem dentro del carrito asociado a un producto específico.
     *
     * @pre producto != null
     * @post Retorna el ítem correspondiente al producto si existe, null en caso contrario
     *
     * @param producto Producto que se desea buscar en el carrito
     * @return Ítem asociado al producto o null si no se encuentra
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
     * Agrega un producto al carrito con una cantidad de 1 unidad.
     *
     * @pre producto != null
     * @post El producto se agrega al carrito o se incrementa su cantidad en 1 si ya existe
     *
     * @param producto Producto que se desea agregar
     * @throws StockInsuficienteException Si el producto físico no tiene stock suficiente
     */
    public void agregarProducto(Producto producto) throws StockInsuficienteException
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
     * @pre producto != null && cantidad >= 1
     * @post Si el producto ya existe en el carrito, se incrementa su cantidad;
     *       de lo contrario, se agrega un nuevo ítem con la cantidad indicada
     *
     * @param producto Producto que se desea agregar
     * @param cantidad Cantidad de unidades a agregar
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
     * @pre producto != null
     * @post El producto es eliminado del carrito si estaba presente
     *
     * @param producto Producto que se desea eliminar
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
     * Calcula el valor total de los productos en el carrito.
     *
     * @pre true
     * @post Retorna la suma de los subtotales de todos los ítems del carrito
     *
     * @return Valor total a pagar por los productos
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
     * Ejecuta el proceso de compra de los productos en el carrito.
     *
     * @pre true
     * @post Si la compra es exitosa, se actualiza el stock de los productos físicos
     *       y el carrito queda vacío
     *
     * @throws CarritoVacioException Si el carrito no contiene productos
     * @throws StockInsuficienteException Si algún producto físico no tiene stock suficiente
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
        }

        items.clear();
        validarInvariantes();
    }

    /**
     * Obtiene la lista de ítems del carrito.
     *
     * @pre items != null
     * @post Retorna la referencia a la lista interna de ítems
     *
     * @return Lista de ítems del carrito
     */
    public ArrayList<ItemCarrito> getItems()
    {
        return items;
    }
    
    /**
     * Verifica si el carrito se encuentra vacío.
     *
     * @pre true
     * @post Retorna true si no hay ítems en el carrito, false en caso contrario
     *
     * @return true si el carrito está vacío, false en caso contrario
     */
    public boolean estaVacio()
    {
        return items.isEmpty();
    }
    

    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Verifica que la lista de ítems esté correctamente inicializada.
     *
     * @pre true
     * @post Retorna true si la lista de ítems no es null
     *
     * @return true si la lista es válida, false en caso contrario
     */
    private boolean itemsValidos() 
    {
        return items != null;
    }

    /**
     * Valida las invariantes de la clase para garantizar consistencia interna.
     *
     * @pre true
     * @post Se verifica que la lista de ítems exista
     */
    private void validarInvariantes() 
    {
        assert itemsValidos() : "La lista de items no puede ser null";
    }
}