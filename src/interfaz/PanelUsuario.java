package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mundo.Usuario;

/**
 * Panel que muestra la información del usuario.
 *
 * Permite visualizar el nombre y el saldo disponible
 * del usuario dentro de la interfaz.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelUsuario extends JPanel
{
	private Usuario usuario;
	private JLabel nombre;
	private JLabel saldo;
	
	/**
	 * Construye el panel de usuario.
	 *
	 * @param usuario Usuario cuyos datos serán mostrados
	 *
	 * @pre usuario != null
	 * @post Se inicializan los componentes con la información del usuario
	 */
	public PanelUsuario(Usuario usuario)
	{
		setLayout(new BorderLayout());
	    
	    this.usuario = usuario;
	    
	    JLabel banner = new JLabel(new ImageIcon(getClass().getResource("/banner.png")));
	    add(banner, BorderLayout.NORTH);
	    
	    JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
	    nombre = new JLabel("Usuario: " + usuario.getNombre());
	    saldo = new JLabel("Saldo: " + String.format("$%,.2f", usuario.getSaldo()));
	    panelInfo.add(nombre);
	    panelInfo.add(saldo);
	    add(panelInfo, BorderLayout.CENTER);
	}
	
	/**
	 * Actualiza el saldo mostrado en el panel.
	 *
	 * @pre El usuario tiene un saldo actualizado
	 * @post Se refleja el nuevo saldo en la interfaz
	 */
	public void actualizarSaldo()
	{
	    saldo.setText("Saldo: " + String.format("$%,.2f", usuario.getSaldo()));
	}
}