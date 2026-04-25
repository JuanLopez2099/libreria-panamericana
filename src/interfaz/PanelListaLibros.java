package interfaz;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
	private ArrayList<Producto> productosListados;
	
	
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
            		ArrayList<Producto> productos = productosListados;
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
		productosListados = biblioteca.getProductos();
		listaLibros.setText("");
		
		for(Producto p : productosListados)
		{
			listaLibros.append(p.getTitulo() + "\n");
		}
	}
	
	public void ordenarPorPrecio()
	{
		listaLibros.setText("");
		biblioteca.ordenarPorPrecio();
		productosListados = biblioteca.getProductos();
		
		
		for(Producto p : productosListados)
		{
			listaLibros.append(p.getTitulo() + "\n");
		}
	}
	
	public void ordenarPorTitulo()
	{
		listaLibros.setText("");
		biblioteca.ordenarPorTitulo();
		productosListados = biblioteca.getProductos();
		
		for(Producto p : productosListados)
		{
			listaLibros.append(p.getTitulo() + "\n");
		}
	}
	
	public void filtrarPorCategoria(String categoria)
	{
		
		ArrayList<Producto> lista  = biblioteca.filtrarPorCategoria(categoria);

		if(lista.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Sin resultados", "Categoria no encontrada", JOptionPane.ERROR_MESSAGE);
			mostrarLibros();
		}
		else
		{	
			listaLibros.setText("");
			productosListados = lista;
			for(Producto p: lista)
			{
				listaLibros.append(p.getTitulo() + "\n");
			}
		}
			
		
	}
	
	public void filtrarPorAutor(String autor)
	{
		
		ArrayList<Producto> lista  = biblioteca.filtrarPorAutor(autor);

		if(lista.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Sin resultados", "Autor no encontrado", JOptionPane.ERROR_MESSAGE);
			mostrarLibros();
		}
		else
		{	
			listaLibros.setText("");
			productosListados = lista;
			for(Producto p: lista)
			{
				listaLibros.append(p.getTitulo() + "\n");
			}
		}
			
		
	}
	
	
	

}
