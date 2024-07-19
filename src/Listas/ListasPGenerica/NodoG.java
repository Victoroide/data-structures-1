/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.ListasPGenerica;

import java.io.Serializable;

/**
 *
 * @author Victor
 */
public class NodoG <Tipovar> implements Serializable{     Tipovar Dato;
                                                          NodoG<Tipovar> Enlace; 
                           
    public NodoG(){
      Enlace=null;
    }              
    public NodoG (Tipovar Dato){
       this.Dato=Dato;
        Enlace=null;    
    }
    public void SetDato(Tipovar Dato){
       this.Dato=Dato;
    }
    public Tipovar GetDato(){
        return Dato;
    }
    public void SetEnlace(NodoG<Tipovar> P){
      Enlace=P;
    }
    public  NodoG<Tipovar> GetEnlace(){
       return Enlace;
    }

    
}
