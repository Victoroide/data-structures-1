/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.Encuesta;

/**
 *
 * @author cvict
 */

public class TDAEncuesta {
    VectorBits vectorDatos;
    VectorBits vectorCI;
    VectorBits vectorTelefono;
    int cantidad;
    String[] nombres;

    public TDAEncuesta(int cantidad) {
        nombres = new String[cantidad];
        vectorDatos = new VectorBits(cantidad, 26);
        vectorCI = new VectorBits(cantidad, 27);
        vectorTelefono = new VectorBits(cantidad, 27);
        this.cantidad = 1;
    }
    
    public void agregar(String nombre, int dia, int mes, int año, int nroHijos,
            int estadoCivil, int primaria, int bachiller, int tecnico, int licenciado,
            int postgrado, int ci, int telefono) {
        int mascara = dia;
        mascara = mascara << 4;
        mascara = mascara | mes;
        mascara = mascara << 6;
        año = año - 1980;
        mascara = mascara | año;
        mascara = mascara << 4;
        mascara = mascara | nroHijos;
        mascara = mascara << 2;
        mascara = mascara | estadoCivil;
        mascara = mascara << 1;
        mascara = mascara | primaria;
        mascara = mascara << 1;
        mascara = mascara | bachiller;
        mascara = mascara << 1;
        mascara = mascara | tecnico;
        mascara = mascara << 1;
        mascara = mascara | licenciado;
        mascara = mascara << 1;
        mascara = mascara | postgrado;
        
        vectorDatos.insertar(mascara, cantidad);
        vectorCI.insertar(ci, cantidad);
        vectorTelefono.insertar(telefono, cantidad);
        nombres[cantidad - 1] = nombre;
        cantidad++;
    }
    
    public int obtenerCantidad() {
        return cantidad;
    }
    
    public String obtenerNombre(int pos) {
        return nombres[pos - 1];
    }
    
    public int obtenerDia(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 5) - 1);
        dato = dato >>> 21;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerMes(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 4) - 1);
        dato = dato >>> 17;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerAño(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 6) - 1);
        dato = dato >>> 11;
        dato = dato & mascara;
        dato = dato + 1980;
        return dato;
    }
    
    public int obtenerNroHijos(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 4) - 1);
        dato = dato >>> 7;
        dato = dato & mascara;
        return dato;
    }
    
    public String obtenerEstadoCivil(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 2) - 1);
        dato = dato >>> 5;
        dato = dato & mascara;
        String estado = "";
        switch (dato) {
            case 0: estado = "Soltero"; break;
            case 1: estado = "Casado"; break;
            case 2: estado = "Divorciado"; break;
            case 3: estado = "Viudo"; break;
        }
        return estado;
    }
    
    public int obtenerPrimaria(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 1) - 1);
        dato = dato >>> 4;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerBachiller(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 1) - 1);
        dato = dato >>> 3;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerTecnico(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 1) - 1);
        dato = dato >>> 2;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerLicenciado(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 1) - 1);
        dato = dato >>> 1;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerPostgrado(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int)(Math.pow(2, 1) - 1);
        dato = dato >>> 0;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerCI(int pos) {
        int dato = vectorCI.sacar(pos);
        int mascara = (int)(Math.pow(2, 27) - 1);
        dato = dato >>> 0;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerTelefono(int pos) {
        int dato = vectorTelefono.sacar(pos);
        int mascara = (int)(Math.pow(2, 27) - 1);
        dato = dato >>> 0;
        dato = dato & mascara;
        return dato;
    }
    
    public String mostrar(int pos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNro: ").append(pos)
          .append("\nNombre: ").append(obtenerNombre(pos))
          .append("\nFecha Nacimiento: ").append(obtenerDia(pos)).append(" / ").append(obtenerMes(pos)).append(" / ").append(obtenerAño(pos))
          .append("\nNro Hijos: ").append(obtenerNroHijos(pos))
          .append("\nEstado Civil: ").append(obtenerEstadoCivil(pos))
          .append("\nPrimaria: ").append(obtenerPrimaria(pos) == 1 ? "sí" : "no")
          .append("\nBachiller: ").append(obtenerBachiller(pos) == 1 ? "sí" : "no")
          .append("\nTécnico: ").append(obtenerTecnico(pos) == 1 ? "sí" : "no")
          .append("\nLicenciado: ").append(obtenerLicenciado(pos) == 1 ? "sí" : "no")
          .append("\nPostgrado: ").append(obtenerPostgrado(pos) == 1 ? "sí" : "no")
          .append("\nCI: ").append(obtenerCI(pos))
          .append("\nTeléfono: ").append(obtenerTelefono(pos));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        TDAEncuesta encuesta = new TDAEncuesta(10);
        encuesta.agregar("Mario", 31, 12, 2023, 10, 3, 1, 1, 1, 1, 1, 12315321, 70265765);
        System.out.println(encuesta.mostrar(1));
    }
}