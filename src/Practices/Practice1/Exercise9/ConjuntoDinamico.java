/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise9;

/**
 *
 * @author cvict
 */

public class ConjuntoDinamico {
    public static void main(String[] args) {
        ApplicationConjuntoDinamico conjunto1 = new ApplicationConjuntoDinamico();
        ApplicationConjuntoDinamico conjunto2 = new ApplicationConjuntoDinamico();

        conjunto1.insertar(3);
        conjunto1.insertar(7);
        conjunto1.insertar(11);

        conjunto2.insertar(5);
        conjunto2.insertar(7);
        conjunto2.insertar(12);

        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        System.out.println("Unión de Conjunto 1 y Conjunto 2: " + conjunto1.union(conjunto2));
        System.out.println("Intersección de Conjunto 1 y Conjunto 2: " + conjunto1.interseccion(conjunto2));
        System.out.println("Diferencia de Conjunto 1 y Conjunto 2: " + conjunto1.diferencia(conjunto2));
    }
}
