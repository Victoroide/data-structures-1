/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise2;

/**
 *
 * @author cvict
 */
public class AplicacionTexto {
    public static void main(String[] args) {
        Texto miTexto = new Texto();
        miTexto.agregarCaracter('H');
        miTexto.agregarCaracter('o');
        miTexto.agregarCaracter('l');
        miTexto.agregarCaracter('a');

        System.out.println("Texto actual: " + miTexto.toString());
        System.out.println("Tamaño del texto: " + miTexto.tamanio());

        try {
            System.out.println("Carácter en posición 2: " + miTexto.caracterEn(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        miTexto.eliminarCaracter();
        System.out.println("Texto después de eliminar un carácter: " + miTexto.toString());

        // Limpiar el texto
        miTexto.destruir();
        System.out.println("Texto después de destruir: " + miTexto.toString());
    }
}

