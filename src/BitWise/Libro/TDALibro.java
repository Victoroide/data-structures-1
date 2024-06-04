/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.Libro;
import BitWise.Encuesta.VectorBits;
        
/**
 *
 * @author cvict
 */
public class TDALibro {
    
    VectorBits vectorDatos;
    int cantidadLibros;
    String[] titulos;
    String[] autores;
    
    public TDALibro(int cantidad) {
        vectorDatos = new VectorBits(cantidad, 32);
        this.cantidadLibros = 1;
        titulos = new String[cantidad];
        autores = new String[cantidad];
    }
    
    public void agregarLibro(int codigoLibro, String titulo, String autor, int edicion,
            int nroPaginas, int dia, int mes, int año) {
        int mascara = codigoLibro;
        mascara = mascara << 2;
        mascara = mascara | edicion;
        mascara = mascara << 8;
        mascara = mascara | nroPaginas;
        mascara = mascara << 5;
        mascara = mascara | dia;
        mascara = mascara << 4;
        mascara = mascara | mes;
        mascara = mascara << 6;
        año = año - 1980;
        mascara = mascara | año;
        
        vectorDatos.insertar(mascara, cantidadLibros);
        titulos[cantidadLibros - 1] = titulo;
        autores[cantidadLibros - 1] = autor;
        cantidadLibros++;
    }
    
    public String obtenerTitulo(int pos) {
        return titulos[pos - 1];
    }
    
    public String obtenerAutor(int pos) {
        return autores[pos - 1];
    }
    
    public int obtenerCantidad() {
        return cantidadLibros;
    }
    
    public int obtenerCodigoLibro(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 7) - 1);
        dato = dato >>> 25;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerEdicion(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 2) - 1);
        dato = dato >>> 23;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerNroPaginas(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 8) - 1);
        dato = dato >>> 15;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerDia(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 5) - 1);
        dato = dato >>> 10;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerMes(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 4) - 1);
        dato = dato >>> 6;
        dato = dato & mascara;
        return dato;
    }
    
    public int obtenerAño(int pos) {
        int dato = vectorDatos.sacar(pos);
        int mascara = (int) (Math.pow(2, 6) - 1);
        dato = dato >>> 0;
        dato = dato & mascara;
        return dato + 1980;
    }
    
    public String mostrarLibro(int pos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCódigo del Libro: ").append(obtenerCodigoLibro(pos))
          .append("\nTítulo: ").append(obtenerTitulo(pos))
          .append("\nAutor: ").append(obtenerAutor(pos))
          .append("\nEdición: ").append(obtenerEdicion(pos))
          .append("\nNúmero de Páginas: ").append(obtenerNroPaginas(pos))
          .append("\nFecha: ").append(obtenerDia(pos)).append("/").append(obtenerMes(pos)).append("/").append(obtenerAño(pos));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        TDALibro biblioteca = new TDALibro(10);
        biblioteca.agregarLibro(10, "Star War", "Pedro Rodriguez", 3, 105, 31, 12, 2023);
        System.out.println(biblioteca.mostrarLibro(1));
    }
}
