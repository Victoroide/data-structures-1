/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee15;

/**
 *
 * @author cvict
 */

// FechaGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FechaGUI extends JFrame {
    private ApplicationFecha fecha;
    private JLabel labelFecha;
    private JTextField campoDia;
    private JTextField campoMes;
    private JTextField campoAño;
    private JTextField campoAdelantarDia;
    private JTextField campoAdelantarMes;
    private JTextField campoAdelantarAño;
    private JButton btnEstablecer;
    private JButton btnProximaFecha;
    private JButton btnCambiarDia;
    private JButton btnCambiarMes;
    private JButton btnCambiarAño;
    private JButton btnReiniciar;
    private JButton btnAdelantar;

    public FechaGUI() {
        fecha = new ApplicationFecha(1, 1, 2000);  // Inicializamos con una fecha por defecto

        setTitle("Gestión de Fechas");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelFecha = new JLabel("Fecha: " + fecha.toString());
        labelFecha.setFont(new Font("Arial", Font.PLAIN, 16));
        
        campoDia = new JTextField(2);
        campoMes = new JTextField(2);
        campoAño = new JTextField(4);
        campoAdelantarDia = new JTextField(2);
        campoAdelantarMes = new JTextField(2);
        campoAdelantarAño = new JTextField(4);

        btnEstablecer = new JButton("Establecer Fecha");
        btnEstablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(campoDia.getText());
                int mes = Integer.parseInt(campoMes.getText());
                int año = Integer.parseInt(campoAño.getText());
                fecha.establecerFecha(dia, mes, año);
                actualizarLabels();
            }
        });

        btnProximaFecha = new JButton("Próxima Fecha");
        btnProximaFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String proximaFecha = fecha.obtenerProximaFecha();
                labelFecha.setText("Próxima Fecha: " + proximaFecha);
            }
        });

        btnCambiarDia = new JButton("Cambiar Día");
        btnCambiarDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(campoDia.getText());
                fecha.cambiarDia(dia);
                actualizarLabels();
            }
        });

        btnCambiarMes = new JButton("Cambiar Mes");
        btnCambiarMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int mes = Integer.parseInt(campoMes.getText());
                fecha.cambiarMes(mes);
                actualizarLabels();
            }
        });

        btnCambiarAño = new JButton("Cambiar Año");
        btnCambiarAño.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int año = Integer.parseInt(campoAño.getText());
                fecha.cambiarAño(año);
                actualizarLabels();
            }
        });

        btnReiniciar = new JButton("Reiniciar Fecha");
        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(campoDia.getText());
                int mes = Integer.parseInt(campoMes.getText());
                int año = Integer.parseInt(campoAño.getText());
                fecha.reiniciar(dia, mes, año);
                actualizarLabels();
            }
        });

        btnAdelantar = new JButton("Adelantar Fecha");
        btnAdelantar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(campoAdelantarDia.getText());
                int mes = Integer.parseInt(campoAdelantarMes.getText());
                int año = Integer.parseInt(campoAdelantarAño.getText());
                fecha.adelantar(dia, mes, año);
                actualizarLabels();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(labelFecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Día: "), gbc);
        gbc.gridx = 1;
        add(campoDia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Mes: "), gbc);
        gbc.gridx = 1;
        add(campoMes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Año: "), gbc);
        gbc.gridx = 1;
        add(campoAño, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnEstablecer, gbc);

        gbc.gridx = 1;
        add(btnProximaFecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(btnCambiarDia, gbc);

        gbc.gridx = 1;
        add(btnCambiarMes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnCambiarAño, gbc);

        gbc.gridx = 1;
        add(btnReiniciar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Adelantar Días: "), gbc);
        gbc.gridx = 1;
        add(campoAdelantarDia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("Adelantar Meses: "), gbc);
        gbc.gridx = 1;
        add(campoAdelantarMes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("Adelantar Años: "), gbc);
        gbc.gridx = 1;
        add(campoAdelantarAño, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        add(btnAdelantar, gbc);
    }

    private void actualizarLabels() {
        labelFecha.setText("Fecha: " + fecha.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FechaGUI().setVisible(true);
            }
        });
    }
}
