/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise5;

/**
 *
 * @author cvict
 */
public class ApplicationPeriodo {
    public static void main(String[] args) {
        Periodo periodoDias = Periodo.createFromDays(66);
        Periodo periodoMesesDias = Periodo.createFromMonthsAndDays(2, 6);
        Periodo periodoCompleto = Periodo.createFromYearsMonthsDays(2, 3, 7);

        System.out.println("Periodo sólo en días: " + periodoDias);
        System.out.println("Periodo en meses y días: " + periodoMesesDias);
        System.out.println("Periodo en años, meses y días: " + periodoCompleto);

        System.out.println("\nEl periodo de sólo días traducido a días es: " + periodoDias.translateToDays() + " días");
        System.out.println("El periodo de meses y días traducido a días es: " + periodoMesesDias.translateToDays() + " días");
        System.out.println("El periodo completo traducido a días es: " + periodoCompleto.translateToDays() + " días");
    }
}
