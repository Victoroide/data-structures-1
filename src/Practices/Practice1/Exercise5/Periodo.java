/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise5;

/**
 *
 * @author cvict
 */
public class Periodo {
    private int years;
    private int months;
    private int days;

    public static Periodo createFromDays(int days) {
        return new Periodo(0, 0, days);
    }

    public static Periodo createFromMonthsAndDays(int months, int days) {
        return new Periodo(0, months, days);
    }

    public static Periodo createFromYearsMonthsDays(int years, int months, int days) {
        return new Periodo(years, months, days);
    }

    private Periodo(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public int translateToDays() {
        int totalDays = this.days;
        totalDays += this.months * 30; // Assuming 30 days per month for simplicity
        totalDays += this.years * 365; // Assuming 365 days per year
        return totalDays;
    }

    @Override
    public String toString() {
        String result = "";
        if (years > 0) {
            result += years + (years == 1 ? " año" : " años");
        }
        if (months > 0) {
            if (!result.isEmpty()) result += ", ";
            result += months + (months == 1 ? " mes" : " meses");
        }
        if (days > 0) {
            if (!result.isEmpty()) result += " y ";
            result += days + (days == 1 ? " día" : " días");
        }
        return result.isEmpty() ? "0 días" : result;
    }
}

