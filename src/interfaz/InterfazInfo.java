package interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;



public class InterfazInfo extends JDialog
{
	private PanelInfoLibro panelInfoLibro;
	private PanelSinopsis panelSinopsis;
	
	public InterfazInfo(JFrame padre)
	{
		super(padre, "Informacion del Libro", true);
		setSize(700, 500);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(padre);
		
		panelInfoLibro = new PanelInfoLibro();
		add(panelInfoLibro, BorderLayout.NORTH);
		
		panelSinopsis = new PanelSinopsis();
		add(panelSinopsis, BorderLayout.CENTER);
		
		
		
		
	}

}
