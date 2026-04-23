package interfaz;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class InterfazCarrito extends JDialog
{
	private PanelListaCarrito panelListaCarrito;
	private JButton btncomprar;
	
	
	public InterfazCarrito(JFrame padre)
	{
		super(padre, "Carrito de Compra", true);
		setSize(700, 450);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(padre);
		
		panelListaCarrito = new PanelListaCarrito();
		add(panelListaCarrito, BorderLayout.CENTER);
		
		btncomprar = new JButton("Comprar 🛍️");
		
		add(btncomprar, BorderLayout.SOUTH);
	}



}
