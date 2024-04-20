/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise1;

/**
 *
 * @author cvict
 */
public class Canario extends Ave {
    protected float tamano;

    public Canario(char sexo, int edad) {
        super(sexo, edad);
    }

    public Canario(char sexo, int edad, float tamano) {
        super(sexo, edad);
        this.tamano = tamano;
    }

    public void altura() {
        if (tamano > 30) {
            System.out.println("Alto");
        } else if (tamano >= 15) {
            System.out.println("Mediano");
        } else {
            System.out.println("Bajo");
        }
    }
}
