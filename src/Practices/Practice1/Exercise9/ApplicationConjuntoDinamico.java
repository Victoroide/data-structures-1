/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise9;

/**
 *
 * @author cvict
 */

public class ApplicationConjuntoDinamico {
    private boolean[] elementos;
    private int tamaño;

    public ApplicationConjuntoDinamico() {
        this.elementos = new boolean[1];
        this.tamaño = 0;
    }

    public void insertar(int elemento) {
        if (elemento >= elementos.length) {
            redimensionar(elemento + 1);
        }
        if (!elementos[elemento]) {
            elementos[elemento] = true;
            tamaño++;
        }
    }

    public void eliminar(int elemento) {
        if (elemento < elementos.length && elementos[elemento]) {
            elementos[elemento] = false;
            tamaño--;
        }
    }

    public boolean pertenece(int elemento) {
        return elemento < elementos.length && elementos[elemento];
    }

    public int tamaño() {
        return tamaño;
    }

    public ApplicationConjuntoDinamico union(ApplicationConjuntoDinamico otro) {
        int nuevoTamaño = Math.max(this.elementos.length, otro.elementos.length);
        ApplicationConjuntoDinamico union = new ApplicationConjuntoDinamico();
        union.redimensionar(nuevoTamaño);

        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i]) {
                union.insertar(i);
            }
        }

        for (int i = 0; i < otro.elementos.length; i++) {
            if (otro.elementos[i]) {
                union.insertar(i);
            }
        }

        return union;
    }

    public ApplicationConjuntoDinamico interseccion(ApplicationConjuntoDinamico otro) {
        int nuevoTamaño = Math.min(this.elementos.length, otro.elementos.length);
        ApplicationConjuntoDinamico interseccion = new ApplicationConjuntoDinamico();
        interseccion.redimensionar(nuevoTamaño);

        for (int i = 0; i < nuevoTamaño; i++) {
            if (this.elementos[i] && otro.elementos[i]) {
                interseccion.insertar(i);
            }
        }

        return interseccion;
    }

    public ApplicationConjuntoDinamico diferencia(ApplicationConjuntoDinamico otro) {
        ApplicationConjuntoDinamico diferencia = new ApplicationConjuntoDinamico();
        diferencia.redimensionar(this.elementos.length);

        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] && (i >= otro.elementos.length || !otro.elementos[i])) {
                diferencia.insertar(i);
            }
        }

        return diferencia;
    }

    private void redimensionar(int nuevoTamaño) {
        boolean[] nuevosElementos = new boolean[nuevoTamaño];
        System.arraycopy(elementos, 0, nuevosElementos, 0, Math.min(elementos.length, nuevoTamaño));
        elementos = nuevosElementos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean primerElemento = true;
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i]) {
                if (!primerElemento) {
                    sb.append(", ");
                }
                sb.append(i);
                primerElemento = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

