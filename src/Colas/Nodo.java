/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;

/**
 *
 * @author Victor
 */
public class Nodo {  Nodo Enlace;
                    int Dato;

    public Nodo() {
        this.Enlace = null;
    }

    public void setEnlace(Nodo Enlace) {
        this.Enlace = Enlace;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public int getDato() {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    } 
    
}
