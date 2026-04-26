package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfazCarrito extends JDialog
{
    private PanelListaCarrito panelListaCarrito;
    private JLabel lbltotal;
    private JTextField txttotal;
    private JLabel lblcodigo;
    private JTextField txtcodigo;
    private JButton btncomprar;
    private JButton btnañadir;
    private JButton btnquitar;

    public InterfazCarrito(JFrame padre)
    {
        super(padre, "Carrito de Compra", true);
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

        lblcodigo = new JLabel("Codigo");
        txtcodigo = new JTextField("");
        txtcodigo.setEditable(false);

        btncomprar = new JButton("Comprar 🛍️");
        btnañadir = new JButton("➕");
        btnquitar = new JButton("➖");

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
        add(lblcodigo, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        add(txtcodigo, gbc);

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
    }
}