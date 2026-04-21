package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InterfazBiblioteca extends JFrame
{
	private PanelListaLibros panelListaLibros;
	private PanelConsultas panelConsultas;
	
	public InterfazBiblioteca()
	{
		setTitle("Bibliteca Panamericana");
		setSize(950, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) 
	{
		InterfazBiblioteca ventana = new InterfazBiblioteca();
		
		ventana.setVisible(true);
		
	}

}
