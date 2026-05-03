package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import excepciones.DatoInvalidoException;
import excepciones.LibroNoEncontradoException;


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
	private PanelFormulario panelFormulario;
	private InterfazBiblioteca interfaz;
	
	
	public PanelConsultas(InterfazBiblioteca interfaz)
	{
		this.interfaz = interfaz;
		panelFormulario = new PanelFormulario();
		
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
		filtrarCategoria.addActionListener(this);
		
		filtrarAutor = new JButton("Filtrar por Autor ✍️");
		filtrarAutor.addActionListener(this);
		
		filtrarDisponibles = new JButton("Mostrar Disponibles 📦");
		filtrarDisponibles.addActionListener(this);
		
		filtrarDescuento = new JButton("Mostrar con Descuento 💸");
		filtrarDescuento.addActionListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == ordenarPrecio)
		{
			interfaz.ordenarPorPrecio();
		}
		else if(e.getSource() == ordenarTitulo)
		{
			interfaz.ordenarPorTitulo();
		}
		else if(e.getSource() == buscarCodigo)
		{
			try
			{
				interfaz.abrirInfo(interfaz.buscarPorCodigo(panelFormulario.getCodigo()));
			}
			catch(DatoInvalidoException ex)
			{
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
			}
			catch(LibroNoEncontradoException ex)
			{
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Libro No Encontrado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == buscarTitulo)
		{
			try
            {
                interfaz.abrirInfo(interfaz.buscarPorTitulo(panelFormulario.getTitulo()));
            }
            catch(DatoInvalidoException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
            }
            catch(LibroNoEncontradoException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Libro No Encontrado", JOptionPane.ERROR_MESSAGE);
            }
		}
		else if(e.getSource() == filtrarCategoria)
		{
			try
            {
                interfaz.filtrarPorCategoria(panelFormulario.getCategoria());
            }
            catch(DatoInvalidoException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
            }
			
		}
		else if(e.getSource() == filtrarAutor)
		{
			try
            {
                interfaz.filtrarPorAutor(panelFormulario.getAutor());
            }
            catch(DatoInvalidoException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Campo vacio", JOptionPane.ERROR_MESSAGE);
            }
		}
		else if(e.getSource() == filtrarDescuento)
		{
			interfaz.filtrarPorDescuento();
		}
		else if(e.getSource() == filtrarDisponibles)
		{
			interfaz.filtrarDisponibles();
		}
		
		
	}
	
}
