package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import excepciones.StockInsuficienteException;
import mundo.LibroFisico;
import mundo.Producto;

/**
 * Panel que muestra la información básica del libro seleccionado.
 *
 * Permite visualizar los datos principales del producto actual
 * y realizar acciones como agregar al carrito, ver información
 * detallada o acceder al carrito de compras.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelLibroActual extends JPanel implements ActionListener
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
	private Producto productoActual;
	private InterfazBiblioteca interfaz;
	
	
	
	/**
	 * Construye el panel del libro actual.
	 *
	 * @param interfaz Referencia a la interfaz principal
	 *
	 * @pre interfaz != null
	 * @post Se inicializan los componentes gráficos del panel
	 */
	public PanelLibroActual(InterfazBiblioteca interfaz)
	{
		this.interfaz = interfaz;
		
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
		
		txtcodigo.setEditable(false);
		txttitulo.setEditable(false);
		txtautor.setEditable(false);
		txtprecio.setEditable(false);
		txtstock.setEditable(false);
		
		
		
		btncomprar = new JButton("Agregar Carrito ✅");
		btncomprar.addActionListener(this);
		
		btninfo = new JButton("Info 🔎");
		btninfo.addActionListener(this);
		
		btncarrito = new JButton("🛒");
		btncarrito.addActionListener(this);
		
		
		
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
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		add(btncomprar, gbc);


		gbc.gridy = 7;
		add(btninfo, gbc);

		gbc.gridy = 8;
		add(btncarrito, gbc);
	}

	/**
	 * Maneja los eventos generados por los botones del panel.
	 *
	 * @param e Evento de acción generado
	 *
	 * @pre e != null
	 * @post Se ejecuta la acción correspondiente según el botón presionado
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btninfo)
		{
			interfaz.abrirInfo(productoActual);
		}
		else if(e.getSource() == btncarrito)
		{
			interfaz.abrirCarrito();
		}
		else if(e.getSource() == btncomprar)
		{
			try
            {
                interfaz.agregarAlCarrito(productoActual);
                JOptionPane.showMessageDialog(this, productoActual.getTitulo() + " agregado al carrito", "Carrito", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(StockInsuficienteException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Stock Insuficiente", JOptionPane.ERROR_MESSAGE);
            }
		}
		
	}
	
	/**
	 * Muestra la información de un producto en el panel.
	 *
	 * @param p Producto que se desea visualizar
	 *
	 * @pre p != null
	 * @post Los campos del panel se actualizan con la información del producto
	 */
	public void mostrarInformacio(Producto p)
	{
		this.productoActual = p;
		txtcodigo.setText(p.getCodigo());
		txttitulo.setText(p.getTitulo());
		txtautor.setText(p.getNombreAutor());
		txtprecio.setText("$" + p.getPrecio());
		
		if(p instanceof LibroFisico)
		{
			txtstock.setText(String.valueOf(((LibroFisico) p).getStock()));
		}
		else
		{
			txtstock.setText("Digital");
		}
		
		
	}
}