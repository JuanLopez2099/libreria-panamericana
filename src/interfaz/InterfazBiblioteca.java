package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mundo.Biblioteca;
import mundo.CarritoCompra;
import mundo.Usuario;



public class InterfazBiblioteca extends JFrame
{
	private PanelListaLibros panelListaLibros;
	private PanelConsultas panelConsultas;
	private PanelUsuario panelUsuario;
	private PanelFormulario panelFormulario;
	private Biblioteca biblioteca;
	private CarritoCompra carrito;
	
	
	
	public InterfazBiblioteca()
	{
		biblioteca = new Biblioteca();
		biblioteca.cargarLibros();
		
		carrito = new CarritoCompra();
		
		setTitle("Biblioteca Panamericana");
		ImageIcon icono = new ImageIcon("img/icono.png");
		setIconImage(icono.getImage());
		setSize(950, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panelUsuario = new PanelUsuario();
		add(panelUsuario, BorderLayout.NORTH);
		
		panelListaLibros = new PanelListaLibros(biblioteca, carrito);
		add(panelListaLibros, BorderLayout.CENTER);
		
		panelFormulario = new PanelFormulario();
		panelConsultas = new PanelConsultas(panelListaLibros, panelFormulario, biblioteca);
		add(panelConsultas, BorderLayout.SOUTH);
		

		

	}
	
	public static void main(String[] args) 
	{
		InterfazBiblioteca ventana = new InterfazBiblioteca();
		
		ventana.setVisible(true);
		
	}

}
