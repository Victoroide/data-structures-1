/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas.Negocio;

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

    // Método para intercambiar contenido entre dos colas
    public void intercambiarColas(ColaV otraCola) {
        int maxSize = Math.max(this.C.length, otraCola.C.length);
        ColaV temp = new ColaV(maxSize);

        while (!this.vacia()) {
            temp.Encolar(this.Decolar());
        }

        while (!otraCola.vacia()) {
            this.Encolar(otraCola.Decolar());
        }

        while (!temp.vacia()) {
            otraCola.Encolar(temp.Decolar());
        }
    }
    
    public void intercambiarColas2(ColaV otraCola) {
        int[] tempArray = new int[this.C.length];
       
        // Vaciar la primera cola en el array temporal
        int index = 0;
        while (!this.vacia()) {
            tempArray[index++] = this.Decolar();
        }

        // Vaciar la segunda cola en la primera cola
        while (!otraCola.vacia()) {
            this.Encolar(otraCola.Decolar());
        }

        // Llenar la segunda cola con los elementos del array temporal
        for (int i = 0; i < index; i++) {
            otraCola.Encolar(tempArray[i]);
        }
    }

    public static void main(String[] args) {
        ColaV q1 = new ColaV(10);
        ColaV q2 = new ColaV(10);

        q1.Encolar(1);
        q1.Encolar(2);
        q1.Encolar(3);
        q1.Encolar(4);
        q1.Encolar(5);

        q2.Encolar(6);
        q2.Encolar(7);
        q2.Encolar(8);
        q2.Encolar(9);
        q2.Encolar(10);
        q2.Encolar(11);

        System.out.println("Q1 original: " + q1);
        System.out.println("Q2 original: " + q2);

        q1.intercambiarColas2(q2);

        System.out.println("Q1 después del intercambio: " + q1);
        System.out.println("Q2 después del intercambio: " + q2);
    }
    
}
