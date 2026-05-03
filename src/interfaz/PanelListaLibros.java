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

import mundo.Producto;



public class PanelListaLibros extends JPanel
{	
	private JTextArea listaLibros;
	private PanelLibroActual libroActual;
	private ArrayList<Producto> productosListados;
	
	
	public PanelListaLibros(InterfazBiblioteca interfaz)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		listaLibros = new JTextArea();
		JScrollPane scroll = new JScrollPane(listaLibros);
		
		TitledBorder borde = BorderFactory.createTitledBorder("Lista de Libros");
		borde.setTitleColor(Color.BLACK);
		scroll.setBorder(borde);
		
		libroActual = new PanelLibroActual(interfaz);
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
	
	public void mostrarLista(ArrayList<Producto> lista)
    {
        productosListados = lista;
        listaLibros.setText("");
        for(Producto p : lista)
        {
            listaLibros.append(p.getTitulo() + "\n");
        }
    }


}
