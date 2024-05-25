package Practices.Practice1.Exercise7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cvict
 */
public class Dupla {
    public static void main(String[] args) {
        ApplicationDupla dupla1 = new ApplicationDupla(2, 3);
        ApplicationDupla dupla2 = new ApplicationDupla(4, 5);

        System.out.println("Dupla 1: " + dupla1);
        System.out.println("Dupla 2: " + dupla2);

        ApplicationDupla multiplied = dupla1.multiply(2);
        System.out.println("Dupla 1 multiplicada por 2: " + multiplied);

        ApplicationDupla added = dupla1.add(3);
        System.out.println("Dupla 1 adicionada por 3: " + added);

        ApplicationDupla summed = ApplicationDupla.sum(dupla1, dupla2);
        System.out.println("Suma de Dupla 1 y Dupla 2: " + summed);

        ApplicationDupla subtracted = ApplicationDupla.subtract(dupla1, dupla2);
        System.out.println("Resta de Dupla 1 y Dupla 2: " + subtracted);
    }
}