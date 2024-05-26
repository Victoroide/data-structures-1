/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee12;

/**
 *
 * @author cvict
 */

// MatrizGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatrizGUI extends JFrame {
    private ApplicationMatriz matriz1;
    private ApplicationMatriz matriz2;
    private JTextArea areaResultado;
    private JTextField campoFilas;
    private JTextField campoColumnas;
    private JTextField campoFila;
    private JTextField campoColumna;
    private JTextField campoValor;
    private JTextField campoEscalar;
    private JButton btnAsignarMatriz1;
    private JButton btnAsignarMatriz2;
    private JButton btnSumar;
    private JButton btnProductoEscalar;
    private JButton btnCrearMatrices;

    public MatrizGUI() {
        setTitle("Gestión de Matrices");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelFilas = new JLabel("Filas: ");
        JLabel labelColumnas = new JLabel("Columnas: ");
        JLabel labelFila = new JLabel("Fila (1-indexed): ");
        JLabel labelColumna = new JLabel("Columna (1-indexed): ");
        JLabel labelValor = new JLabel("Valor: ");
        JLabel labelEscalar = new JLabel("Escalar: ");
        campoFilas = new JTextField(5);
        campoColumnas = new JTextField(5);
        campoFila = new JTextField(5);
        campoColumna = new JTextField(5);
        campoValor = new JTextField(5);
        campoEscalar = new JTextField(5);

        areaResultado = new JTextArea(15, 30);
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);

        btnCrearMatrices = new JButton("Crear Matrices");
        btnCrearMatrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filas = Integer.parseInt(campoFilas.getText());
                int columnas = Integer.parseInt(campoColumnas.getText());
                matriz1 = new ApplicationMatriz(filas, columnas);
                matriz2 = new ApplicationMatriz(filas, columnas);
                actualizarResultado();
            }
        });

        btnAsignarMatriz1 = new JButton("Asignar Valor en Matriz 1");
        btnAsignarMatriz1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = Integer.parseInt(campoFila.getText()) - 1;
                int columna = Integer.parseInt(campoColumna.getText()) - 1;
                int valor = Integer.parseInt(campoValor.getText());
                matriz1.asignar(fila, columna, valor);
                actualizarResultado();
            }
        });

        btnAsignarMatriz2 = new JButton("Asignar Valor en Matriz 2");
        btnAsignarMatriz2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = Integer.parseInt(campoFila.getText()) - 1;
                int columna = Integer.parseInt(campoColumna.getText()) - 1;
                int valor = Integer.parseInt(campoValor.getText());
                matriz2.asignar(fila, columna, valor);
                actualizarResultado();
            }
        });

        btnSumar = new JButton("Sumar Matrices");
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ApplicationMatriz resultado = matriz1.sumar(matriz2);
                    areaResultado.setText("Matriz 1:\n" + matriz1.toString() + "\n" + 
                                          "Matriz 2:\n" + matriz2.toString() + "\n" + 
                                          "Suma de Matrices:\n" + resultado.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnProductoEscalar = new JButton("Producto Escalar Matriz 1");
        btnProductoEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int escalar = Integer.parseInt(campoEscalar.getText());
                ApplicationMatriz resultado = matriz1.productoEscalar(escalar);
                areaResultado.setText("Matriz 1:\n" + matriz1.toString() + "\n" + 
                                      "Producto Escalar de Matriz 1:\n" + resultado.toString());
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelFilas, gbc);
        gbc.gridx = 1;
        add(campoFilas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelColumnas, gbc);
        gbc.gridx = 1;
        add(campoColumnas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnCrearMatrices, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(labelFila, gbc);
        gbc.gridx = 1;
        add(campoFila, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(labelColumna, gbc);
        gbc.gridx = 1;
        add(campoColumna, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(labelValor, gbc);
        gbc.gridx = 1;
        add(campoValor, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(btnAsignarMatriz1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(btnAsignarMatriz2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(labelEscalar, gbc);
        gbc.gridx = 1;
        add(campoEscalar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(btnProductoEscalar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        add(btnSumar, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 11;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);
    }

    private void actualizarResultado() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz 1:\n").append(matriz1.toString()).append("\n");
        sb.append("Matriz 2:\n").append(matriz2.toString());
        areaResultado.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatrizGUI().setVisible(true);
            }
        });
    }
}
