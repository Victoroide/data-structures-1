/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee13;

/**
 *
 * @author cvict
 */

public class ApplicationHora {
    private int horas;
    private int minutos;
    private int segundos;

    public ApplicationHora(int horas, int minutos, int segundos) {
        if (!horaValida(horas, minutos, segundos)) {
            throw new IllegalArgumentException("Hora inválida.");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void adelantar(int h, int m, int s) {
        this.segundos += s;
        this.minutos += this.segundos / 60;
        this.segundos %= 60;

        this.minutos += m;
        this.horas += this.minutos / 60;
        this.minutos %= 60;

        this.horas += h;
        this.horas %= 24;
    }

    public void reiniciar(int h, int m, int s) {
        if (!horaValida(h, m, s)) {
            throw new IllegalArgumentException("Hora inválida.");
        }
        this.horas = h;
        this.minutos = m;
        this.segundos = s;
    }

    public void imprimir() {
        System.out.printf("Hora actual: %02d:%02d:%02d\n", horas, minutos, segundos);
    }

    private boolean horaValida(int h, int m, int s) {
        return h >= 0 && h < 24 && m >= 0 && m < 60 && s >= 0 && s < 60;
    }
}