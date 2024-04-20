/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise3;

/**
 *
 * @author cvict
 */
public class ApplicationBooleanX {
    public static void main(String[] args) {
        BooleanX b1 = new BooleanX(1);
        BooleanX b2 = new BooleanX(0);

        System.out.println("b1 es: " + b1);
        System.out.println("b2 es: " + b2);

        BooleanX resultAnd = BooleanX.and(b1, b2);
        System.out.println("b1 AND b2 es: " + resultAnd);

        BooleanX resultOr = BooleanX.or(b1, b2);
        System.out.println("b1 OR b2 es: " + resultOr);

        BooleanX resultNotB1 = BooleanX.not(b1);
        System.out.println("NOT b1 es: " + resultNotB1);
    }
}

