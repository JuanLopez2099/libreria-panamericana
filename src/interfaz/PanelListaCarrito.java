package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Panel que muestra la lista de productos agregados al carrito.
 *
 * Permite visualizar los productos seleccionados por el usuario
 * junto con su precio, cantidad y subtotal.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class PanelListaCarrito extends JPanel
{
    private JTable listaProductos;
    private DefaultTableModel modeloTabla;

    /**
     * Construye el panel de lista del carrito.
     *
     * @pre true
     * @post Se inicializan los componentes de la tabla del carrito
     */
    public PanelListaCarrito()
    {
        setLayout(new BorderLayout());

        TitledBorder borde = BorderFactory.createTitledBorder("Carrito");
        borde.setTitleColor(Color.BLACK);
        setBorder(borde);

        String[] columnas = {"Título", "Precio", "Cantidad", "Subtotal"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        listaProductos = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(listaProductos);

        add(scroll, BorderLayout.CENTER);
    }
    
    /**
     * Retorna el modelo de la tabla del carrito.
     *
     * @pre modeloTabla != null
     * @post Se retorna la referencia al modelo de la tabla
     *
     * @return Modelo de la tabla del carrito
     */
    public DefaultTableModel getModelo()
    {
        return modeloTabla;
    }
    
    /**
     * Retorna la tabla que muestra los productos del carrito.
     *
     * @pre listaProductos != null
     * @post Se retorna la referencia a la tabla
     *
     * @return Tabla de productos del carrito
     */
    public JTable getTabla()
    {
        return listaProductos;
    }
}