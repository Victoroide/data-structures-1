/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.ListasC;

/**
 *
 * @author Victor
 */
public class ListaC {
    NodoC Primero;
    int cant;

    public ListaC() {
        Primero = null;
        cant = 0;
    }

    public boolean vacia() {
        return (Primero == null);
    }

    public void insertar(Object e) {
        NodoC nuevo = new NodoC();
        nuevo.setElem(e);
        if (vacia()) {
            Primero = nuevo;
            Primero.setEnlace(Primero);
        } else {
            NodoC aux = Primero;
            while (aux.getEnlace() != Primero) {
                aux = aux.getEnlace();
            }
            aux.setEnlace(nuevo);
            nuevo.setEnlace(Primero);
        }
        cant++;
    }

    public void insertarInicio(Object e) {
        NodoC nuevo = new NodoC();
        nuevo.setElem(e);
        if (vacia()) {
            Primero = nuevo;
            Primero.setEnlace(Primero);
        } else {
            NodoC aux = Primero;
            while (aux.getEnlace() != Primero)
                aux = aux.getEnlace();
            aux.setEnlace(nuevo);
            nuevo.setEnlace(Primero);
            Primero = nuevo;
        }
        cant++;
    }

    public void insertar(Object e, int pos) {
        NodoC nuevo = new NodoC();
        nuevo.setElem(e);
        if ((vacia()) || (pos <= 0))
            insertarInicio(e);
        else {
            if (pos >= cant - 1)
                insertar(e);
            else {
                NodoC aux = Primero;
                pos--;
                while (pos > 0) {
                    aux = aux.getEnlace();
                    pos--;
                }
                nuevo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        cant++;
    }

    public Object consultarInicio() {
        return Primero.getElem();
    }

    public Object consultar() {
        NodoC aux = Primero;
        while (aux.getEnlace() != Primero) {
            aux = aux.getEnlace();
        }
        return aux.getElem();
    }

    public Object consultar(int pos) {
        NodoC aux = Primero;
        if (pos >= cant - 1)
            return consultar();
        else {
            if (pos <= 0)
                return consultarInicio();
            else {
                while (pos > 0) {
                    aux = aux.getEnlace();
                    pos--;
                }
            }
        }
        return aux.getElem();
    }

    public void eliminarInicio() {
        if (cant == 1)
            Primero = null;
        else {
            NodoC aux = Primero;
            while (aux.getEnlace() != Primero)
                aux = aux.getEnlace();
            aux.setEnlace(Primero.getEnlace());
            Primero = aux.getEnlace();
        }
        cant--;
    }

    public void eliminar() {
        if (cant == 1)
            Primero = null;
        else {
            NodoC aux = Primero;
            int i = cant - 2;
            while (i > 0) {
                aux = aux.getEnlace();
                i--;
            }
            aux.setEnlace(aux.getEnlace().getEnlace());
        }
        cant--;
    }

    @Override
    public String toString() {
        if (vacia()) {
            System.out.println("La lista está vacía.");
            return "C->null";
        } else {
            String S = "C->";
            NodoC p = Primero;
            do {
                S = S + p.getElem() + " -> ";
                p = p.getEnlace();
            } while (p != Primero); // Se imprime hasta volver al inicio
            return S;
        }
    }
}
