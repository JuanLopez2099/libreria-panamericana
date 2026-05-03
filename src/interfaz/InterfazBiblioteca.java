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

/**
 * Representa la interfaz principal del sistema de biblioteca.
 *
 * Permite visualizar los libros, realizar búsquedas, aplicar filtros,
 * gestionar el carrito de compras y visualizar la información del usuario.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class InterfazBiblioteca extends JFrame
{
	private PanelListaLibros panelListaLibros;
	private PanelConsultas panelConsultas;
	private PanelUsuario panelUsuario;
	private Biblioteca biblioteca;
	private CarritoCompra carrito;
	private Usuario usuario;
	
	
	/**
	 * Construye la interfaz principal de la biblioteca.
	 *
	 * @pre true
	 * @post Se inicializan los componentes de la interfaz y se cargan los libros
	 */
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
	
	/**
	 * Muestra todos los libros disponibles en la biblioteca.
	 *
	 * @pre La biblioteca está inicializada
	 * @post Se visualiza la lista completa de productos
	 */
	public void mostrarLibros()
	{
	    panelListaLibros.mostrarLista(biblioteca.getProductos());
	}
	
	/**
	 * Abre la ventana con la información detallada de un producto.
	 *
	 * @param p Producto a visualizar
	 *
	 * @pre p != null
	 * @post Se muestra una nueva ventana con la información del producto
	 */
	public void abrirInfo(Producto p)
	{
		InterfazInfo interfazInfo = new InterfazInfo(this, p);
		interfazInfo.setVisible(true);
	}
	
	/**
	 * Abre la ventana del carrito de compras.
	 *
	 * @pre true
	 * @post Se muestra la interfaz del carrito
	 */
	public void abrirCarrito()
    {
        InterfazCarrito interfazCarrito = new InterfazCarrito(this);
        interfazCarrito.setVisible(true);
    }

	/**
	 * Actualiza el saldo mostrado del usuario en la interfaz.
	 *
	 * @pre El panel de usuario está inicializado
	 * @post El saldo visual se actualiza
	 */
    public void actualizarSaldo()
    {
        panelUsuario.actualizarSaldo();
    }

	/**
	 * Agrega un producto al carrito de compras.
	 *
	 * @param p Producto a agregar
	 *
	 * @pre p != null
	 * @post El producto es añadido al carrito si hay stock disponible
	 * @throws StockInsuficienteException Si no hay stock suficiente
	 */
    public void agregarAlCarrito(Producto p) throws StockInsuficienteException
    {
        carrito.agregarProducto(p);
    }
    
	/**
	 * Busca un producto por su código.
	 *
	 * @param codigo Código del producto
	 *
	 * @pre codigo != null && !codigo.equals("")
	 * @post Retorna el producto correspondiente si existe
	 * @return Producto encontrado
	 * @throws LibroNoEncontradoException Si no se encuentra el producto
	 */
    public Producto buscarPorCodigo(String codigo) throws LibroNoEncontradoException
    {
        return biblioteca.buscarPorCodigo(codigo);
    }
	
	/**
	 * Busca un producto por su título.
	 *
	 * @param titulo Título del producto
	 *
	 * @pre titulo != null && !titulo.equals("")
	 * @post Retorna el producto correspondiente si existe
	 * @return Producto encontrado
	 * @throws LibroNoEncontradoException Si no se encuentra el producto
	 */
    public Producto buscarPorTitulo(String titulo) throws LibroNoEncontradoException
    {
        biblioteca.ordenarPorTitulo();
        return biblioteca.busquedaBinariaPorTitulo(titulo);
    }
    
	/**
	 * Ordena los productos por precio.
	 *
	 * @pre La biblioteca está inicializada
	 * @post Los productos se muestran ordenados por precio
	 */
    public void ordenarPorPrecio()
    {
        biblioteca.ordenarPorPrecio();
        mostrarLibros();
    }

	/**
	 * Ordena los productos por título.
	 *
	 * @pre La biblioteca está inicializada
	 * @post Los productos se muestran ordenados por título
	 */
    public void ordenarPorTitulo()
    {
        biblioteca.ordenarPorTitulo();
        mostrarLibros();
    }
    
	/**
	 * Filtra los productos por categoría.
	 *
	 * @param categoria Categoría a filtrar
	 *
	 * @pre categoria != null
	 * @post Se muestran los productos que cumplen el filtro o un mensaje si no hay resultados
	 */
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

	/**
	 * Filtra los productos por autor.
	 *
	 * @param autor Nombre del autor
	 *
	 * @pre autor != null
	 * @post Se muestran los productos que cumplen el filtro o un mensaje si no hay resultados
	 */
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

	/**
	 * Filtra los productos disponibles.
	 *
	 * @pre true
	 * @post Se muestran los productos disponibles o un mensaje si no hay resultados
	 */
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

	/**
	 * Filtra los productos con descuento.
	 *
	 * @pre true
	 * @post Se muestran los productos con descuento o un mensaje si no hay resultados
	 */
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
	
	/**
	 * Retorna el carrito de compras.
	 *
	 * @pre true
	 * @post Se retorna la referencia al carrito
	 * @return Carrito de compras
	 */
    public CarritoCompra getCarrito()
    { 
    	return carrito; 
    }
    
	/**
	 * Retorna el usuario actual.
	 *
	 * @pre true
	 * @post Se retorna el usuario del sistema
	 * @return Usuario actual
	 */
    public Usuario getUsuario()
    { 
    	return usuario; 
    }
	
	/**
	 * Método principal de ejecución del programa.
	 *
	 * @param args Argumentos de línea de comandos
	 *
	 * @pre true
	 * @post Se inicia la interfaz gráfica del sistema
	 */
	public static void main(String[] args) 
	{
		InterfazBiblioteca ventana = new InterfazBiblioteca();
		
		ventana.setVisible(true);
		
	}

}