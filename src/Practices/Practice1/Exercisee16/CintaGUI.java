/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee16;

/**
 *
 * @author cvict
 */

// CintaGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CintaGUI extends JFrame {
    private ApplicationCinta cinta;
    private JLabel labelCinta;
    private JLabel labelPosicion;
    private JLabel labelCaracter;
    private JButton btnAvanzar;
    private JButton btnRetroceder;
    private JButton btnReg;
    private JButton btnSiguientePalabra;
    private JButton btnRetrocederPalabra;
    private JButton btnPausa;
    private JButton btnStop;

    public CintaGUI() {
        cinta = new ApplicationCinta("Una frase");

        setTitle("Cinta de Caracteres");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelCinta = new JLabel("Cinta: " + cinta.toString());
        labelCinta.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPosicion = new JLabel("Posición del cabezal: 0");
        labelPosicion.setFont(new Font("Arial", Font.PLAIN, 16));
        labelCaracter = new JLabel("Caracter registrado: ");
        labelCaracter.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(labelCinta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelPosicion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelCaracter, gbc);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 3, 10, 10));
        panelBotones.setBackground(Color.WHITE);

        btnAvanzar = new JButton("Avanzar");
        btnAvanzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.avanzar();
                actualizarLabels();
            }
        });

        btnRetroceder = new JButton("Retroceder");
        btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.retroceder();
                actualizarLabels();
            }
        });

        btnReg = new JButton("REG");
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String caracter = cinta.reg();
                labelCaracter.setText("Caracter registrado: " + caracter);
            }
        });

        btnSiguientePalabra = new JButton("Siguiente Palabra");
        btnSiguientePalabra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.siguientePalabra();
                actualizarLabels();
            }
        });

        btnRetrocederPalabra = new JButton("Retroceder Palabra");
        btnRetrocederPalabra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.retrocederPalabra();
                actualizarLabels();
            }
        });

        btnPausa = new JButton("Pausa");
        btnPausa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.pausa();
            }
        });

        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cinta.stop();
                actualizarLabels();
            }
        });

        panelBotones.add(btnAvanzar);
        panelBotones.add(btnRetroceder);
        panelBotones.add(btnReg);
        panelBotones.add(btnSiguientePalabra);
        panelBotones.add(btnRetrocederPalabra);
        panelBotones.add(btnStop);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(panelBotones, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnPausa, gbc);
    }

    private void actualizarLabels() {
        labelCinta.setText("Cinta: " + cinta.toString());
        labelPosicion.setText("Posición del cabezal: " + cinta.getPosicion());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CintaGUI().setVisible(true);
            }
        });
    }
}
