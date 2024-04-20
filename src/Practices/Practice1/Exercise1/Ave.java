/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise1;

/**
 *
 * @author cvict
 */
public class Ave {
    protected char sexo;
    protected int edad;
    private static int numeroDeAves = 0;

    public Ave(char sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
        numeroDeAves++;
    }

    public static int getNumeroDeAves() {
        return numeroDeAves;
    }

    public void quienSoy() {
        System.out.println("Sexo: " + sexo + ", Edad: " + edad);
    }
}
