/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise4;

/**
 *
 * @author cvict
 */
public class ApplicationFecha {
    public static void main(String[] args) {
        char[] dateTextShort = {'3', '0', '1', '2', '0', '9'}; // Example: 30 December 2009
        char[] dateTextLong = {'3', '0', '1', '2', '1', '9', '8', '9'}; // Example: 30 December 1989
        
        Fecha fechaCorta = Fecha.createFromTextWithTwoDigitYear(dateTextShort);
        Fecha fechaLarga = Fecha.createFromTextWithFullYear(dateTextLong);

        System.out.println("Fecha con año de dos dígitos: " + fechaCorta);
        System.out.println("Fecha con año completo: " + fechaLarga);

        System.out.println("\nDía de fecha corta: " + fechaCorta.getDay());
        System.out.println("Mes de fecha corta: " + fechaCorta.getMonth());
        System.out.println("Año de fecha corta: " + fechaCorta.getYear());
        
        System.out.println("\nDía de fecha larga: " + fechaLarga.getDay());
        System.out.println("Mes de fecha larga: " + fechaLarga.getMonth());
        System.out.println("Año de fecha larga: " + fechaLarga.getYear());
    }
}
