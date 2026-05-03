package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mundo.Usuario;

public class UsuarioTest
{
    private Usuario usuario;

    @BeforeEach
    public void setUp()
    {
        usuario = new Usuario("Juan Camilo", 500000);
    }

    @Test
    public void testGetNombre()
    {
        assertEquals("Juan Camilo", usuario.getNombre());
    }

    @Test
    public void testGetSaldo()
    {
        assertEquals(500000, usuario.getSaldo());
    }

    @Test
    public void testDescontarSaldo()
    {
        usuario.descontarSaldo(100000);
        assertEquals(400000, usuario.getSaldo());
    }

    @Test
    public void testTieneSaldoSuficiente()
    {
        assertTrue(usuario.tieneSaldoSuficiente(300000));
    }

    @Test
    public void testNoTieneSaldoSuficiente()
    {
        assertFalse(usuario.tieneSaldoSuficiente(600000));
    }

    @Test
    public void testTieneSaldoSuficienteExacto()
    {
        assertTrue(usuario.tieneSaldoSuficiente(500000));
    }
}
