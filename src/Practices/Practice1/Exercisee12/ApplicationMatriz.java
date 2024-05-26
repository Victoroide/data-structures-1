/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee12;

/**
 *
 * @author cvict
 */

public class ApplicationMatriz {
    private int[][] elementos;
    private int filas;
    private int columnas;

    public ApplicationMatriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.elementos = new int[filas][columnas];
    }

    public void asignar(int fila, int columna, int valor) {
        elementos[fila][columna] = valor;
    }

    public int obtenerElemento(int fila, int columna) {
        return elementos[fila][columna];
    }

    public ApplicationMatriz sumar(ApplicationMatriz otra) {
        if (this.filas != otra.filas || this.columnas != otra.columnas) {
            throw new IllegalArgumentException("Las dimensiones de las matrices no coinciden.");
        }
        ApplicationMatriz resultado = new ApplicationMatriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.asignar(i, j, this.elementos[i][j] + otra.elementos[i][j]);
            }
        }
        return resultado;
    }

    public ApplicationMatriz productoEscalar(int escalar) {
        ApplicationMatriz resultado = new ApplicationMatriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.asignar(i, j, this.elementos[i][j] * escalar);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(elementos[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}