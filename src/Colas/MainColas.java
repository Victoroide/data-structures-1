/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;

import Colas.ColaL;
import Colas.ColaV;
import Colas.Colab;

/**
 *
 * @author Victor
 */
public class MainColas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*ColaV Q = new ColaV(10);
        Q.Encolar(9);
        Q.Encolar(1);
        Q.Encolar(2);
        Q.Encolar(8);
        Q.Encolar(3);
        Q.Encolar(0);
        Q.Encolar(1);
        Q.Encolar(18);
        Q.Encolar(31);
        Q.Encolar(7);
        System.out.println(Q);
        Q.Decolar();
        Q.Decolar();
        System.out.println(Q);*/
        
        /*Colab Q = new Colab(10, 6);
        Q.Encolar(9);
        Q.Encolar(1);
        Q.Encolar(2);
        Q.Encolar(8);
        Q.Encolar(3);
        Q.Encolar(0);
        Q.Encolar(1);
        Q.Encolar(8);
        Q.Encolar(13);
        Q.Encolar(7);
        System.out.println(Q);
        Q.Decolar();
        Q.Decolar();
        System.out.println(Q);*/
        
        ColaL Q = new ColaL();
        Q.Encolar(9);
        Q.Encolar(1);
        Q.Encolar(2);
        Q.Encolar(8);
        Q.Encolar(3);
        Q.Encolar(0);
        Q.Encolar(1);
        Q.Encolar(18);
        Q.Encolar(31);
        Q.Encolar(7);
        //System.out.println(Q);
        //Q.Decolar();
        //Q.Decolar();
        //System.out.println(Q);
        System.out.println("Cola original: " + Q);
        Q.invertirColaIterativa();
        System.out.println("Cola invertida: " + Q);
    }
}
