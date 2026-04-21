package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelLibroActual extends JPanel
{
	private JLabel lblcodigo;
	private JTextField txtcodigo;
	private JLabel lbltitulo;
	private JTextField txttitulo;
	private JLabel lblautor;
	private JTextField txtautor;
	private JLabel lblprecio;
	private JTextField txtprecio;
	private JLabel lblstock;
	private JTextField txtstock;
	private JButton btncomprar;
	private JButton btncarrito;
	private JButton btninfo;
	private JButton btneliminar;
	
	public PanelLibroActual()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		TitledBorder borde = BorderFactory.createTitledBorder("Libro Actual");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		lblcodigo = new JLabel("Codigo:");
		txtcodigo = new JTextField("");
		
		lbltitulo = new JLabel("Titulo:");
		txttitulo = new JTextField("");
		
		lblautor = new JLabel("Autor:");
		txtautor = new JTextField("");
		
		lblprecio = new JLabel("Precio:");
		txtprecio = new JTextField("");
		
		lblstock = new JLabel("Stock:");
		txtstock = new JTextField("");
		
		btncomprar = new JButton("Comprar ✅");
		btneliminar = new JButton("Eliminar ❌");
		btninfo = new JButton("Info 🔎");
		btncarrito = new JButton("🛒");
		
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.weightx = 0.3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(lblcodigo, gbc);
		gbc.gridx = 1; 
		gbc.weightx = 0.7;
		add(txtcodigo, gbc);

		
		gbc.gridx = 0; 
		gbc.gridy = 1; 
		gbc.weightx = 0.3;
		add(lbltitulo, gbc);
		gbc.gridx = 1; 
		gbc.weightx = 0.7;
		add(txttitulo, gbc);

		
		gbc.gridx = 0; 
		gbc.gridy = 2; 
		gbc.weightx = 0.3;
		add(lblautor, gbc);
		gbc.gridx = 1; 
		gbc.weightx = 0.7;
		add(txtautor, gbc);

		
		gbc.gridx = 0; 
		gbc.gridy = 3; 
		gbc.weightx = 0.3;
		add(lblprecio, gbc);
		gbc.gridx = 1; 
		gbc.weightx = 0.7;
		add(txtprecio, gbc);

		
		gbc.gridx = 0; 
		gbc.gridy = 4; 
		gbc.weightx = 0.3;
		add(lblstock, gbc);
		gbc.gridx = 1; 
		gbc.weightx = 0.7;
		add(txtstock, gbc);

		
		gbc.gridx = 0; 
		gbc.gridy = 5;
		gbc.gridwidth = 2; // ocupa ambas columnas
		gbc.weightx = 1.0;
		add(btncomprar, gbc);

		gbc.gridy = 6;
		add(btneliminar, gbc);

		gbc.gridy = 7;
		add(btninfo, gbc);

		gbc.gridy = 8;
		add(btncarrito, gbc);
	}
}
