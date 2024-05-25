/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise7;

/**
 *
 * @author cvict
 */

public class ApplicationDupla {
    private final int first;
    private final int second;

    public ApplicationDupla(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public ApplicationDupla multiply(int multiplier) {
        return new ApplicationDupla(first * multiplier, second * multiplier);
    }

    public ApplicationDupla add(int addition) {
        return new ApplicationDupla(first + addition, second + addition);
    }

    public static ApplicationDupla sum(ApplicationDupla a, ApplicationDupla b) {
        return new ApplicationDupla(a.getFirst() + b.getFirst(), a.getSecond() + b.getSecond());
    }

    public static ApplicationDupla subtract(ApplicationDupla a, ApplicationDupla b) {
        return new ApplicationDupla(a.getFirst() - b.getFirst(), a.getSecond() - b.getSecond());
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

