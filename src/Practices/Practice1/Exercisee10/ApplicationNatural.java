/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee10;

/**
 *
 * @author cvict
 */

public class ApplicationNatural {
    private final int valor;

    private ApplicationNatural(int valor) {
        this.valor = valor;
    }

    public static ApplicationNatural cero() {
        return new ApplicationNatural(0);
    }

    public ApplicationNatural sucesor() {
        return new ApplicationNatural(this.valor + 1);
    }

    public boolean esCero() {
        return this.valor == 0;
    }

    public boolean igual(ApplicationNatural otro) {
        return this.valor == otro.valor;
    }

    public ApplicationNatural suma(ApplicationNatural otro) {
        return new ApplicationNatural(this.valor + otro.valor);
    }

    public ApplicationNatural antecesor() {
        if (this.valor == 0) {
            throw new IllegalArgumentException("Cero no tiene antecesor.");
        }
        return new ApplicationNatural(this.valor - 1);
    }

    public ApplicationNatural diferencia(ApplicationNatural otro) {
        if (this.valor < otro.valor) {
            throw new IllegalArgumentException("La diferencia no está definida para estos valores.");
        }
        return new ApplicationNatural(this.valor - otro.valor);
    }

    public boolean menor(ApplicationNatural otro) {
        return this.valor < otro.valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
