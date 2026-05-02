package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import excepciones.CarritoVacioException;
import excepciones.StockInsuficienteException;
import mundo.CarritoCompra;
import mundo.ItemCarrito;

public class InterfazCarrito extends JDialog implements ActionListener
{
    private PanelListaCarrito panelListaCarrito;
    private JLabel lbltotal;
    private JTextField txttotal;
    private JLabel lbltitulo;
    private JTextField txttitulo;
    private JButton btncomprar;
    private JButton btnañadir;
    private JButton btnquitar;
    private CarritoCompra carrito;
    private ItemCarrito itemSeleccionado;

    public InterfazCarrito(JFrame padre, CarritoCompra carrito) 
    {
    	super(padre, "Carrito de Compra", true);
    	
    	this.carrito = carrito;
        
        setSize(700, 450);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);

        panelListaCarrito = new PanelListaCarrito();

        lbltotal = new JLabel("Total:");
        txttotal = new JTextField(10);
        txttotal.setEditable(false);

        lbltitulo = new JLabel("Titulo");
        txttitulo = new JTextField("");
        txttitulo.setEditable(false);

        btncomprar = new JButton("Comprar 🛍️");
        btncomprar.addActionListener(this);
        
        btnañadir = new JButton("➕");
        btnañadir.addActionListener(this);
        
        btnquitar = new JButton("➖");
        btnquitar.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(panelListaCarrito, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.gridx = 0;
        add(lbltitulo, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        add(txttitulo, gbc);

        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(btnquitar, gbc);

        gbc.gridx = 3;
        add(btnañadir, gbc);

        gbc.gridx = 4;
        add(lbltotal, gbc);

        gbc.gridx = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        add(txttotal, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(btncomprar, gbc);
        
        panelListaCarrito.getTabla().getSelectionModel().addListSelectionListener(e ->
        {
            int fila = panelListaCarrito.getTabla().getSelectedRow();
            if(fila >= 0 && fila < carrito.getItems().size())
            {
                itemSeleccionado = carrito.getItems().get(fila);
                txttitulo.setText(itemSeleccionado.getProducto().getTitulo());
            }
        });
        

        mostrarCarrito();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) 
	{
    	if(e.getSource() == btnañadir)
    	{
    		if(itemSeleccionado != null)
    	    {
    	        itemSeleccionado.incrementarCantidad();
    	        mostrarCarrito();
    	    }
    	}
    	else if(e.getSource() == btnquitar)
    	{
    		if(itemSeleccionado != null)
    	    {
    	        if(itemSeleccionado.getCantidad() == 1)
    	        {
    	            carrito.eliminarProducto(itemSeleccionado.getProducto());
    	            itemSeleccionado = null;
    	            txttitulo.setText("");
    	        }
    	        else
    	        {
    	            itemSeleccionado.decrementarCantidad();
    	        }
    	        mostrarCarrito();
    	    }
    	}
    	else if(e.getSource() == btncomprar)
    	{
    		try
    		{
    			carrito.comprar();
    			mostrarCarrito();
    			txttitulo.setText("");
    	        itemSeleccionado = null;
    	        JOptionPane.showMessageDialog(this, "¡Compra realizada con éxito!", "Compra", JOptionPane.INFORMATION_MESSAGE);
    	        dispose();
    		}
    		catch(CarritoVacioException ex)
    		{
    			JOptionPane.showMessageDialog(this, ex.getMessage(), "Carrito Vacío", JOptionPane.ERROR_MESSAGE);
    		}
    		catch(StockInsuficienteException ex)
    		{
    			 JOptionPane.showMessageDialog(this, ex.getMessage(), "Stock Insuficiente", JOptionPane.ERROR_MESSAGE);
    		}
    	}
		
	}
    private void mostrarCarrito()
    {
        DefaultTableModel modelo = (DefaultTableModel) panelListaCarrito.getModelo();
        modelo.setRowCount(0); 
        
        for(ItemCarrito item : carrito.getItems())
        {
            modelo.addRow(new Object[]{
                item.getProducto().getTitulo(),
                "$" + item.getProducto().getPrecio(),
                item.getCantidad(),
                "$" + item.getSubtotal()
            });
        }
        
        txttotal.setText("$" + carrito.calcularTotal());
    }

	
}