/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.ConjuntoRango;

/**
 *
 * @author cvict
 */
public class TDABitWise {
    int valor;

    public TDABitWise() {
        this.valor = 0;
    }

    public void establecerBit1(int posicion) {
        if (posicion <= 32) {
            int mascara = 1;
            mascara = mascara << (posicion - 1);
            valor = valor | mascara;
        }
    }

    public void establecerBit0(int posicion) {
        if (posicion <= 32) {
            int mascara = 1;
            mascara = mascara << (posicion - 1);
            mascara = ~mascara;
            valor = valor & mascara;
        }
    }

    public int obtenerBit(int posicion) {
        int mascara = 1;
        mascara = mascara << (posicion - 1);
        mascara = mascara & valor;
        mascara = mascara >>> (posicion - 1);
        return mascara;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Valor[");
        for (int i = 32; i >= 1; i--) {
            sb.append(" ").append(obtenerBit(i));
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        TDABitWise array = new TDABitWise();
        System.out.println(array);
        array.establecerBit1(1);
        array.establecerBit1(2);
        array.establecerBit1(3);
        array.establecerBit1(4);
        System.out.println(array);
    }
}