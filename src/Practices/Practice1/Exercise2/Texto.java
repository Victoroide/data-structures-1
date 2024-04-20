/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise2;

/**
 *
 * @author cvict
 */
public class Texto {
    private char[] caracteres;
    private final int capacidad = 128;
    private int longitud;

    public Texto() {
        caracteres = new char[capacidad];
        longitud = 0;
    }

    public void destruir() {
        caracteres = null;
        longitud = 0;
    }

    public int tamanio() {
        return longitud;
    }

    public char caracterEn(int posicion) {
        if (posicion >= 0 && posicion < longitud) {
            return caracteres[posicion];
        } else {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
    }

    public void agregarCaracter(char c) {
        if (longitud < capacidad) {
            caracteres[longitud++] = c;
        } else {
            throw new IllegalStateException("Capacidad máxima alcanzada");
        }
    }

    public void eliminarCaracter() {
        if (longitud > 0) {
            longitud--;
        } else {
            throw new IllegalStateException("Texto ya está vacío");
        }
    }

    public String toString() {
        if (caracteres == null) {
            return "";  // Retorna una cadena vacía si el arreglo es null
        }
        return new String(caracteres, 0, longitud);
    }

}

