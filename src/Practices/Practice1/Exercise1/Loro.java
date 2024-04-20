/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise1;

/**
 *
 * @author cvict
 */
public class Loro extends Ave {
    protected char region;
    protected String color;

    public Loro(char sexo, int edad, char region, String color) {
        super(sexo, edad);
        this.region = region;
        this.color = color;
    }

    public void deDondeEres() {
        switch (region) {
            case 'N':
                System.out.println("Norte");
                break;
            case 'S':
                System.out.println("Sur");
                break;
            case 'E':
                System.out.println("Este");
                break;
            case 'O':
                System.out.println("Oeste");
                break;
        }
    }
}
