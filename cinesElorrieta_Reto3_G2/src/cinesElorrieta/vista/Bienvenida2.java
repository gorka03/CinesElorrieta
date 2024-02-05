package cinesElorrieta.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Bienvenida2{

	private JPanel panel = null;
	
	/**
	 * Create the panel.
	 */
	public Bienvenida2(ArrayList<JPanel> paneles) {
		panel = new JPanel() ;
		panel.setBounds(100, 100, 650, 470);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(113, 282, 89, 23);
		panel.add(btnNewButton);
		panel.setLayout(null);

	}
	public JPanel getPanel (){
		
		return panel ;
	}
}
