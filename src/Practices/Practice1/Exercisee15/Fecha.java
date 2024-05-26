/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee15;

/**
 *
 * @author cvict
 */

public class Fecha {
    public static void main(String[] args) {
        ApplicationFecha fecha = new ApplicationFecha(28, 2, 2020);
        fecha.imprimir();

        System.out.println("Próxima fecha: " + fecha.obtenerProximaFecha());
        System.out.println("Formato largo: " + fecha.formatoLargo());

        fecha.cambiarDia(15);
        fecha.cambiarMes(3);
        fecha.cambiarAño(2021);
        fecha.imprimir();

        fecha.reiniciar(31, 12, 2021);
        fecha.imprimir();

        fecha.adelantar(1, 1, 1);
        fecha.imprimir();
    }
}