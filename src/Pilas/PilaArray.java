
package Pilas;

import java.util.EmptyStackException;


public class PilaArray<T> {
    
    private T[]elementos;
    private int capacidad;
    private int tama;
    
    public PilaArray(int capacidad){
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.tama = 0;
    }
    
    public void apilar(T elemento){
        if(tama == capacidad){
            throw new StackOverflowError("La pila esta llena");
        }
        elementos[tama] = elemento;
        tama++;
    }
    
    public T desapilar(){
        if(estaVacia()){
            throw new EmptyStackException();
        }
        T elementoDesapilado = elementos[tama-1];
        elementos[tama-1] = null; //liberar la referencia al objeto
        tama--;
        return elementoDesapilado;
    }
    
    public boolean estaVacia(){
        return (tama == 0);
    }
    
    public T cima(){
        if(estaVacia()){
            throw new EmptyStackException();
        }
        return elementos[tama-1];
    }
    
    public int tamaño(){
        return tama;
    }
    
    
    
}
