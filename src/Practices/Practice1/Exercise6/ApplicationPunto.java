/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise6;

/**
 *
 * @author cvict
 */
import java.awt.Color;

public class ApplicationPunto {
    public static void main(String[] args) {
        Punto punto = new Punto(10, 20);
        System.out.println("Estado inicial del punto:");
        System.out.println(punto);

        punto.movePoint(15, 25);
        System.out.println("\nDespués de mover el punto:");
        System.out.println(punto);

        punto.setColor(Color.RED);
        System.out.println("\nDespués de cambiar el color:");
        System.out.println(punto);

        punto.setSize(3);
        System.out.println("\nDespués de cambiar el tamaño:");
        System.out.println(punto);

        punto.setVisible(false);
        System.out.println("\nDespués de cambiar la visibilidad:");
        System.out.println(punto);
    }
}
