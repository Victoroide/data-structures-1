/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise8;

/**
 *
 * @author cvict
 */

public class ConjuntoRango {
    public static void main(String[] args) {
        ApplicationConjuntoRango conjunto1 = new ApplicationConjuntoRango(1, 10);
        ApplicationConjuntoRango conjunto2 = new ApplicationConjuntoRango(5, 15);

        conjunto1.insertar(3);
        conjunto1.insertar(7);
        conjunto1.insertar(11); // No se insertará

        conjunto2.insertar(5);
        conjunto2.insertar(10);
        conjunto2.insertar(12);

        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        System.out.println("Unión de Conjunto 1 y Conjunto 2: " + conjunto1.union(conjunto2));
        System.out.println("Intersección de Conjunto 1 y Conjunto 2: " + conjunto1.interseccion(conjunto2));
        System.out.println("Diferencia de Conjunto 1 y Conjunto 2: " + conjunto1.diferencia(conjunto2));
    }
}
