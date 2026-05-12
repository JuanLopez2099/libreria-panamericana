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

import mundo.Producto;

/**
 * Panel que muestra la lista de libros disponibles en la biblioteca.
 *
 * Permite visualizar los títulos de los productos y seleccionar uno
 * para mostrar su información en el panel de libro actual.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelListaLibros extends JPanel
{	
	private JTextArea listaLibros;
	private PanelLibroActual libroActual;
	private ArrayList<Producto> productosListados;
	
	/**
	 * Construye el panel de lista de libros.
	 *
	 * @param interfaz Referencia a la interfaz principal
	 *
	 * @pre interfaz != null
	 * @post Se inicializan los componentes del panel
	 */
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
	
	/**
	 * Muestra una lista de productos en el panel.
	 *
	 * @param lista Lista de productos a mostrar
	 *
	 * @pre lista != null
	 * @post Se actualiza la lista visual con los títulos de los productos
	 */
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