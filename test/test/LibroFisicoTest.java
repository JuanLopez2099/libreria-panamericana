package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.StockInsuficienteException;
import mundo.LibroFisico;

public class LibroFisicoTest
{
    private LibroFisico libro;

    @BeforeEach
    public void setUp()
    {
        libro = new LibroFisico("001", "Java Básico", "Autor1", 50.0, "Programación", "ruta.jpg", "desc", "ed", "100", "ES", "2020", false, 0, 10);
    }

    @Test
    public void testGetStock()
    {
        assertEquals(10, libro.getStock());
    }

    @Test
    public void testEstaDisponibleConStock()
    {
        assertTrue(libro.estaDisponible());
    }

    @Test
    public void testEstaDisponibleSinStock()
    {
        libro.setStock(0);
        assertFalse(libro.estaDisponible());
    }

    @Test
    public void testReducirStock() throws StockInsuficienteException
    {
        libro.reducirStock(3);
        assertEquals(7, libro.getStock());
    }

    @Test
    public void testReducirStockInsuficiente()
    {
        assertThrows(StockInsuficienteException.class, () -> {libro.reducirStock(15);});
        
        
    }

    @Test
    public void testGetPrecioFinalSinDescuento()
    {
        assertEquals(50.0, libro.getPrecioFinal());
    }

    @Test
    public void testGetPrecioFinalConDescuento()
    {
        LibroFisico libroConDescuento = new LibroFisico("002", "Python", "Autor2", 100.0, "Programación", "ruta.jpg", "desc", "ed", "200", "ES", "2021", true, 10, 5);
        assertEquals(90.0, libroConDescuento.getPrecioFinal());
    }
}
