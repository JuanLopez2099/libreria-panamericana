package mundo;

import java.util.ArrayList;
import java.util.List;

import excepciones.CarritoVacioException;
import excepciones.StockInsuficienteException;

public class CarritoCompra 
{
    private ArrayList<ItemCarrito> items;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public CarritoCompra() 
    {
        items = new ArrayList<>();
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------------------

    
    /**
     * Busca un item dentro del carrito que coincida con el producto especificado.
     * La comparación se realiza utilizando el código único del producto.
     * @param producto El objeto  que se desea localizar en el carrito.
     * @return El objeto encontrado.
     * retorna  si el producto no está presente en la lista de items.
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
     * Agrega un producto con cantidad 1
     */
    public void agregarProducto(Producto producto) 
    {
        agregarProducto(producto, 1);
    }

    /**
     * Agrega un producto con cantidad específicada
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
     * Elimina completamente un producto del carrito
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
     * Calcula el total del carrito
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
     * Realiza la compra
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

                if (item.getCantidad() > libroFisico.getStock()) 
                {
                    throw new StockInsuficienteException(
                        "Stock insuficiente para: " + p.getTitulo()
                    );
                }
            }
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

    /**
     * Verifica si el carrito está vacío
     */
    public boolean estaVacio() 
    {
        return items.isEmpty();
    }


    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    private boolean itemsValidos() 
    {
        return items != null;
    }

    private void validarInvariantes() 
    {
        assert itemsValidos() : "La lista de items no puede ser null";
    }
}