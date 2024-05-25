/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee10;

/**
 *
 * @author cvict
 */

public class Natural {
    public static void main(String[] args) {
        ApplicationNatural cero = ApplicationNatural.cero();
        ApplicationNatural uno = cero.sucesor();
        ApplicationNatural dos = uno.sucesor();

        System.out.println("Cero: " + cero);
        System.out.println("Uno: " + uno);
        System.out.println("Dos: " + dos);

        System.out.println("Es cero: " + cero.esCero());
        System.out.println("Uno es igual a dos: " + uno.igual(dos));

        ApplicationNatural suma = uno.suma(dos);
        System.out.println("Suma de uno y dos: " + suma);

        ApplicationNatural antecesorDeDos = dos.antecesor();
        System.out.println("Antecesor de dos: " + antecesorDeDos);

        ApplicationNatural diferencia = dos.diferencia(uno);
        System.out.println("Diferencia de dos y uno: " + diferencia);

        System.out.println("Uno es menor que dos: " + uno.menor(dos));
    }
}

