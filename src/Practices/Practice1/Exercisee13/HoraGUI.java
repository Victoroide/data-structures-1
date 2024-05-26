/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee13;

/**
 *
 * @author cvict
 */

// HoraGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoraGUI extends JFrame {
    private ApplicationHora hora;
    private JLabel labelHora;
    private JTextField campoHoras;
    private JTextField campoMinutos;
    private JTextField campoSegundos;
    private JButton btnEstablecer;
    private JButton btnAdelantar;
    private JButton btnReiniciar;

    public HoraGUI() {
        hora = new ApplicationHora(0, 0, 0); // Inicializamos con una hora por defecto

        setTitle("Gestión de Hora");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelHora = new JLabel("Hora actual: " + hora.toString());
        labelHora.setFont(new Font("Arial", Font.BOLD, 16));

        campoHoras = new JTextField(2);
        campoMinutos = new JTextField(2);
        campoSegundos = new JTextField(2);

        btnEstablecer = new JButton("Establecer Hora");
        btnEstablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int horas = Integer.parseInt(campoHoras.getText());
                int minutos = Integer.parseInt(campoMinutos.getText());
                int segundos = Integer.parseInt(campoSegundos.getText());
                hora.reiniciar(horas, minutos, segundos);
                actualizarHora();
            }
        });

        btnAdelantar = new JButton("Adelantar Hora");
        btnAdelantar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int horas = Integer.parseInt(campoHoras.getText());
                int minutos = Integer.parseInt(campoMinutos.getText());
                int segundos = Integer.parseInt(campoSegundos.getText());
                hora.adelantar(horas, minutos, segundos);
                actualizarHora();
            }
        });

        btnReiniciar = new JButton("Reiniciar Hora");
        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int horas = Integer.parseInt(campoHoras.getText());
                int minutos = Integer.parseInt(campoMinutos.getText());
                int segundos = Integer.parseInt(campoSegundos.getText());
                hora.reiniciar(horas, minutos, segundos);
                actualizarHora();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(labelHora, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Horas: "), gbc);
        gbc.gridx = 1;
        add(campoHoras, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Minutos: "), gbc);
        gbc.gridx = 1;
        add(campoMinutos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Segundos: "), gbc);
        gbc.gridx = 1;
        add(campoSegundos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnEstablecer, gbc);

        gbc.gridx = 1;
        add(btnAdelantar, gbc);

        gbc.gridx = 2;
        add(btnReiniciar, gbc);
    }

    private void actualizarHora() {
        labelHora.setText("Hora actual: " + hora.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HoraGUI().setVisible(true);
            }
        });
    }
}

