/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise2;

/**
 *
 * @author cvict
 */
import java.util.Scanner;

public class ApplicationText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Text myText = new Text();
        myText.addChar('H');
        myText.addChar('o');
        myText.addChar('l');
        myText.addChar('a');

        System.out.println("Texto actual: " + myText.toString());
        System.out.println("Tamaño del texto: " + myText.size());

        try {
            System.out.println("Caracter en la posicion 2: " + myText.charAt(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        myText.removeChar();
        System.out.println("Texto despues de remover un caracter: " + myText.toString());

        myText.destroy();
        System.out.println("Texto despues de destruirlo: " + myText.toString());

        scanner.close();
    }
}

