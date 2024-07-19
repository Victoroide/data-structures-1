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
public class ColaV {
    int C[];
    int Frente; // Indice a la cabeza de la Cola
    int Atras;  // Indice al final de la cola

    public ColaV(int cant) {
        this.C = new int[cant];
        this.Frente = -1;
        this.Atras = -1;
    }

    public boolean vacia() {
        return (Frente == -1);
    }

    public boolean Llena() {
        return ((Atras + 1) % C.length == Frente);
    }

    public void Encolar(int ele) {
        if (vacia()) {
            Frente = 0;
            Atras = 0;
            C[Atras] = ele;
        } else {
            if (Llena()) {
                System.out.println("Error::Encolar:Cola Llena");
                System.exit(1);
            } else {
                Atras = (Atras + 1) % C.length;
                C[Atras] = ele;
            }
        }
    }

    public int Decolar() {
        int x = C[Frente];
        if (Frente == Atras) { // SOLO HAY UN DATO
            Frente = -1;
            Atras = -1;
        } else {
            Frente = (Frente + 1) % C.length;
        }
        return x;
    }

    public int Get() {
        return C[Frente];
    }

    @Override
    public String toString() {
        String S = "Q=[";
        int Aux = Frente;
        while (Aux != Atras) {
            S = S + C[Aux] + " , ";
            Aux = (Aux + 1) % C.length;
        }
        S = S + C[Aux] + "]";
        return S;
    }
    
    public void eliminarRepetidos() {
        if (this.vacia()) return;

        int n = (Atras - Frente + C.length) % C.length + 1;
        for (int i = 0; i < n; i++) {
            int actual = C[(Frente + i) % C.length];
            for (int j = i + 1; j < n; j++) {
                if (C[(Frente + j) % C.length] == actual) {
                    // Desplazar todos los elementos hacia la izquierda
                    for (int k = j; k < n - 1; k++) {
                        C[(Frente + k) % C.length] = C[(Frente + k + 1) % C.length];
                    }
                    Atras = (Atras - 1 + C.length) % C.length;
                    n--;  // Reducir el tamaño de la cola efectiva
                    j--;  // Volver a comprobar la posición j
                }
            }
        }

        // Ajustar Frente y Atras si la cola está vacía
        if (Frente == (Atras + 1) % C.length) {
            Frente = -1;
            Atras = -1;
        }
    }

    public static void main(String[] args) {
        ColaV cola = new ColaV(10);
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
