package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

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
	private PanelListaLibros panelListaLibros;
	
	
	
	public PanelConsultas(PanelListaLibros panelListaLibros)
	{
		this.panelListaLibros = panelListaLibros;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		TitledBorder borde = BorderFactory.createTitledBorder("Consultas");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		buscarCodigo = new JButton("Buscar Por Codigo 🔎");
		buscarTitulo = new JButton("Buscar Por Título 🔍");
		filtrarCategoria = new JButton("Filtrar por Categoría 🗂️");
		filtrarAutor = new JButton("Filtrar por Autor ✍️");
		filtrarDisponibles = new JButton("Mostrar Disponibles 📦");
		filtrarDescuento = new JButton("Mostrar con Descuento 💸");
		
		ordenarPrecio = new JButton("Ordenar por Precio 💲");
		ordenarPrecio.addActionListener(this);
		
		ordenarTitulo = new JButton("Ordenar por Título 🔤");
		panelFormulario = new PanelFormulario();
		
		
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
			panelListaLibros.ordenarPorPrecio();
		}
		
	}
	
}
