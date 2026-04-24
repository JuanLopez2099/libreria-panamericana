package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import excepciones.DatoInvalidoException;
import excepciones.LibroNoEncontradoException;
import mundo.Biblioteca;
import mundo.Producto;

public class PanelConsultas extends JPanel implements ActionListener
{
	private JButton buscarCodigo;
	private JButton buscarTitulo;
	private JButton filtrarCategoria;
	private JButton filtrarAutor;
	private JButton filtrarDisponibles;
	private JButton filtrarDescuento;
	private JButton ordenarPrecio;
	private JButton ordenarTitulo;
	private Biblioteca biblioteca;
	private PanelFormulario panelFormulario;
	private PanelListaLibros panelListaLibros;
	
	
	
	public PanelConsultas(PanelListaLibros panelListaLibros, PanelFormulario panelFormulario, Biblioteca biblioteca)
	{
		this.panelListaLibros = panelListaLibros;
		this.panelFormulario = panelFormulario;
		this.biblioteca = biblioteca;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		TitledBorder borde = BorderFactory.createTitledBorder("Consultas");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		buscarCodigo = new JButton("Buscar Por Codigo 🔎");
		buscarCodigo.addActionListener(this);
		
		buscarTitulo = new JButton("Buscar Por Título 🔍");
		buscarTitulo.addActionListener(this);
		
		filtrarCategoria = new JButton("Filtrar por Categoría 🗂️");
		filtrarAutor = new JButton("Filtrar por Autor ✍️");
		filtrarDisponibles = new JButton("Mostrar Disponibles 📦");
		filtrarDescuento = new JButton("Mostrar con Descuento 💸");
		
		ordenarPrecio = new JButton("Ordenar por Precio 💲");
		ordenarPrecio.addActionListener(this);
		
		ordenarTitulo = new JButton("Ordenar por Título 🔤");
		ordenarTitulo.addActionListener(this);
		
		
		
		
		 gbc.gridx = 0;
	     gbc.weightx = 1.0;
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     
	     gbc.gridy = 0;
	     add(buscarCodigo, gbc);

	     gbc.gridy = 1;
	     add(buscarTitulo, gbc);

	     gbc.gridy = 2;
	     add(filtrarCategoria, gbc);

	     gbc.gridy = 3;
	     add(filtrarAutor, gbc);

	     gbc.gridy = 4;
	     add(filtrarDisponibles, gbc);  	

	     gbc.gridy = 5;
	     add(filtrarDescuento, gbc);

	     gbc.gridy = 6;
	     add(ordenarPrecio, gbc);

	     gbc.gridy = 7;
	     add(ordenarTitulo, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 0;
	     gbc.gridheight = 8; 
	     gbc.weightx = 0.7;
	     gbc.weighty = 1.0;
	     gbc.fill = GridBagConstraints.BOTH;
	     gbc.insets = new Insets(5, 20, 5, 5);
	     add(panelFormulario, gbc);
	     
		
		
		
		
	}

	public void buscarPorCodigo()
	{
		try
		{
			try
			{
				String codigo = panelFormulario.getCodigo();
				Producto p = biblioteca.buscarPorCodigo(codigo);
				JFrame padre = (JFrame) SwingUtilities.getWindowAncestor(this);
		        InterfazInfo interfazInfo = new InterfazInfo(padre, p);
		        interfazInfo.setVisible(true);
			}
			catch(DatoInvalidoException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		catch(LibroNoEncontradoException e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Libro No Encontrado", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void buscarPorTitulo()
	{
		biblioteca.ordenarPorTitulo();
		
		try
		{
			try
			{
				String titulo = panelFormulario.getTitulo();
				Producto p = biblioteca.busquedaBinariaPorTitulo(titulo);
				JFrame padre = (JFrame) SwingUtilities.getWindowAncestor(this);
		        InterfazInfo interfazInfo = new InterfazInfo(padre, p);
		        interfazInfo.setVisible(true);
			}
			catch(DatoInvalidoException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		catch(LibroNoEncontradoException e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Libro No Encontrado", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == ordenarPrecio)
		{
			panelListaLibros.ordenarPorPrecio();
		}
		else if(e.getSource() == ordenarTitulo)
		{
			panelListaLibros.ordenarPorTitulo();
		}
		else if(e.getSource() == buscarCodigo)
		{
			buscarPorCodigo();
		}
		else if(e.getSource() == buscarTitulo)
		{
			buscarPorTitulo();
		}
		
		
	}
	
}
