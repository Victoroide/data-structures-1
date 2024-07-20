
package Pilas.Negocio;


public class PilaL {
    Nodo cima;
    int cant;
    
    public PilaL(){
       this.cima = null;
       this.cant = 0;
    }
    
    public boolean vacia(){
        return (cima == null);
    }
    
    public void push(int ele){
        Nodo p = new Nodo();
        p.setDato(ele);
        p.setEnlace(cima);
        cima = p;
        cant++;
    }
    
    public int pop(){
        int x = cima.getDato();
        cima = cima.getEnlace();
        cant--;
        return x;
    }
    
    public int get(){
        return (cima.getDato());
    }
    
    @Override
    
    public String toString(){
        String s = "";
        Nodo aux = cima;
        while(aux != null){
            s = s + "[" +aux.getDato() + "]\n";
            aux = aux.getEnlace();
        }
        s = s + "p";
        return s;
    }
    
    public void invertir() {
        if (!vacia()) {
            Nodo prev = null;
            Nodo current = cima;
            Nodo next;
            while (current != null) {
                next = current.getEnlace();
                current.setEnlace(prev);
                prev = current;
                current = next;
            }
            cima = prev;
        }
    }
    
    public static void main(String[] args) {
        PilaL pila = new PilaL();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        
        System.out.println("Pila original:");
        System.out.println(pila);
        
        pila.invertir();
        
        System.out.println("Pila invertida:");
        System.out.println(pila);
    }
    
}
