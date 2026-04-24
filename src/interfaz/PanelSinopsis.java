package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import mundo.Biblioteca;
import mundo.Producto;

public class PanelSinopsis extends JPanel
{
	private JTextArea txtsinopsis;
	private Biblioteca biblioteca;
	
	
	public PanelSinopsis()
	{
		biblioteca = new Biblioteca();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		TitledBorder borde = BorderFactory.createTitledBorder("Sinopsis");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		txtsinopsis = new JTextArea();
		txtsinopsis.setEditable(false);
		txtsinopsis.setLineWrap(true);        
		txtsinopsis.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(txtsinopsis);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(scroll, gbc);
		
		
	}
	
	public void mostrarSinopsis(Producto p)
	{
		txtsinopsis.setText(p.getSinopsis());
	}

}
