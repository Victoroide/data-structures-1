/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee14;

/**
 *
 * @author cvict
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplejoRealGUI extends JFrame {
    private ApplicationComplejoReal complejo1;
    private ApplicationComplejoReal complejo2;
    private JLabel labelResultado;
    private JTextField campoParteReal1;
    private JTextField campoParteImaginaria1;
    private JTextField campoParteReal2;
    private JTextField campoParteImaginaria2;
    private JButton btnEstablecer;
    private JButton btnAgregarComplejo;
    private JButton btnAgregarComponentes;

    public ComplejoRealGUI() {
        complejo1 = new ApplicationComplejoReal();
        complejo2 = new ApplicationComplejoReal();

        setTitle("Gestión de Números Complejos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelResultado = new JLabel("Resultado: ");
        labelResultado.setFont(new Font("Arial", Font.BOLD, 16));

        campoParteReal1 = new JTextField(5);
        campoParteImaginaria1 = new JTextField(5);
        campoParteReal2 = new JTextField(5);
        campoParteImaginaria2 = new JTextField(5);

        btnEstablecer = new JButton("Establecer Complejo 1");
        btnEstablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double parteReal = Double.parseDouble(campoParteReal1.getText());
                double parteImaginaria = Double.parseDouble(campoParteImaginaria1.getText());
                complejo1.establecer(parteReal, parteImaginaria);
                actualizarResultado();
            }
        });

        btnAgregarComplejo = new JButton("Agregar Complejo 2 a Complejo 1");
        btnAgregarComplejo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double parteReal = Double.parseDouble(campoParteReal2.getText());
                double parteImaginaria = Double.parseDouble(campoParteImaginaria2.getText());
                complejo2.establecer(parteReal, parteImaginaria);
                complejo1.agregar(complejo2);
                actualizarResultado();
            }
        });

        btnAgregarComponentes = new JButton("Agregar Componentes a Complejo 1");
        btnAgregarComponentes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double parteReal = Double.parseDouble(campoParteReal2.getText());
                double parteImaginaria = Double.parseDouble(campoParteImaginaria2.getText());
                complejo1.agregar(parteReal, parteImaginaria);
                actualizarResultado();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(labelResultado, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Parte Real 1: "), gbc);
        gbc.gridx = 1;
        add(campoParteReal1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Parte Imaginaria 1: "), gbc);
        gbc.gridx = 1;
        add(campoParteImaginaria1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnEstablecer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Parte Real 2: "), gbc);
        gbc.gridx = 1;
        add(campoParteReal2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Parte Imaginaria 2: "), gbc);
        gbc.gridx = 1;
        add(campoParteImaginaria2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnAgregarComplejo, gbc);

        gbc.gridx = 1;
        add(btnAgregarComponentes, gbc);
    }

    private void actualizarResultado() {
        labelResultado.setText("Resultado: " + complejo1.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComplejoRealGUI().setVisible(true);
            }
        });
    }
}

