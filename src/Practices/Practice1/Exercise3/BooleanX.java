/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise3;

/**
 *
 * @author cvict
 */
public class BooleanX {
    private boolean value;

    public BooleanX(int conditionAsInt) {
        this.value = conditionAsInt != 0;
    }

    public static BooleanX and(BooleanX b1, BooleanX b2) {
        return new BooleanX(b1.value && b2.value ? 1 : 0);
    }

    public static BooleanX or(BooleanX b1, BooleanX b2) {
        return new BooleanX(b1.value || b2.value ? 1 : 0);
    }

    public static BooleanX not(BooleanX b) {
        return new BooleanX(!b.value ? 1 : 0);
    }

    @Override
    public String toString() {
        return this.value ? "verdadero" : "falso";
    }
}

