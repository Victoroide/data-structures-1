/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.ListasD;

import Listas.ListasD.ListaD;

/**
 *
 * @author Victor
 */
public class MainListaD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaD L=new ListaD();
        L.insertar(3);
        L.insertar(10);
        L.insertar(4);
        L.insertar(2);
        L.insertar(20);
        L.insertar(15);
        L.insertar(12);
        L.insertar(10);
        System.out.println(L);
        L.eliminar(20);
        L.eliminar(2);
        L.eliminar(10);
        System.out.println(L);
        
    }
    
}
