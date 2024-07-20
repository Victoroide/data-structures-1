
package Pilas.Negocio;

public class PilaB {
    VectorNBits p;
    int cima;
    
    public PilaB(int cant, int nbits){
        p = new VectorNBits(cant, nbits);
        cima = 0;
    }
    
    public boolean vacia(){
        return (cima == 0);
    }
    
    public boolean llena(){
        return (p.cant == cima);
    }
    
    public void push(int ele){
        if(llena()){
            System.out.println("Error: push: La pila bits esta llena"); 
            System.exit(1);
        }else{
            cima++;
            p.insertar(ele, cima);
        }
    }
    
    public int pop(){
        cima--;
        return (p.sacar(cima+1));
    }
    
    public int get(){
        return p.sacar(cima);
    }
    
    @Override
    
    public String toString(){
        String s = "";
        for(int i=cima; i>=1; i--){
            s = s + "[" + p.sacar(i) + "]\n";
        }
        s = s + "p";
        return s;
    }
    
    
}
