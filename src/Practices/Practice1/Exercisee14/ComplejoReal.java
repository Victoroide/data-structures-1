/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee14;

/**
 *
 * @author cvict
 */

public class ComplejoReal {
    public static void main(String[] args) {
        ApplicationComplejoReal complejo1 = new ApplicationComplejoReal();
        ApplicationComplejoReal complejo2 = new ApplicationComplejoReal();

        complejo1.establecer(3.0, 4.0);
        complejo2.establecer(1.5, -2.5);

        System.out.println("Complejo 1:");
        complejo1.imprimir();

        System.out.println("Complejo 2:");
        complejo2.imprimir();

        complejo1.agregar(complejo2);
        System.out.println("Después de agregar Complejo 2 a Complejo 1:");
        complejo1.imprimir();

        complejo1.agregar(2.0, 3.0);
        System.out.println("Después de agregar (2.0, 3.0) a Complejo 1:");
        complejo1.imprimir();
    }
}