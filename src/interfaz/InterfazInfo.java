package interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import mundo.Producto;



public class InterfazInfo extends JDialog
{
	private PanelInfoLibro panelInfoLibro;
	private PanelSinopsis panelSinopsis;
	
	public InterfazInfo(JFrame padre, Producto p)
	{
		super(padre, "Informacion del Libro", true);
		setSize(1050, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(padre);
		
		panelInfoLibro = new PanelInfoLibro();
		panelInfoLibro.mostrarInformacio(p);
		add(panelInfoLibro, BorderLayout.NORTH);
		
		panelSinopsis = new PanelSinopsis();
		panelSinopsis.mostrarSinopsis(p);
		add(panelSinopsis, BorderLayout.CENTER);
		
		
		
		
	}

}
