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
public class ColaL {
    Nodo Frente;
    Nodo Atras;
    int cant;

    public ColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }

    public boolean Vacia() {
        return Frente == null;
    }

    public void Encolar(int ele) {
        Nodo p = new Nodo();
        p.setDato(ele);
        if (Vacia()) {
            Frente = p;
            Atras = p;
            cant++;
        } else {
            Atras.setEnlace(p);
            Atras = p;
            cant++;
        }
    }

    public int Decolar() {
        int x = Frente.getDato();
        if (Frente == Atras) {
            Frente = null;
            Atras = null;
            cant--;
        } else {
            Frente = Frente.getEnlace();
            cant--;
        }
        return x;
    }

    public int Get() {
        return Atras.getDato();
    }

    @Override
    public String toString() {
        String S = "C->";
        Nodo aux = Frente;
        while (aux != null) {
            S = S + aux.getDato() + " -> ";
            aux = aux.getEnlace();
        }
        return S;
    }

    // Recursividad
    public void invertirColaRecursiva() {
        if (!this.Vacia()) {
            int elemento = this.Decolar();
            this.invertirColaRecursiva();
            this.Encolar(elemento);
        }
    }
    
    // Método para invertir la cola de forma iterativa
    public void invertirColaIterativa() {
        if (this.Vacia()) return;

        ColaL auxiliar = new ColaL();

        while (!this.Vacia()) {
            auxiliar.Encolar(this.Decolar());
        }

        while (!auxiliar.Vacia()) {
            int valor = auxiliar.Decolar();
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setDato(valor);

            if (this.Vacia()) {
                this.Frente = nuevoNodo;
                this.Atras = nuevoNodo;
            } else {
                nuevoNodo.setEnlace(this.Frente);
                this.Frente = nuevoNodo;
            }
            this.cant++;
        }
    }
    
    public void eliminarRepetidos() {
        if (this.Vacia()) return;

        Nodo actual = this.Frente;

        while (actual != null) {
            Nodo anterior = actual;
            Nodo siguiente = actual.getEnlace();

            while (siguiente != null) {
                if (actual.getDato() == siguiente.getDato()) {
                    anterior.setEnlace(siguiente.getEnlace());
                    this.cant--;
                } else {
                    anterior = siguiente;
                }
                siguiente = siguiente.getEnlace();
            }

            actual = actual.getEnlace();
        }

        this.Atras = this.Frente;
        while (this.Atras != null && this.Atras.getEnlace() != null) {
            this.Atras = this.Atras.getEnlace();
        }
    }
    
    public static void main(String[] args) {
        ColaL cola = new ColaL();
        cola.Encolar(1);
        cola.Encolar(2);
        cola.Encolar(2);
        cola.Encolar(3);
        cola.Encolar(4);
        cola.Encolar(4);
        cola.Encolar(5);

        System.out.println("Cola original: " + cola);

        cola.eliminarRepetidos();

        System.out.println("Cola sin repetidos: " + cola);
    }
}
