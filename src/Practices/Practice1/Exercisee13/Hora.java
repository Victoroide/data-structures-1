/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee13;

/**
 *
 * @author cvict
 */

public class Hora {
    public static void main(String[] args) {
        ApplicationHora hora = new ApplicationHora(10, 30, 45);
        hora.imprimir();

        hora.adelantar(2, 40, 30);
        hora.imprimir();

        hora.reiniciar(23, 59, 59);
        hora.imprimir();

        hora.adelantar(0, 0, 1);
        hora.imprimir();
    }
}