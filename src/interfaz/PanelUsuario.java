package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mundo.Usuario;

public class PanelUsuario extends JPanel
{
	private Usuario usuario;
	private JLabel nombre;
	private JLabel saldo;
	
	public PanelUsuario(Usuario usuario)
	{
		setLayout(new BorderLayout());
	    
	    this.usuario = usuario;
	    
	    JLabel banner = new JLabel(new ImageIcon("img/banner.png"));
	    add(banner, BorderLayout.NORTH);
	    
	    
	    JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
	    nombre = new JLabel("Usuario: " + usuario.getNombre());
	    saldo = new JLabel("Saldo: " + String.format("$%,.2f", usuario.getSaldo()));
	    panelInfo.add(nombre);
	    panelInfo.add(saldo);
	    add(panelInfo, BorderLayout.CENTER);
	}
	
	public void actualizarSaldo()
	{
	    saldo.setText("Saldo: " + String.format("$%,.2f", usuario.getSaldo()));
	}
}
