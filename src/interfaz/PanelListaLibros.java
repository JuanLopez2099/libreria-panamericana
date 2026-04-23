package interfaz;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
        
        listaLibros.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent e)
        	{
        		try
            	{
            		int linea = listaLibros.getLineOfOffset(listaLibros.viewToModel2D(e.getPoint()));
            		ArrayList<Producto> productos = biblioteca.getProductos();
            		if(linea >= 0 && linea < productos.size())
            		{
            			libroActual.mostrarInformacio(productos.get(linea));
            		}
            		
            	}
            	catch(Exception ex)
            	{
            		
            	}
        	}
		});
      
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
