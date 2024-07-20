/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.Negocio.ListasPGenerica;

import java.io.Serializable;

/**
 *
 * @author Victor
 */
public class ListaG <Tipovar extends Comparable> implements Serializable{     NodoG<Tipovar> L;
                                                                               int Cant;
                                                    
    public  ListaG(){
        L=null;
        Cant=0;
    }          
    public boolean vacia(){
        return(L==null);
    }
    
    
    public void Insertar(Tipovar Dato){
        if (vacia()) { //esta vacia
            NodoG P=new NodoG<Tipovar>();
            P.SetDato(Dato);
            L=P;
            Cant++;            
        }else {
            NodoG<Tipovar> Ant = null;
            NodoG<Tipovar> Aux = L;
                while ((Aux!=null)&&(Aux.GetDato().compareTo(Dato)<0)) {
                    Ant=Aux;
                    Aux=Aux.GetEnlace();    
                 }
                  NodoG P= new NodoG<Tipovar>(Dato);
                if (Ant==null) {//inserta en el primero                
                  P.SetEnlace(L);
                  L=P;
                  Cant++;
                }else {//inserta en el cuerpor                                
                   Ant.SetEnlace(P);
                   P.SetEnlace(Aux);
                   Cant++;
                }
        }
    }
    public void Eliminar(Tipovar ele){
   if (!vacia()){
    NodoG<Tipovar> Aux=L;  
    NodoG<Tipovar> Ant=null;
         while ((Aux!=null)&&(Aux.GetDato().compareTo(ele)!=0)){
             Ant=Aux;
             Aux=Aux.GetEnlace();
         }
      if (Aux!=null)
           if (Ant==null){//eliminamos en la cabeza
             L=L.GetEnlace();
             Cant--;
           
           }
           else{//eliminamos en el cuerpo
               Ant.SetEnlace(Aux.GetEnlace());
                 Cant--;
           }
   }
   }
   @Override
    public String toString() {
        String S="";
        NodoG<Tipovar> Aux=L;
        while (Aux!=null)
        { S=S+Aux.GetDato().toString()+'\n';
          Aux=Aux.GetEnlace();
        
        }
        return S;
    }
   }   
    
    
     