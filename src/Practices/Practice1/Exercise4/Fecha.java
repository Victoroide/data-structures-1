/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise4;

/**
 *
 * @author cvict
 */
public class Fecha {
    private int year;
    private int month;
    private int day;

    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Fecha createFromTextWithTwoDigitYear(char[] dateText) {
        int year = Integer.parseInt(new String(dateText, 4, 2));
        int month = Integer.parseInt(new String(dateText, 2, 2));
        int day = Integer.parseInt(new String(dateText, 0, 2));
        year += (year >= 70) ? 1900 : 2000;
        return new Fecha(day, month, year);
    }

    public static Fecha createFromTextWithFullYear(char[] dateText) {
        int year = Integer.parseInt(new String(dateText, 4, 4));
        int month = Integer.parseInt(new String(dateText, 2, 2));
        int day = Integer.parseInt(new String(dateText, 0, 2));
        return new Fecha(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("Fecha: %02d/%02d/%d", day, month, year);
    }
}
