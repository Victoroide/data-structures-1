/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee15;

/**
 *
 * @author cvict
 */

public class ApplicationFecha {
    private int dia;
    private int mes;
    private int año;

    public ApplicationFecha(int dia, int mes, int año) {
        establecerFecha(dia, mes, año);
    }

    public void establecerFecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        normalizar();
    }

    public String obtenerProximaFecha() {
        ApplicationFecha proximaFecha = new ApplicationFecha(dia, mes, año);
        proximaFecha.dia++;
        proximaFecha.normalizar();
        return proximaFecha.toString();
    }

    public String formatoCorto() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public String formatoLargo() {
        String nombreMes = obtenerNombreMes(mes);
        return String.format("%02d de %s de %04d", dia, nombreMes, año);
    }

    public void cambiarDia(int nuevoDia) {
        dia = nuevoDia;
        normalizar();
    }

    public void cambiarMes(int nuevoMes) {
        mes = nuevoMes;
        normalizar();
    }

    public void cambiarAño(int nuevoAño) {
        año = nuevoAño;
        normalizar();
    }

    public int obtenerDia() {
        return dia;
    }

    public int obtenerMes() {
        return mes;
    }

    public int obtenerAño() {
        return año;
    }

    public void reiniciar(int d, int m, int a) {
        establecerFecha(d, m, a);
    }

    public void adelantar(int d, int m, int a) {
        dia += d;
        mes += m;
        año += a;
        normalizar();
    }

    public void imprimir() {
        System.out.println(formatoCorto());
    }

    private void normalizar() {
        while (mes > 12) {
            mes -= 12;
            año++;
        }
        if (mes < 1) mes = 1;
        
        int diasDelMes = diasEnMes(mes, año);
        while (dia > diasDelMes) {
            dia -= diasDelMes;
            mes++;
            if (mes > 12) {
                mes = 1;
                año++;
            }
            diasDelMes = diasEnMes(mes, año);
        }
        if (dia < 1) dia = 1;
    }

    private int diasEnMes(int mes, int año) {
        switch (mes) {
            case 2: return (esAñoBisiesto(año)) ? 29 : 28;
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }

    private boolean esAñoBisiesto(int año) {
        if (año % 4 == 0) {
            if (año % 100 == 0) {
                return año % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    private String obtenerNombreMes(int mes) {
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return nombresMeses[mes - 1];
    }

    @Override
    public String toString() {
        return formatoCorto();
    }
}