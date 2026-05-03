package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.LibroDigitial;
import mundo.LibroFisico;
import mundo.Producto;

/**
 * Panel que muestra la información detallada de un libro.
 *
 * Permite visualizar los datos generales y específicos de un producto,
 * incluyendo atributos propios de libros físicos y digitales.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelInfoLibro extends JPanel
{
	private JLabel imagen;
	private JLabel lblcodigo;
	private JTextField txtcodigo;
	private JLabel lbltitulo;
	private JTextField txttitulo;
	private JLabel lblautor;
	private JTextField txtautor;
	private JLabel lblprecio;
	private JTextField txtprecio;
	private JLabel lblcategoria;
	private JTextField txtcategoria;
	private JLabel lbleditorial;
	private JTextField txteditorial;
	private JLabel lblpaginas;
	private JTextField txtpaginas;
	private JLabel lblfechapublicacion;
	private JTextField txtfechapublicacion;
	private JLabel lbldescuento;
	private JTextField txtdescuento;
	private JLabel lblstock;
	private JTextField txtstock;
	private JLabel lblformato;
	private JTextField txtformato;
	private JLabel lbltamaño;
	private JTextField txttamaño;
	private JLabel lblidioma;
	private JTextField txtidioma;
	
	/**
	 * Construye el panel de información del libro.
	 *
	 * @pre true
	 * @post Se inicializan y configuran todos los componentes gráficos del panel
	 */
	public PanelInfoLibro()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		TitledBorder borde = BorderFactory.createTitledBorder("Info Libro");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		imagen = new JLabel();
		imagen.setPreferredSize(new Dimension(150, 200));
		imagen.setHorizontalAlignment(JLabel.CENTER);
		
		lblcodigo = new JLabel("Código:");
		txtcodigo = new JTextField();

		lbltitulo = new JLabel("Título:");
		txttitulo = new JTextField();

		lblautor = new JLabel("Autor:");
		txtautor = new JTextField();

		lblprecio = new JLabel("Precio:");
		txtprecio = new JTextField();

		lblcategoria = new JLabel("Categoría:");
		txtcategoria = new JTextField();

		lbleditorial = new JLabel("Editorial:");
		txteditorial = new JTextField();

		lblpaginas = new JLabel("Páginas:");
		txtpaginas = new JTextField();

		lblfechapublicacion = new JLabel("Fecha de Publicación:");
		txtfechapublicacion = new JTextField();

		lbldescuento = new JLabel("Descuento:");
		txtdescuento = new JTextField();

		lblstock = new JLabel("Stock:");
		txtstock = new JTextField();
		
		lblformato = new JLabel("Formato:");
		txtformato = new JTextField("");
		
		lbltamaño = new JLabel("Tamaño MB:");
		txttamaño = new JTextField("");
		
		lblidioma = new JLabel("Idioma:");
		txtidioma = new JTextField("");
		
		txtcodigo.setEditable(false);
		txttitulo.setEditable(false);
		txtautor.setEditable(false);
		txtprecio.setEditable(false);
		txtcategoria.setEditable(false);
		txteditorial.setEditable(false);
		txtpaginas.setEditable(false);
		txtfechapublicacion.setEditable(false);
		txtdescuento.setEditable(false);
		txtstock.setEditable(false);
		txtformato.setEditable(false);
		txttamaño.setEditable(false);
		txtidioma.setEditable(false);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 5, 3, 5);

		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 6;
		gbc.weightx = 0.2;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(imagen, gbc);

		
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		gbc.weightx = 0.1;
		add(lblcodigo, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txtcodigo, gbc);
		gbc.gridx = 3; 
		gbc.weightx = 0.1;
		add(lblpaginas, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txtpaginas, gbc);

		
		gbc.gridx = 1; 
		gbc.gridy = 1; 
		gbc.weightx = 0.1;
		add(lbltitulo, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txttitulo, gbc);
		gbc.gridx = 3; 
		gbc.weightx = 0.1;
		add(lblfechapublicacion, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txtfechapublicacion, gbc);

		
		gbc.gridx = 1; 
		gbc.gridy = 2; 
		gbc.weightx = 0.1;
		add(lblautor, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txtautor, gbc);
		gbc.gridx = 3; 
		gbc.weightx = 0.1;
		add(lbldescuento, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txtdescuento, gbc);

		
		gbc.gridx = 1; 
		gbc.gridy = 3; 
		gbc.weightx = 0.1;
		add(lblprecio, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txtprecio, gbc);
		gbc.gridx = 3; 
		gbc.weightx = 0.1;
		add(lblstock, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txtstock, gbc);

		
		gbc.gridx = 1; 
		gbc.gridy = 4; 
		gbc.weightx = 0.1;
		add(lblcategoria, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txtcategoria, gbc);

		
		gbc.gridx = 1; 
		gbc.gridy = 5; 
		gbc.weightx = 0.1;
		add(lbleditorial, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txteditorial, gbc);
		
		gbc.gridx = 3; 
		gbc.gridy = 4; 
		gbc.weightx = 0.1;
		add(lblformato, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txtformato, gbc);

		gbc.gridx = 3; 
		gbc.gridy = 5; 
		gbc.weightx = 0.1;
		add(lbltamaño, gbc);
		gbc.gridx = 4; 
		gbc.weightx = 0.2;
		add(txttamaño, gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 6; 
		gbc.weightx = 0.1;
		add(lblidioma, gbc);
		gbc.gridx = 2; 
		gbc.weightx = 0.2;
		add(txtidioma, gbc);
		
	}
	
	/**
	 * Muestra la información de un producto en el panel.
	 *
	 * @param p Producto del cual se desea mostrar la información
	 *
	 * @pre p != null
	 * @post Los campos del panel se actualizan con la información del producto
	 */
	public void mostrarInformacio(Producto p)
	{
		String rutaLimpia = p.getRutaPortada().replace("img/", "");
		java.net.URL urlImg = getClass().getResource("/" + rutaLimpia);
		
	    if (urlImg != null) 
	    {
	        ImageIcon portada = new ImageIcon(urlImg);
	        Image imagenEscalada = portada.getImage().getScaledInstance(imagen.getPreferredSize().width, 200, Image.SCALE_SMOOTH);
	        imagen.setIcon(new ImageIcon(imagenEscalada));
	    } 
	    else 
	    {
	        
	        imagen.setIcon(null); 
	        System.err.println("No se encontró la imagen: " + p.getRutaPortada());
	    }
		
		txtcodigo.setText(p.getCodigo());
		txttitulo.setText(p.getTitulo());
		txtautor.setText(p.getNombreAutor());
		txtprecio.setText("$" + p.getPrecio());
		txtcategoria.setText(p.getCategoria());
		txteditorial.setText(p.getEditorial());
		txtpaginas.setText(p.getNumeroPaginas());
		txtfechapublicacion.setText(p.getFechaPublicacion());
		txtdescuento.setText("%" + p.getPorcentajeDescuento());
		txtidioma.setText(p.getIdioma());
		
		
		if(p instanceof LibroFisico)
		{
			txtstock.setText(String.valueOf(((LibroFisico) p).getStock()));
		}
		else
		{
			txtstock.setText("Digital");
		}
		
		if(p instanceof LibroDigitial)
		{
			txtformato.setText(String.valueOf(((LibroDigitial) p).getFormatoArchivo()));
			txttamaño.setText(String.valueOf(((LibroDigitial) p).getTamanoMB()));
		}
		else
		{
			txtformato.setText("Libro fisico");
			txttamaño.setText("Libro fisico");
		}
		
		
	}
}