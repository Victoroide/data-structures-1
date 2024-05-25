/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee11;

/**
 *
 * @author cvict
 */

public class Bolsa {
    public static void main(String[] args) {
        ApplicationBolsa bolsa1 = new ApplicationBolsa();
        ApplicationBolsa bolsa2 = new ApplicationBolsa();

        bolsa1.añadir(1);
        bolsa1.añadir(2);
        bolsa1.añadir(2);

        bolsa2.añadir(3);
        bolsa2.añadir(2);
        bolsa2.añadir(4);

        System.out.println("Bolsa 1: " + bolsa1);
        System.out.println("Bolsa 2: " + bolsa2);

        System.out.println("Bolsa 1 está vacía: " + bolsa1.bolsaVacia());
        System.out.println("Bolsa 2 está vacía: " + bolsa2.bolsaVacia());

        System.out.println("Elemento 2 está en bolsa 1: " + bolsa1.dentro(2));
        System.out.println("Elemento 5 está en bolsa 2: " + bolsa2.dentro(5));

        System.out.println("Cuántos 2 hay en bolsa 1: " + bolsa1.cuantos(2));
        System.out.println("Cuántos 3 hay en bolsa 2: " + bolsa2.cuantos(3));

        ApplicationBolsa union = bolsa1.union(bolsa2);
        System.out.println("Unión de bolsa 1 y bolsa 2: " + union);

        System.out.println("Total de elementos en bolsa 1: " + bolsa1.total());
        System.out.println("Total de elementos en bolsa 2: " + bolsa2.total());
        System.out.println("Total de elementos en la unión: " + union.total());
    }
}
