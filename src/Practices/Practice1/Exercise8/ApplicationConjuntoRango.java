/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise8;

/**
 *
 * @author cvict
 */

public class ApplicationConjuntoRango {
    private final int rangoInicial;
    private final int rangoFinal;
    private int[] elementos;
    private int tamaño;

    public ApplicationConjuntoRango(int rangoInicial, int rangoFinal) {
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        this.elementos = new int[0];
        this.tamaño = 0;
    }

    public boolean insertar(int elemento) {
        if (elemento >= rangoInicial && elemento <= rangoFinal && !pertenece(elemento)) {
            int[] nuevosElementos = new int[tamaño + 1];
            System.arraycopy(elementos, 0, nuevosElementos, 0, tamaño);
            nuevosElementos[tamaño] = elemento;
            elementos = nuevosElementos;
            tamaño++;
            return true;
        }
        return false;
    }

    public boolean eliminar(int elemento) {
        if (pertenece(elemento)) {
            int[] nuevosElementos = new int[tamaño - 1];
            int j = 0;
            for (int i = 0; i < tamaño; i++) {
                if (elementos[i] != elemento) {
                    nuevosElementos[j++] = elementos[i];
                }
            }
            elementos = nuevosElementos;
            tamaño--;
            return true;
        }
        return false;
    }

    public boolean pertenece(int elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    public int tamaño() {
        return tamaño;
    }

    public ApplicationConjuntoRango union(ApplicationConjuntoRango otro) {
        ApplicationConjuntoRango union = new ApplicationConjuntoRango(Math.min(rangoInicial, otro.rangoInicial), Math.max(rangoFinal, otro.rangoFinal));
        for (int i = 0; i < tamaño; i++) {
            union.insertar(elementos[i]);
        }
        for (int i = 0; i < otro.tamaño; i++) {
            union.insertar(otro.elementos[i]);
        }
        return union;
    }

    public ApplicationConjuntoRango interseccion(ApplicationConjuntoRango otro) {
        ApplicationConjuntoRango interseccion = new ApplicationConjuntoRango(Math.max(rangoInicial, otro.rangoInicial), Math.min(rangoFinal, otro.rangoFinal));
        for (int i = 0; i < tamaño; i++) {
            if (otro.pertenece(elementos[i])) {
                interseccion.insertar(elementos[i]);
            }
        }
        return interseccion;
    }

    public ApplicationConjuntoRango diferencia(ApplicationConjuntoRango otro) {
        ApplicationConjuntoRango diferencia = new ApplicationConjuntoRango(rangoInicial, rangoFinal);
        for (int i = 0; i < tamaño; i++) {
            if (!otro.pertenece(elementos[i])) {
                diferencia.insertar(elementos[i]);
            }
        }
        return diferencia;
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
