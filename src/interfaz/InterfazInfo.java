package interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import mundo.Producto;

/**
 * Ventana que muestra la información detallada de un libro.
 *
 * Permite visualizar los datos principales del producto y su sinopsis
 * en una interfaz gráfica independiente.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class InterfazInfo extends JDialog
{
	private PanelInfoLibro panelInfoLibro;
	private PanelSinopsis panelSinopsis;
	
	/**
	 * Construye la ventana de información de un producto.
	 *
	 * @param padre Ventana padre desde la cual se abre el diálogo
	 * @param p Producto del cual se mostrará la información
	 *
	 * @pre padre != null && p != null
	 * @post Se inicializan los paneles y se muestra la información del producto
	 */
	public InterfazInfo(JFrame padre, Producto p)
	{
		super(padre, "Informacion del Libro", true);
		setSize(1050, 600);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(padre);
		
		panelInfoLibro = new PanelInfoLibro();
		panelInfoLibro.mostrarInformacio(p);
		add(panelInfoLibro, BorderLayout.NORTH);
		
		panelSinopsis = new PanelSinopsis();
		panelSinopsis.mostrarSinopsis(p);
		add(panelSinopsis, BorderLayout.CENTER);
	}
}