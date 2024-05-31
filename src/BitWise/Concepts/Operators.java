/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BitWise.Concepts;

/**
 *
 * @author cvict
 */
public class Operators {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // AND Operation
        int a = 5; // 0101 in binary
        int b = 3; // 0011 in binary
        int andResult = a & b; // result is 1 (0001 in binary)
        System.out.println("AND: " + andResult); // Prints: AND: 1

        // OR Operation
        int orResult = a | b; // result is 7 (0111 in binary)
        System.out.println("OR: " + orResult); // Prints: OR: 7

        // XOR Operation
        int xorResult = a ^ b; // result is 6 (0110 in binary)
        System.out.println("XOR: " + xorResult); // Prints: XOR: 6

        // NOT Operation
        int notResult = ~a; // result is -6 (inverts the bits)
        System.out.println("NOT: " + notResult); // Prints: NOT: -6

        // Left Shift Operation
        int leftShiftResult = a << 1; // result is 10 (1010 in binary)
        System.out.println("Left Shift: " + leftShiftResult); // Prints: Left Shift: 10

        // Right Shift Operation
        int rightShiftResult = a >> 1; // result is 2 (0010 in binary)
        System.out.println("Right Shift: " + rightShiftResult); // Prints: Right Shift: 2

        // Unsigned Right Shift Operation
        int unsignedRightShiftResult = -5 >>> 1; // result depends on internal binary representation
        System.out.println("Unsigned Right Shift: " + unsignedRightShiftResult);
    }
}
