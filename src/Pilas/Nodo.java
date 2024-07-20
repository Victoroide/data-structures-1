
package Pilas;

public class Nodo {
    
    int dato;
    Nodo enlace;
    
    public Nodo(){
        enlace = null;
    }
    
    public Nodo(int dato, Nodo enlace){
        this.dato = dato;
        this.enlace = enlace;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    @Override
    public String toString(){
        String s="[";
        s = s + getDato() + " | ]";
        return s;
    }
    
    public static void main(String[] args) {
        Nodo n = new Nodo();
        n.setDato(3);
        System.out.println(n);
        
        Nodo n2 = new Nodo(5, n);
        System.out.println(n2 + " -> "+ n2.getEnlace());
    }
    
}
