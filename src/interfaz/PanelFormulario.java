package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
}
