/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas.ListasPGenerica;

import Listas.ListasPGenerica.Alumnos;
import Listas.ListasPGenerica.ListaG;

/**
 *
 * @author Usuario
 */
public class MainPEGenericas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaG LA=new ListaG<Alumnos>();
        ListaG LE=new ListaG<Integer>();
        ListaG LF=new ListaG<Float>(); 
        LE.Insertar(2);
        LE.Insertar(8);
        LE.Insertar(1);
        System.out.println(LE);
        Alumnos A=new Alumnos(100,20205847,"Alberto",'M',32);
        LA.Insertar(A);
        Alumnos B=new Alumnos(105,20215847,"Raul",'M',25);
        LA.Insertar(B);
        Alumnos C=new Alumnos(102,20191147,"Vanesa",'F',22);
        LA.Insertar(C);  
        Alumnos D=new Alumnos(108,20251147,"Ruben",'M',28);
        LA.Insertar(D); 
        System.out.println(LA.toString());
        LF.Insertar(1.1);
        LF.Insertar(2.5);
        LF.Insertar(1.3);
        LF.Insertar(2.4);
        System.out.println(LF);
        LA.Eliminar(A);
        System.out.println(LA.toString());
        
        
    }
    
}
