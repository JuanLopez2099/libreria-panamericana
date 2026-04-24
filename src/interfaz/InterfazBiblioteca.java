package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mundo.Biblioteca;
import mundo.Usuario;



public class InterfazBiblioteca extends JFrame
{
	private PanelListaLibros panelListaLibros;
	private PanelConsultas panelConsultas;
	private PanelUsuario panelUsuario;
	private PanelFormulario panelFormulario;
	private Biblioteca biblioteca;
	
	
	
	public InterfazBiblioteca()
	{
		biblioteca = new Biblioteca();
		biblioteca.cargarLibros();
		
		setTitle("Biblioteca Panamericana");
		setSize(950, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panelUsuario = new PanelUsuario();
		add(panelUsuario, BorderLayout.NORTH);
		
		panelListaLibros = new PanelListaLibros();
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
