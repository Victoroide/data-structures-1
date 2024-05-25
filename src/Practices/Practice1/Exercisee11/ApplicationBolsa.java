/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee11;

/**
 *
 * @author cvict
 */

public class ApplicationBolsa {
    private int[] elementos;
    private int tamaño;

    public ApplicationBolsa() {
        this.elementos = new int[10]; // Tamaño inicial del array
        this.tamaño = 0;
    }

    public void añadir(int elemento) {
        if (tamaño == elementos.length) {
            redimensionar(elementos.length * 2); // Duplicar el tamaño del array
        }
        elementos[tamaño++] = elemento;
    }

    public boolean bolsaVacia() {
        return tamaño == 0;
    }

    public boolean dentro(int elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    public int cuantos(int elemento) {
        int count = 0;
        for (int i = 0; i < tamaño; i++) {
            if (elementos[i] == elemento) {
                count++;
            }
        }
        return count;
    }

    public ApplicationBolsa union(ApplicationBolsa otra) {
        ApplicationBolsa union = new ApplicationBolsa();
        for (int i = 0; i < this.tamaño; i++) {
            union.añadir(this.elementos[i]);
        }
        for (int i = 0; i < otra.tamaño; i++) {
            union.añadir(otra.elementos[i]);
        }
        return union;
    }

    public int total() {
        return tamaño;
    }

    private void redimensionar(int nuevoTamaño) {
        int[] nuevosElementos = new int[nuevoTamaño];
        System.arraycopy(elementos, 0, nuevosElementos, 0, tamaño);
        elementos = nuevosElementos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < tamaño; i++) {
            sb.append(elementos[i]);
            if (i < tamaño - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
