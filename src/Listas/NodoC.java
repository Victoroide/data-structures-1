/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author Estefany
 */
public class NodoC {
    private Object Elemento; // el dato Puede ser cualquier tipo
    private NodoC Enlace;

    public NodoC() {
        Elemento = null;
        Enlace = null;
    }

    public void setElem(Object ele) {
        Elemento = ele;
    }

    public Object getElem() {
        return Elemento;
    }

    public void setEnlace(NodoC Raux) {
        Enlace = Raux;
    }

    public NodoC getEnlace() {
        return Enlace;
    }
}
