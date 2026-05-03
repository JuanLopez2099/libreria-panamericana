package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.DatoInvalidoException;

/**
 * Panel que contiene el formulario de entrada de datos para consultas.
 *
 * Permite ingresar información como código, título, categoría y autor
 * para realizar búsquedas y filtros en la biblioteca.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelFormulario extends JPanel
{
	private JLabel lblcodigo;
	private JTextField txtcodigo;
	private JLabel lbltitulo;
	private JTextField txttitulo;
	private JLabel lblcategoria;
	private JTextField txtcategoria;
	private JLabel lblautor;
	private JTextField txtautor;
	
	/**
	 * Construye el panel de formulario.
	 *
	 * @pre true
	 * @post Se inicializan los campos de texto y etiquetas del formulario
	 */
	public PanelFormulario()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblcodigo = new JLabel("Codigo:");
		txtcodigo = new JTextField("");
		lbltitulo = new JLabel("Titulo:");
		txttitulo = new JTextField("");
		lblcategoria = new JLabel("Categoria:");
		txtcategoria = new JTextField("");
		lblautor = new JLabel("Autor:");
		txtautor = new JTextField("");
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
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
        add(lblcategoria, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        add(txtcategoria, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        add(lblautor, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        add(txtautor, gbc);
	}
	
	/**
	 * Obtiene el código ingresado por el usuario.
	 *
	 * @return Código ingresado
	 * @throws DatoInvalidoException Si el campo está vacío
	 *
	 * @pre true
	 * @post Retorna el texto del campo código si no está vacío
	 */
	public String getCodigo() throws DatoInvalidoException
	{
		if(txtcodigo.getText().isEmpty())
		{
			throw new DatoInvalidoException("El campo no puede estar vacio");
		}
		return txtcodigo.getText();
	}
	
	/**
	 * Obtiene el título ingresado por el usuario.
	 *
	 * @return Título ingresado
	 * @throws DatoInvalidoException Si el campo está vacío
	 *
	 * @pre true
	 * @post Retorna el texto del campo título si no está vacío
	 */
	public String getTitulo() throws DatoInvalidoException
	{
		if(txttitulo.getText().isEmpty())
		{
			throw new DatoInvalidoException("El campo no puede estar vacio");
		}
		return txttitulo.getText();
	}
	
	/**
	 * Obtiene la categoría ingresada por el usuario.
	 *
	 * @return Categoría ingresada
	 * @throws DatoInvalidoException Si el campo está vacío
	 *
	 * @pre true
	 * @post Retorna el texto del campo categoría si no está vacío
	 */
	public String getCategoria() throws DatoInvalidoException
	{
		if(txtcategoria.getText().isEmpty())
		{
			throw new DatoInvalidoException("El campo no puede estar vacio");
		}
		return txtcategoria.getText();
	}
	
	/**
	 * Obtiene el autor ingresado por el usuario.
	 *
	 * @return Autor ingresado
	 * @throws DatoInvalidoException Si el campo está vacío
	 *
	 * @pre true
	 * @post Retorna el texto del campo autor si no está vacío
	 */
	public String getAutor() throws DatoInvalidoException
	{
		if(txtautor.getText().isEmpty())
		{
			throw new DatoInvalidoException("El campo no puede estar vacio");
		}
		return txtautor.getText();
	}
}