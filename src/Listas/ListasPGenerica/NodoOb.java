/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.ListasPGenerica;

/**
 *
 * @author Victor
 */
public class NodoOb {     Object Dato;
                           NodoOb Enlace; 
                           
    public NodoOb(){
      Enlace=null;
    }              
    public NodoOb (Object Dato){
       this.Dato=Dato;
        Enlace=null;    
    }
    public void SetDato(Object Dato){
       this.Dato=Dato;
    }
    public Object GetDato(){
        return Dato;
    }
    public void SetEnlace(NodoOb P){
      Enlace=P;
    }
    public  NodoOb GetEnlace(){
       return Enlace;
    }

    
}
