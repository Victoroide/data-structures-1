/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise1;
import java.util.Scanner;

/**
 *
 * @author cvict
 */
public class Piolin extends Canario {
    private int numeroDePeliculas;

    public Piolin(char sexo, int edad, int numeroDePeliculas) {
        super(sexo, edad);
        this.numeroDePeliculas = numeroDePeliculas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Piolin piolin = new Piolin('M', 2, 5);
        Loro loro = new Loro('H', 3, 'N', "Verde");
        
        System.out.println("Información inicial:");
        piolin.quienSoy();
        loro.quienSoy();
        
        piolin.altura();
        loro.deDondeEres();
        
        System.out.println("\nIntroduce nuevo tamaño para Piolin:");
        float nuevoTamano = scanner.nextFloat();
        piolin.tamano = nuevoTamano;
        piolin.altura();
        
        System.out.println("Introduce nueva región para el Loro (N/S/E/O):");
        char nuevaRegion = scanner.next().charAt(0);
        loro.region = nuevaRegion;
        loro.deDondeEres();
        
        System.out.println("\nNúmero de Aves Creadas: " + Ave.getNumeroDeAves());
        
        scanner.close();
    }
}