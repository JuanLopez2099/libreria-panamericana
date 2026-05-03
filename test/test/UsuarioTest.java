package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mundo.Usuario;

/**
 * Clase de pruebas para la clase Usuario.
 *
 * Permite verificar el correcto funcionamiento de los métodos
 * relacionados con el manejo del nombre y el saldo del usuario.
 *
 * @author Juan Camilo Lopez
 * @author Estefania Rodriguez
 * @version 1.0
 */
public class UsuarioTest
{
    /** Usuario de prueba */
    private Usuario usuario;

    // -------------------------------------------------------------------------
    // Setup
    // -------------------------------------------------------------------------

    /**
     * Configura un escenario base antes de cada prueba.
     *
     * @pre true
     * @post Se crea un usuario con nombre válido y saldo inicial
     */
    @BeforeEach
    public void setUp()
    {
        usuario = new Usuario("Juan Camilo", 500000);
    }

    // -------------------------------------------------------------------------
    // Pruebas
    // -------------------------------------------------------------------------

    /**
     * Verifica que el método getNombre retorne el valor correcto.
     *
     * @pre El usuario ha sido inicializado
     * @post Se retorna el nombre del usuario
     */
    @Test
    public void testGetNombre()
    {
        assertEquals("Juan Camilo", usuario.getNombre());
    }

    /**
     * Verifica que el método getSaldo retorne el valor correcto.
     *
     * @pre El usuario ha sido inicializado
     * @post Se retorna el saldo actual del usuario
     */
    @Test
    public void testGetSaldo()
    {
        assertEquals(500000, usuario.getSaldo());
    }

    /**
     * Verifica que el saldo se descuente correctamente.
     *
     * @pre monto <= saldo
     * @post El saldo disminuye en el valor indicado
     */
    @Test
    public void testDescontarSaldo()
    {
        usuario.descontarSaldo(100000);
        assertEquals(400000, usuario.getSaldo());
    }

    /**
     * Verifica que el método indique correctamente cuando hay saldo suficiente.
     *
     * @pre monto <= saldo
     * @post Se retorna true
     */
    @Test
    public void testTieneSaldoSuficiente()
    {
        assertTrue(usuario.tieneSaldoSuficiente(300000));
    }

    /**
     * Verifica que el método indique correctamente cuando no hay saldo suficiente.
     *
     * @pre monto > saldo
     * @post Se retorna false
     */
    @Test
    public void testNoTieneSaldoSuficiente()
    {
        assertFalse(usuario.tieneSaldoSuficiente(600000));
    }

    /**
     * Verifica el caso límite donde el saldo es exactamente igual al monto.
     *
     * @pre monto == saldo
     * @post Se retorna true
     */
    @Test
    public void testTieneSaldoSuficienteExacto()
    {
        assertTrue(usuario.tieneSaldoSuficiente(500000));
    }
}