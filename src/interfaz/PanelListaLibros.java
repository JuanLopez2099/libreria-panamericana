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


public class PanelListaLibros extends JPanel
{	
	private JTextArea listaLibros;
	private PanelLibroActual libroActual;
	private Biblioteca biblioteca;
	
	
	public PanelListaLibros()
	{
		biblioteca = new Biblioteca();
		biblioteca.cargarLibros();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		listaLibros = new JTextArea();
		JScrollPane scroll = new JScrollPane(listaLibros);
		
		TitledBorder borde = BorderFactory.createTitledBorder("Lista de Libros");
		borde.setTitleColor(Color.BLACK);
		scroll.setBorder(borde);
		
		libroActual = new PanelLibroActual();
		listaLibros.setEditable(false);
		
        gbc.gridy = 0;
        gbc.gridheight = 6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.weightx = 0.4;
        add(scroll, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        add(libroActual, gbc);
        mostrarLibros();
      
	}
	
	public void mostrarLibros()
	{
		listaLibros.setText("");
		
		for(Producto p : biblioteca.getProductos())
		{
			listaLibros.append(p.getTitulo() + "\n");
		}
	}
	
	
	
	

}
