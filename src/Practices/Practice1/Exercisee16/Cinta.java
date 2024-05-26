/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee16;

/**
 *
 * @author cvict
 */

public class Cinta {
    public static void main(String[] args) {
        ApplicationCinta cinta = new ApplicationCinta("Una frase");

        cinta.imprimir();

        cinta.avanzar();
        cinta.imprimir();

        cinta.avanzar();
        cinta.avanzar();
        cinta.avanzar();
        cinta.imprimir();

        cinta.reg();
        
        cinta.siguientePalabra();
        cinta.imprimir();

        cinta.retrocederPalabra();
        cinta.imprimir();

        cinta.pausa();

        cinta.stop();
        cinta.imprimir();
    }
}