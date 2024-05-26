/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee12;

/**
 *
 * @author cvict
 */

public class Matriz {
    public static void main(String[] args) {
        ApplicationMatriz matriz1 = new ApplicationMatriz(2, 3);
        ApplicationMatriz matriz2 = new ApplicationMatriz(2, 3);

        matriz1.asignar(0, 0, 1);
        matriz1.asignar(0, 1, 2);
        matriz1.asignar(0, 2, 3);
        matriz1.asignar(1, 0, 4);
        matriz1.asignar(1, 1, 5);
        matriz1.asignar(1, 2, 6);

        matriz2.asignar(0, 0, 6);
        matriz2.asignar(0, 1, 5);
        matriz2.asignar(0, 2, 4);
        matriz2.asignar(1, 0, 3);
        matriz2.asignar(1, 1, 2);
        matriz2.asignar(1, 2, 1);

        System.out.println("Matriz 1:");
        System.out.println(matriz1);

        System.out.println("Matriz 2:");
        System.out.println(matriz2);

        ApplicationMatriz suma = matriz1.sumar(matriz2);
        System.out.println("Suma de Matriz 1 y Matriz 2:");
        System.out.println(suma);

        ApplicationMatriz producto = matriz1.productoEscalar(2);
        System.out.println("Producto escalar de Matriz 1 por 2:");
        System.out.println(producto);
    }
}

