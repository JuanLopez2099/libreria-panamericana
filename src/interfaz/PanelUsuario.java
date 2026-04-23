package interfaz;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mundo.Usuario;

public class PanelUsuario extends JPanel
{
	private Usuario usuario;
	private JLabel nombre;
	private JLabel saldo;
	
	public PanelUsuario()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		
		usuario = new Usuario("Juan Camilo", 500000);
		
		nombre = new JLabel("Usuario: " + usuario.getNombre());
		saldo = new JLabel("Saldo: " + String.format("$%,.2f", usuario.getSaldo()));
		
		add(nombre);
		add(saldo);
	}
}
