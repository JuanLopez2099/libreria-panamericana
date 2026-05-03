package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.LibroNoEncontradoException;
import mundo.Biblioteca;
import mundo.LibroDigitial;
import mundo.LibroFisico;
import mundo.Producto;

/**
 * Clase de pruebas para la clase Biblioteca.
 *
 * Permite verificar el correcto funcionamiento de las operaciones
 * principales como agregar productos, buscar, ordenar y filtrar.
 *
 * @author Juan Camilo Lopez
 * @author Estefania Rodriguez
 * @version 1.0
 */
public class BibliotecaTest 
{
    /** Biblioteca de prueba */
    private Biblioteca biblioteca;

    /** Productos de prueba */
    private Producto libro1;
    private Producto libro2;
    private Producto libro3;

    // -------------------------------------------------------------------------
    // Setup
    // -------------------------------------------------------------------------

    /**
     * Configura un escenario base antes de cada prueba.
     *
     * @pre true
     * @post Se crea una biblioteca con 3 productos válidos
     */
    @BeforeEach
    public void setUp()
    {
        biblioteca = new Biblioteca();

        libro1 = new LibroFisico("001", "Java Básico", "Autor1", 50.0, "Programación", "ruta.jpg", "desc", "ed", "100", "ES", "2020", false, 0, 5);

        libro2 = new LibroFisico("002", "Python Avanzado", "Autor2", 30.0, "Programación", "ruta.jpg", "desc", "ed", "200", "ES", "2021", true, 10, 5);

        libro3 = new LibroDigitial("003", "Historia Universal", "Autor3", 40.0, "Historia", "ruta.jpg", "desc", "ed", "300", "ES", "2019", true, 20, "PDF", 5.0);

        biblioteca.agregarProducto(libro1);
        biblioteca.agregarProducto(libro2);
        biblioteca.agregarProducto(libro3);
    }

    /**
     * Verifica que el método getProductos retorne una lista válida.
     *
     * @pre La biblioteca ha sido inicializada correctamente
     * @post Se retorna una lista distinta de null
     */
    @Test
    public void testGetProductos()
    {
        assertNotNull(biblioteca.getProductos());
    }

    /**
     * Verifica que al agregar un producto, la lista aumenta su tamaño.
     *
     * @pre La biblioteca puede estar vacía o con elementos
     * @post El tamaño de la lista aumenta en 1
     */
    @Test
    public void testAgregarProducto()
    {
        Producto nuevo = new LibroFisico("010", "Nuevo Libro", "AutorX", 20.0, "Novela", "ruta.jpg", "desc", "ed", "100", "ES", "2022", false, 0, 0);

        biblioteca.agregarProducto(nuevo);

        assertEquals(4, biblioteca.getProductos().size());
    }

    /**
     * Verifica la búsqueda por código.
     *
     * @pre Existe un producto con código válido y otro inexistente
     * @post Se retorna el producto correcto o se lanza excepción si no existe
     */
    @Test
    public void testBuscarPorCodigo() throws LibroNoEncontradoException
    {
        Producto encontrado = biblioteca.buscarPorCodigo("001");

        assertEquals("Java Básico", encontrado.getTitulo());

        assertThrows(LibroNoEncontradoException.class, () -> {
            biblioteca.buscarPorCodigo("999");
        });
    }

    /**
     * Verifica que la búsqueda binaria por título funcione correctamente.
     *
     * @pre La lista está ordenada por título
     * @post Se retorna el producto correcto o se lanza excepción si no existe
     */
    @Test
    public void testBusquedaBinariaPorTitulo() throws LibroNoEncontradoException
    {
        biblioteca.ordenarPorTitulo();

        Producto encontrado = biblioteca.busquedaBinariaPorTitulo("Java Básico");

        assertEquals("Java Básico", encontrado.getTitulo());

        assertThrows(LibroNoEncontradoException.class, () -> {
            biblioteca.busquedaBinariaPorTitulo("Libro z");
        });
    }

    /**
     * Verifica el filtrado por categoría.
     *
     * @pre Existen productos con y sin la categoría buscada
     * @post Se retorna una lista válida o vacía según el caso
     */
    @Test
    public void testFiltrarPorCategoria()
    {
        assertNotNull(biblioteca.filtrarPorCategoria("Programación"));

        assertTrue(biblioteca.filtrarPorCategoria("Inexistente").isEmpty());
    }

    /**
     * Verifica el filtrado por autor.
     *
     * @pre Existen productos con y sin el autor buscado
     * @post Se retorna una lista válida o vacía según el caso
     */
    @Test
    public void testFiltrarPorAutor()
    {
        assertNotNull(biblioteca.filtrarPorAutor("Autor1"));

        assertTrue(biblioteca.filtrarPorAutor("AutorInexistente").isEmpty());
    }

    /**
     * Verifica el filtrado de productos disponibles.
     *
     * @pre Existen productos disponibles
     * @post Se retorna una lista distinta de null
     */
    @Test
    public void testFiltrarDisponibles()
    {
        assertNotNull(biblioteca.filtrarDisponibles());
    }

    /**
     * Verifica el filtrado de productos con descuento.
     *
     * @pre Existen productos con y sin descuento
     * @post Se retorna una lista válida
     */
    @Test
    public void testFiltrarConDescuento()
    {
        assertNotNull(biblioteca.filtrarConDescuento());
    }

    /**
     * Verifica que los productos se ordenen correctamente por título.
     *
     * @pre Existen productos con diferentes títulos
     * @post La lista queda ordenada alfabéticamente
     */
    @Test
    public void testOrdenarPorTitulo()
    {
        biblioteca.ordenarPorTitulo();

        ArrayList<Producto> lista = biblioteca.getProductos();

        assertTrue(lista.get(0).getTitulo().compareTo(lista.get(1).getTitulo()) < 0);
    }

    /**
     * Verifica que los productos se ordenen correctamente por precio.
     *
     * @pre Existen productos con diferentes precios
     * @post La lista queda ordenada de menor a mayor precio
     */
    @Test
    public void testOrdenarPorPrecio()
    {
        biblioteca.ordenarPorPrecio();

        ArrayList<Producto> lista = biblioteca.getProductos();

        assertTrue(lista.get(0).getPrecioFinal() <= lista.get(1).getPrecioFinal());
    }
}