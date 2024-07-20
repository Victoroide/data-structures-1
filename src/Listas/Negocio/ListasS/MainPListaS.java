/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.Negocio.ListasS;

import Listas.Negocio.ListasS.Lista;

/**
 *
 * @author Victor
 */
public class MainPListaS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista LI = new Lista();
        LI.insertar(10);
        LI.insertar(2);
        LI.insertar(1);
        LI.insertar(10);
        LI.insertar(5);
        LI.insertar(8);
        LI.insertar(3);
        LI.insertar(2);
        System.out.println(LI);
        //LI.Invertir();
        //System.out.println(LI);
        LI.Eliminar(8);
        LI.Eliminar(1);
        System.out.println(LI);
    }
}
