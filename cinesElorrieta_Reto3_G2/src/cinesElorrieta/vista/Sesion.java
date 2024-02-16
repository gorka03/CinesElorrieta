package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.controller.GestorPeliculas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sesion {
    private JPanel panel = null;
    private static JTable tableSesion;

    public Sesion(ArrayList<JPanel> paneles) {
        panel = new JPanel();
        panel.setBounds(0, 0, 650, 470);

        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                paneles.get(1).setVisible(true);
                paneles.get(2).setVisible(false);

            }
        });
        btnVolver.setBounds(123, 379, 143, 23);
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(btnVolver);

        ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
        JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
        imgLogo.setBounds(10, 11, 198, 81);
        imgLogo.setIcon(imageLogo);
        panel.add(imgLogo);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(panel, "Mensaje", "Titulo del Diálogo",
                        JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {

                    JOptionPane.showMessageDialog(panel, "Guardado correctamente ");
                    paneles.get(2).setVisible(false);
                    paneles.get(1).setVisible(true);
                    pasarPosicionComboBox(null);
                } else {
                    System.out.println("");
                }

            }
        });
        btnConfirmar.setBounds(411, 381, 152, 23);
        btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(btnConfirmar);

        tableSesion = new JTable();
        tableSesion.setModel(new DefaultTableModel(
                new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, },
                new String[] { "Sesion", "Hora" }));
        tableSesion.setBorder(new LineBorder(new Color(0, 0, 0), 4));
        tableSesion.setBounds(113, 104, 450, 266);
        panel.add(tableSesion);

    }

    public JPanel getPanel() {
        return panel;
    }

    public static void pasarPosicionComboBox(JComboBox<String> comboBoxCines) {
        comboBoxCines.setSelectedItem(null);
    }

    public static void cargardatosPeliculasEnTabla(int idPelicula) {
        String[] columnas = { "Título", "Nombre", "Titulo", "Genero", "Coste", "Fecha", "Hora", "Sala" };
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

        ArrayList<String> datosPelicula = GestorPeliculas.obtenerDatosPelicula(idPelicula);

        if (datosPelicula.size() == columnas.length) {
            modeloTabla.addRow(datosPelicula.toArray());
        }

        tableSesion.setModel(modeloTabla);
    }
}