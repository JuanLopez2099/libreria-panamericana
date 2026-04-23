package interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;



public class InterfazInfo extends JDialog
{
	private PanelInfoLibro panelInfoLibro;
	private PanelSinopsis panelSinopsis;
	
	public InterfazInfo()
	{
		setTitle("Informacion del Libro");
		setSize(700, 500);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panelInfoLibro = new PanelInfoLibro();
		add(panelInfoLibro, BorderLayout.NORTH);
		
		
		
	}

}
