package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelListaCarrito extends JPanel
{
	
	private JTable listaProductos;
	private JLabel lbltotal;
	private JTextField txttotal;
	
	
	public PanelListaCarrito()
	{
		setLayout(new BorderLayout());
		
		
		TitledBorder borde = BorderFactory.createTitledBorder("Carrito");
		borde.setTitleColor(Color.BLACK);
		setBorder(borde);
		
		lbltotal = new JLabel("Total:");
		txttotal = new JTextField(10);
		txttotal.setEditable(false);
		
		
		String[] columnas = {"Título", "Precio", "Cantidad", "Subtotal"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
		listaProductos = new JTable(modeloTabla);
		JScrollPane scroll = new JScrollPane(listaProductos);
		
		add(scroll, BorderLayout.CENTER);
		
		JPanel panelSur = new JPanel();
		panelSur.add(lbltotal);
		panelSur.add(txttotal);
		add(panelSur, BorderLayout.SOUTH);
		
	}
	

}
