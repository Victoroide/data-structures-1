/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.Negocio.ListasD;

/**
 *
 * @author Victor
 */
public class NodoD {
    int Data;
    NodoD EnlaceD;
    NodoD EnlaceI;

    public NodoD(int Data) {
        this.Data = Data;
        this.EnlaceD = null;
        this.EnlaceI = null;
    }

    public NodoD() {
        this.EnlaceD = null;
        this.EnlaceI = null;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public int getData() {
        return this.Data;
    }

    public void setEnlaceD(NodoD EnlaceD) {
        this.EnlaceD = EnlaceD;
    }

    public void setEnlaceI(NodoD EnlaceI) {
        this.EnlaceI = EnlaceI;
    }

    public NodoD getEnlaceD() {
        return EnlaceD;
    }

    public NodoD getEnlaceI() {
        return EnlaceI;
    }

    @Override
    public String toString() {
        return "NodoD{" + "Data=" + Data +
                ", EnlaceD=" + EnlaceD +
                ", EnlaceI=" + EnlaceI + '}';
    }
}
