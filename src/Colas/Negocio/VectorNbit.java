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
public class VectorNbit {
     int v[];
    int dim;
    int numbt;
    
public VectorNbit(int cant, int numbt){
     int x = cant*numbt/32;
        if (cant*numbt%32 != 0)
            x++;
        v = new int[x];
        this.numbt = numbt;
        this.dim = cant;
}
    public void Insertar (int ele,int pos){
        int mask=(int)(Math.pow(2,numbt)-1); 
        int Nbt=CalcularNbit(pos);
        int NEnt=CalcularNE(pos);
        int ele1=ele;
        mask=mask<<Nbt;
        mask=~mask;
        v[NEnt]=v[NEnt]&mask;
        ele=ele<<Nbt;
        v[NEnt]=v[NEnt]|ele;
        if(Nbt+numbt>32){
            int mask1=(int)(Math.pow(2,numbt)-1);
            mask1=mask1>>>(32-Nbt);
            v[NEnt+1]=v[NEnt+1]&mask1;
            ele1=ele1>>>(32-Nbt);
            v[NEnt+1]=v[NEnt+1]|ele1;
        }
        
    }

    public int Sacar(int pos){
         int mask=(int)((Math.pow(2,numbt)-1));
         int Nbt=CalcularNbit(pos);
         int Nent=CalcularNE(pos);
         mask=mask<<Nbt; 
         mask=mask & v[Nent];
         mask=mask>>>Nbt;
         if((Nbt+numbt)>32){
             int mask1=(int)((Math.pow(2,numbt)-1));
             mask1=mask1>>>(32-Nbt);
             mask1=mask1&v[Nent+1];
             mask1=mask1<<(32-Nbt);
             mask=mask|mask1;
         }
         return mask;
       
    
    }
   
    
     public int CalcularNbit(int pos)
    {
        return (((pos-1)*numbt % 32));
    }
    
    public int CalcularNE(int pos)
    {
        return ((pos-1)*numbt / 32);
    }
    public int numBit(){
        return numbt;
    }

    @Override
    public String toString() {
        String s="V[";
        for(int i=1;i<=dim;i++){
            s=s+Sacar(i)+",";
            
        }
        s=s+"]";
        return s;
    } 
}
