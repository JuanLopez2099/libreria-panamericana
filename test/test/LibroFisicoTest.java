package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.StockInsuficienteException;
import mundo.LibroFisico;

/**
 * Clase de pruebas para la clase LibroFisico.
 * <p>
 * Se verifican los comportamientos principales del libro físico,
 * incluyendo manejo de stock, disponibilidad y tipo de producto.
 * </p>
 */
public class LibroFisicoTest 
{
    /** Instancia de prueba de LibroFisico */
    private LibroFisico libro;

    // -------------------------------------------------------------------------
    // Setup
    // -------------------------------------------------------------------------

    /**
     * Configura un escenario base antes de cada prueba.
     * <p>
     * Crea un libro físico con valores válidos y un stock inicial.
     * </p>
     * 
     * post: Se crea una instancia válida de LibroFisico con stock = 10
     */
    @BeforeEach
    public void setUp()
    {
    	libro = new LibroFisico("001", "El Quijote", "Cervantes", 50.0, "Novela", "ruta.jpg", "Una historia clásica", "Editorial X", "500", "Español", "1605", false, 0, 0, 10);
    }

    // -------------------------------------------------------------------------
    // Pruebas
    // -------------------------------------------------------------------------

    /**
     * Verifica que el tipo de producto sea "Físico".
     * 
     * pre: El libro está correctamente inicializado
     * post: El tipo retornado es "Físico"
     */
    @Test
    public void testGetTipo()
    {
        assertEquals("Físico", libro.getTipo());
    }

    /**
     * Verifica que el libro esté disponible cuando el stock es mayor a 0.
     * 
     * pre: stock > 0
     * post: estaDisponible() retorna true
     */
    @Test
    public void testEstaDisponibleConStock()
    {
        assertTrue(libro.estaDisponible());
    }

    /**
     * Verifica que el libro no esté disponible cuando el stock es 0.
     * 
     * pre: stock = 0
     * post: estaDisponible() retorna false
     */
    @Test
    public void testEstaDisponibleSinStock()
    {
        libro.setStock(0);
        assertFalse(libro.estaDisponible());
    }

    /**
     * Verifica que el getter de stock retorne el valor correcto.
     * 
     * pre: El libro fue creado con stock inicial
     * post: getStock() retorna el valor esperado
     */
    @Test
    public void testGetStock()
    {
        assertEquals(10, libro.getStock());
    }

    /**
     * Verifica que el setter de stock funcione correctamente.
     * 
     * pre: Nuevo stock válido
     * post: El stock se actualiza correctamente
     */
    @Test
    public void testSetStock()
    {
        libro.setStock(5);
        assertEquals(5, libro.getStock());
    }

    /**
     * Verifica que el método reducirStock disminuya correctamente el stock.
     * 
     * pre: cantidad <= stock
     * post: El stock se reduce correctamente
     * 
     * @throws StockInsuficienteException no debería lanzarse
     */
    @Test
    public void testReducirStockCorrectamente() throws StockInsuficienteException
    {
        libro.reducirStock(3);
        assertEquals(7, libro.getStock());
    }

    /**
     * Verifica que se lance una excepción cuando no hay suficiente stock.
     * 
     * pre: cantidad > stock
     * post: Se lanza StockInsuficienteException
     */
    @Test
    public void testReducirStockInsuficiente()
    {
        assertThrows(StockInsuficienteException.class, () -> {libro.reducirStock(20);});
 
    }
}