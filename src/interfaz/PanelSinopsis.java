package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import mundo.Producto;

/**
 * Panel que muestra la sinopsis del libro seleccionado.
 *
 * Permite visualizar la descripción del producto actual
 * dentro de la interfaz.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelSinopsis extends JPanel
{
	private JTextArea txtsinopsis;
	
	/**
	 * Construye el panel de sinopsis.
	 *
	 * @pre No hay componentes inicializados
	 * @post Se crea un área de texto para mostrar la sinopsis
	 */
	public PanelSinopsis()
	{
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
	
	/**
	 * Muestra la sinopsis del producto.
	 *
	 * @param p Producto del cual se mostrará la sinopsis
	 *
	 * @pre p != null
	 * @post Se actualiza el texto con la sinopsis del producto
	 */
	public void mostrarSinopsis(Producto p)
	{
		txtsinopsis.setText(p.getSinopsis());
	}
}