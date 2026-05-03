package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.CarritoVacioException;
import excepciones.StockInsuficienteException;
import mundo.CarritoCompra;
import mundo.ItemCarrito;
import mundo.LibroFisico;
import mundo.Producto;

/**
 * Clase de pruebas para la clase CarritoCompra.
 * <p>
 * Se verifican las operaciones principales del carrito, incluyendo
 * agregar productos, eliminar, cálculo del total y proceso de compra.
 * </p>
 */
public class CarritoCompraTest 
{
    /** Carrito de prueba */
    private CarritoCompra carrito;

    /** Productos de prueba */
    private LibroFisico libro1;
    private LibroFisico libro2;

    // -------------------------------------------------------------------------
    // Setup
    // -------------------------------------------------------------------------

    /**
     * Configura un escenario base antes de cada prueba.
     * 
     * pre: No hay carrito inicializado
     * post: Se crea un carrito vacío y dos libros físicos válidos
     */
    @BeforeEach
    public void setUp()
    {
        carrito = new CarritoCompra();

        libro1 = new LibroFisico("001", "Libro 1", "Autor 1", 50.0, "Novela", "ruta1", "sinopsis", "editorial", "100", "Español", "2020", false, 0, 0);
        libro2 = new LibroFisico("002", "Libro 2", "Autor 2", 30.0, "Drama", "ruta2", "sinopsis", "editorial", "200", "Español", "2021", false, 0, 0);
    }

    // -------------------------------------------------------------------------
    // Pruebas
    // -------------------------------------------------------------------------

    /**
     * Verifica que el carrito esté vacío al inicio.
     * 
     * pre: Se crea un carrito nuevo
     * post: estaVacio() retorna true
     */
    @Test
    public void testCarritoVacioInicial()
    {
        assertTrue(carrito.estaVacio());
    }

    /**
     * Verifica que al agregar un producto el carrito deja de estar vacío.
     * 
     * pre: carrito vacío
     * post: carrito no está vacío
     */
    @Test
    public void testAgregarProducto()
    {
    	try
    	{
    		carrito.agregarProducto(libro1);
    	}
    	catch(StockInsuficienteException e)
    	{
    		e.getMessage();
    	}
        
        assertFalse(carrito.estaVacio());
    }

    /**
     * Verifica el cálculo del total con múltiples productos.
     * 
     * pre: Se agregan varios productos
     * post: El total es la suma de todos los subtotales
     */
    @Test
    public void testCalcularTotalProductos()
    {
    	carrito.agregarProducto(libro1, 2); 
        carrito.agregarProducto(libro2, 1); 
        
        assertEquals(130.0, carrito.calcularTotal());
    }

    /**
     * Verifica que se elimine correctamente un producto del carrito.
     * 
     * pre: El producto existe en el carrito
     * post: El producto es eliminado
     */
    @Test
    public void testEliminarProducto()
    {
    	try
    	{
    		carrito.agregarProducto(libro1);
    	}
    	catch(StockInsuficienteException e)
    	{
    		e.getMessage();
    	}
        
        carrito.eliminarProducto(libro1);

        assertTrue(carrito.estaVacio());
    }

    /**
     * Verifica que se lance excepción al intentar comprar con carrito vacío.
     * 
     * pre: carrito vacío
     * post: Se lanza CarritoVacioException
     */
    @Test
    public void testComprarCarritoVacio()
    {
        assertThrows(CarritoVacioException.class, () -> 
        {
            carrito.comprar();
        });
    }

    /**
     * Verifica que una compra válida vacíe el carrito.
     * 
     * pre: carrito con productos y stock suficiente
     * post: carrito queda vacío
     */
    @Test
    public void testCompraExitosa() throws Exception
    {
        carrito.agregarProducto(libro1, 2);

        carrito.comprar();

        assertTrue(carrito.estaVacio());
    }

    /**
     * Verifica que se reduzca el stock después de una compra.
     * 
     * pre: stock suficiente
     * post: stock disminuye correctamente
     */
    @Test
    public void testReducirStockDespuesDeCompra() throws Exception
    {
        carrito.agregarProducto(libro1, 3);

        carrito.comprar();

        assertEquals(7, libro1.getStock());
    }

    /**
     * Verifica que se lance excepción cuando no hay suficiente stock.
     * 
     * pre: cantidad > stock
     * post: Se lanza StockInsuficienteException
     */
    @Test
    public void testCompraConStockInsuficiente()
    {
        carrito.agregarProducto(libro2, 10); // stock es 5

        assertThrows(StockInsuficienteException.class, () -> {carrito.comprar();});
        
            
        
    }
}