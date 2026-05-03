package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.StockInsuficienteException;
import mundo.LibroFisico;

/**
 * Clase de pruebas para la clase LibroFisico.
 *
 * Permite verificar el correcto funcionamiento de los métodos
 * relacionados con el manejo de stock, disponibilidad y cálculo
 * del precio final.
 *
 * @author Juan Camilo Lopez
 * @author Estefania Rodriguez
 * @version 1.0
 */
public class LibroFisicoTest
{
    /** Libro físico de prueba */
    private LibroFisico libro;

    // -------------------------------------------------------------------------
    // Setup
    // -------------------------------------------------------------------------

    /**
     * Configura un escenario base antes de cada prueba.
     *
     * @pre true
     * @post Se crea un libro físico con stock inicial válido
     */
    @BeforeEach
    public void setUp()
    {
        libro = new LibroFisico("001", "Java Básico", "Autor1", 50.0, "Programación", "ruta.jpg", "desc", "ed", "100", "ES", "2020", false, 0, 10);
    }

    // -------------------------------------------------------------------------
    // Pruebas
    // -------------------------------------------------------------------------

    /**
     * Verifica que el método getStock retorne el valor correcto.
     *
     * @pre El libro ha sido creado con stock inicial
     * @post Se retorna el stock actual del libro
     */
    @Test
    public void testGetStock()
    {
        assertEquals(10, libro.getStock());
    }

    /**
     * Verifica que el libro esté disponible cuando tiene stock.
     *
     * @pre stock > 0
     * @post estaDisponible() retorna true
     */
    @Test
    public void testEstaDisponibleConStock()
    {
        assertTrue(libro.estaDisponible());
    }

    /**
     * Verifica que el libro no esté disponible cuando no tiene stock.
     *
     * @pre stock == 0
     * @post estaDisponible() retorna false
     */
    @Test
    public void testEstaDisponibleSinStock()
    {
        libro.setStock(0);
        assertFalse(libro.estaDisponible());
    }

    /**
     * Verifica que el stock se reduzca correctamente.
     *
     * @pre cantidad <= stock
     * @post El stock disminuye en la cantidad indicada
     */
    @Test
    public void testReducirStock() throws StockInsuficienteException
    {
        libro.reducirStock(3);
        assertEquals(7, libro.getStock());
    }

    /**
     * Verifica que se lance excepción cuando no hay suficiente stock.
     *
     * @pre cantidad > stock
     * @post Se lanza StockInsuficienteException
     */
    @Test
    public void testReducirStockInsuficiente()
    {
        assertThrows(StockInsuficienteException.class, () -> {
            libro.reducirStock(15);
        });
    }

    /**
     * Verifica el cálculo del precio final sin descuento.
     *
     * @pre El libro no tiene descuento
     * @post El precio final es igual al precio base
     */
    @Test
    public void testGetPrecioFinalSinDescuento()
    {
        assertEquals(50.0, libro.getPrecioFinal());
    }

    /**
     * Verifica el cálculo del precio final con descuento.
     *
     * @pre El libro tiene descuento activo
     * @post El precio final corresponde al precio con descuento aplicado
     */
    @Test
    public void testGetPrecioFinalConDescuento()
    {
        LibroFisico libroConDescuento = new LibroFisico("002", "Python", "Autor2", 100.0, "Programación", "ruta.jpg", "desc", "ed", "200", "ES", "2021", true, 10, 5);
        assertEquals(90.0, libroConDescuento.getPrecioFinal());
    }
}