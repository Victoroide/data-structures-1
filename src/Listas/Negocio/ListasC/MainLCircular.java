/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.Negocio.ListasC;

import Listas.Negocio.ListasC.ListaC;

/**
 *
 * @author Victor
 */
public class MainLCircular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaC C = new ListaC();
        C.insertarInicio(5);
        C.insertar(7);
        C.insertar(8);
        C.insertar(1);
        C.insertar(2);
        //C.insertar(6,0);
        System.out.println(C);
        C.eliminar();
        System.out.println(C);
    }
}
