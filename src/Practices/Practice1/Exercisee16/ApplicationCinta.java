/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee16;

/**
 *
 * @author cvict
 */

public class ApplicationCinta {
    private String cinta;
    private int posicion;

    public ApplicationCinta(String cinta) {
        this.cinta = cinta;
        this.posicion = 0;
    }

    public void avanzar() {
        if (posicion < cinta.length() - 1) {
            posicion++;
        }
    }

    public void retroceder() {
        if (posicion > 0) {
            posicion--;
        }
    }

    public char caracterCorriente() {
        return cinta.charAt(posicion);
    }

    public String reg() {
        return String.valueOf(cinta.charAt(posicion));
    }

    public void siguientePalabra() {
        while (posicion < cinta.length() - 1 && cinta.charAt(posicion) != ' ') {
            posicion++;
        }
        while (posicion < cinta.length() - 1 && cinta.charAt(posicion) == ' ') {
            posicion++;
        }
    }

    public void retrocederPalabra() {
        while (posicion > 0 && cinta.charAt(posicion) == ' ') {
            posicion--;
        }
        while (posicion > 0 && cinta.charAt(posicion) != ' ') {
            posicion--;
        }
        if (posicion > 0) {
            posicion++;
        }
    }

    public void pausa() {
        System.out.println("Pausa en la posición: " + posicion);
    }

    public void stop() {
        posicion = 0;
    }

    public void imprimir() {
        System.out.println("Cinta: " + cinta);
        System.out.println("Posición del cabezal: " + posicion);
    }

    @Override
    public String toString() {
        return cinta;
    }

    public int getPosicion() {
        return posicion;
    }
}
