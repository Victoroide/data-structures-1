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
    
public class Alumnos implements Comparable, Serializable{  int CI;
                                                           int Registro;
                                                            String Nombre;
                                                            char sexo;
                                                            int edad;

    public Alumnos() {
    }

    public Alumnos(int CI, int Registro, String Nombre, char sexo, int edad) {
        this.CI = CI;
        this.Registro = Registro;
        this.Nombre = Nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setRegistro(int Registro) {
        this.Registro = Registro;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCI() {
        return CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getRegistro() {
        return Registro;
    }

    public int getEdad() {
        return edad;
    }

    public char GetSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Registro=" + Registro +'\n'+"CI=" + CI + '\n'+ "Nombre=" + Nombre +'\n'+ "sexo=" + sexo + '\n'+"edad=" + edad + '\n';
    }
    
    @Override
    public int compareTo(Object o) {
        Alumnos A=(Alumnos)o;
        return ((getRegistro()<A.getRegistro())?-1:(getRegistro()>A.getRegistro())?1:0);
        
        
      
    }                
}