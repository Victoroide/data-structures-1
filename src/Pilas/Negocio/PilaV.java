
package Pilas.Negocio;

public class PilaV {
    
    int p[];
    int cima;
    
    public PilaV(int cant){
        p = new int[cant];
        cima = -1;
    }
    
    public boolean vacia(){
        return (cima == -1);
    }
    
    public boolean llena(){
        return (cima == p.length-1);
    }
    
    public int get(){
        return (p[cima]);
    }
    
    public void push(int ele){
        if(! llena()){
            cima++;
            p[cima] = ele;
        }else{
            System.out.println("Error: Push: pila llena");
            System.exit(1);
        }
    }
    
    public int pop(){
        cima--;
        return (p[cima+1]);
    }
    
    public int getCima(){
        return this.cima;
    }
    
    public void eliminar(){
        if(this.cima > -1){
            cima--;
        }
    }
    
    //---------------------------------------------------------------------
    
    public void eliminarRepetidos(){
        PilaV aux=new PilaV(getCima()+1);
        int valor;
        for(int i=0; i<cima; i++) {            
            while (i<cima) {              
               aux.push(pop());
            }
            valor=get();//get
            while (!aux.vacia()) {                
                if (valor != aux.get()) {
                    push(aux.pop());
                }else{
                    aux.pop();
                }
            }
        }
    }
    
    public void eliminarRepetidosYsimismo(){
        PilaV aux = new PilaV(getCima()+1);
        PilaV aux2 = new PilaV(getCima()+1);
        int valor,contador;
        int i=0;
        aux.push(1);
        while(!aux.vacia()){
            if(i==0){
                aux.pop();
            }
            contador = 0;
            while(i<cima ){
                aux.push(pop());
            }
            valor = get();
            while(!aux.vacia()){
                if(valor == aux.get()){
                    contador++; 
                    aux.pop();  
                }else{
                    aux2.push(aux.pop());
                }
            }
            while(!aux2.vacia()){
                aux.push(aux2.pop());
            }
            if(contador != 0){
                pop();
            }
            if(!aux.vacia()){
                push(aux.pop());
            }
            i++;
        }
    }
    
    public void intercambioExtremos(){
        PilaV aux = new PilaV(getCima()+1);
        int valor1,valor2;
        int i=0;
        valor1 = pop();
        while(i<cima){
            aux.push(pop());
        }
        valor2 = pop();
        push(valor1);
        while(!aux.vacia()){
            push(aux.pop());
        }
        push(valor2);
    }
    
    public void invertir() {
        PilaV Paux1 = new PilaV(getCima() + 1);
        PilaV Paux2 = new PilaV(getCima() + 1);
        while (!vacia()) {
            Paux1.push(pop());
        }
        while (!Paux1.vacia()) {
            Paux2.push(Paux1.pop());
        }
        while (!Paux2.vacia()) {
            push(Paux2.pop());
        }
    }
    
    public void intercambiarCon(PilaV otra) {
        PilaV aux = new PilaV(Math.max(this.getCima(), otra.getCima()) + 1);
        
        // Transferir todos los elementos de esta pila a la pila auxiliar
        while (!otra.vacia()) {
            aux.push(otra.pop());
        }
        
        // Transferir todos los elementos de la otra pila a esta pila
        while (!this.vacia()) {
            otra.push(this.pop());
        }
        
        // Transferir todos los elementos de la pila auxiliar a la otra pila
        while (!aux.vacia()) {
            this.push(aux.pop());
        }
        otra.invertir();
        
    }
    
    public int sacarPos(int pos){
        PilaV q = new PilaV(cima);
        for(int i=cima; i>=pos; i--){
            q.push(pop());
        }
        int x = pop();
        while(!q.vacia()){
            push(q.pop());
        }
        return (x);
    }
    
    public void invertir2() {
        int[] temp = new int[cima + 1];
        int index = 0;
        
        // Vaciar la pila en el arreglo temporal
        while (!vacia()) {
            temp[index++] = pop();
        }
        
        // Rellenar la pila con los elementos del arreglo temporal en orden inverso
        for (int i = 0; i < index; i++) {
            push(temp[i]);
        }
    }
    
    @Override
    public String toString(){
        String cad = "[cima]\n";
        if(! vacia()){
            for(int i=cima; i>=0; i--){
                cad = cad + "[" + p[i] + "]\n";
            }
        }
        return cad;
    }
    
    public static void main(String[] args) {
        PilaV pila = new PilaV(10);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        
        System.out.println("Pila original:");
        System.out.println(pila);
        
        pila.invertir2();
        
        System.out.println("Pila invertida:");
        System.out.println(pila);
    }
}
