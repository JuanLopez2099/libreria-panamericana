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
	
	public PanelFormulario()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblcodigo = new JLabel("Codigo:");
		txtcodigo = new JTextField("");
		lbltitulo = new JLabel("Titulo:");
		txttitulo = new JTextField("");
		
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
		
	}
}
