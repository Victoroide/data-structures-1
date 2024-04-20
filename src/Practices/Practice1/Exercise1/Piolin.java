/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise1;

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
        Piolin piolin = new Piolin('M', 2, 5);
        Loro loro = new Loro('H', 3, 'N', "Verde");

        piolin.quienSoy();
        loro.quienSoy();

        piolin.altura();
        loro.deDondeEres();

        piolin.tamano = 20;
        piolin.altura();

        loro.region = 'S';
        loro.deDondeEres();

        System.out.println("Número de Aves Creadas: " + Ave.getNumeroDeAves());
    }
}