package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excepciones.LibroNoEncontradoException;
import excepciones.StockInsuficienteException;
import mundo.Biblioteca;
import mundo.CarritoCompra;
import mundo.Producto;
import mundo.Usuario;



public class InterfazBiblioteca extends JFrame
{
	private PanelListaLibros panelListaLibros;
	private PanelConsultas panelConsultas;
	private PanelUsuario panelUsuario;
	private Biblioteca biblioteca;
	private CarritoCompra carrito;
	private Usuario usuario;
	
	
	
	public InterfazBiblioteca()
	{
		biblioteca = new Biblioteca();
		biblioteca.cargarLibros();
		
		carrito = new CarritoCompra();
		usuario = new Usuario("Estefania Rodriguez", 500000);
		
		setTitle("Biblioteca Panamericana");
		ImageIcon icono = new ImageIcon("img/icono.png");
		setIconImage(icono.getImage());
		setSize(950, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panelUsuario = new PanelUsuario(usuario);
		add(panelUsuario, BorderLayout.NORTH);
		
		panelListaLibros = new PanelListaLibros(this);
		add(panelListaLibros, BorderLayout.CENTER);
		
		panelConsultas = new PanelConsultas(this);
		add(panelConsultas, BorderLayout.SOUTH);
		

		mostrarLibros();

	}
	
	public void mostrarLibros()
	{
	    panelListaLibros.mostrarLista(biblioteca.getProductos());
	}
	
	public void abrirInfo(Producto p)
	{
		InterfazInfo interfazInfo = new InterfazInfo(this, p);
		interfazInfo.setVisible(true);
	}
	
	public void abrirCarrito()
    {
        InterfazCarrito interfazCarrito = new InterfazCarrito(this);
        interfazCarrito.setVisible(true);
    }

    public void actualizarSaldo()
    {
        panelUsuario.actualizarSaldo();
    }

    public void agregarAlCarrito(Producto p) throws StockInsuficienteException
    {
        carrito.agregarProducto(p);
    }
    
    public Producto buscarPorCodigo(String codigo) throws LibroNoEncontradoException
    {
        return biblioteca.buscarPorCodigo(codigo);
    }
	
    public Producto buscarPorTitulo(String titulo) throws LibroNoEncontradoException
    {
        biblioteca.ordenarPorTitulo();
        return biblioteca.busquedaBinariaPorTitulo(titulo);
    }
    
    public void ordenarPorPrecio()
    {
        biblioteca.ordenarPorPrecio();
        mostrarLibros();
    }

    public void ordenarPorTitulo()
    {
        biblioteca.ordenarPorTitulo();
        mostrarLibros();
    }
    
    public void filtrarPorCategoria(String categoria)
    {
    	ArrayList<Producto> lista = biblioteca.filtrarPorCategoria(categoria);
    	if(lista.isEmpty())
        {
    		JOptionPane.showMessageDialog(this, "Sin resultados", "Categoria no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            panelListaLibros.mostrarLista(lista);
        }
    	
    }

    public void filtrarPorAutor(String autor)
    {
    	ArrayList<Producto> lista = biblioteca.filtrarPorAutor(autor);
        if(lista.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Sin resultados", "Autor no encontrado", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            panelListaLibros.mostrarLista(lista);
        }
    }

    public void filtrarDisponibles()
    {
    	ArrayList<Producto> lista = biblioteca.filtrarDisponibles();
        if(lista.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Sin resultados", "No hay disponibles", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            panelListaLibros.mostrarLista(lista);
        }
    }

    public void filtrarPorDescuento()
    {
    	ArrayList<Producto> lista = biblioteca.filtrarConDescuento();
        if(lista.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Sin resultados", "No hay libros con descuento", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            panelListaLibros.mostrarLista(lista);
        }
    }
	
    public CarritoCompra getCarrito()
    { 
    	return carrito; 
    }
    
    public Usuario getUsuario()
    { 
    	return usuario; 
    }
	
	public static void main(String[] args) 
	{
		InterfazBiblioteca ventana = new InterfazBiblioteca();
		
		ventana.setVisible(true);
		
	}

}
