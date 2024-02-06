package cinesElorrieta.vista;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
public class Resumen {
	
	private JPanel panel = null;
	private JTable table;
	
	
	public Resumen(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(219, 50, 242, 263);
		panel.add(table);
		
	}


	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}
}


	