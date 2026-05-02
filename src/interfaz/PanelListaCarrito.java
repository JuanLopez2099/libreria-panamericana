package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelListaCarrito extends JPanel
{
    private JTable listaProductos;

    public PanelListaCarrito()
    {
        setLayout(new BorderLayout());

        TitledBorder borde = BorderFactory.createTitledBorder("Carrito");
        borde.setTitleColor(Color.BLACK);
        setBorder(borde);

        String[] columnas = {"Título", "Precio", "Cantidad", "Subtotal"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        listaProductos = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(listaProductos);

        add(scroll, BorderLayout.CENTER);
    }
}