/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.Encuesta;

/**
 *
 * @author cvict
 */
public class VectorBits {
    int[] vector;
    int cantidad;
    int bitsPorElemento;

    public VectorBits(int numElementos, int bitsPorElemento) {
        int numBits = numElementos * bitsPorElemento;
        int numEnteros = numBits / 32;
        if ((numBits % 32) != 0) {
            numEnteros++;
        }
        vector = new int[numEnteros];
        cantidad = numElementos;
        this.bitsPorElemento = bitsPorElemento;
    }
    
    private int calcularPosicionBit(int pos) {
        return ((pos - 1) * bitsPorElemento % 32);
    }
    
    private int calcularPosicionEntero(int pos) {
        return ((pos - 1) * bitsPorElemento / 32);
    }
    
    public void insertar(int elemento, int pos) {
        if (pos <= cantidad) {
            int elemento1 = elemento;
            int mascara = (int) Math.pow(2, bitsPorElemento) - 1;
            int numBits = calcularPosicionBit(pos);
            int numEntero = calcularPosicionEntero(pos);
            mascara = mascara << numBits;
            mascara = ~mascara;
            vector[numEntero] = vector[numEntero] & mascara;
            elemento = elemento << numBits;
            vector[numEntero] = vector[numEntero] | elemento;
            if ((numBits + bitsPorElemento) > 32) {
                int mascara1 = (int) Math.pow(2, bitsPorElemento) - 1;
                mascara1 = mascara1 >>> (32 - numBits);
                mascara1 = ~mascara1;
                vector[numEntero + 1] = vector[numEntero + 1] & mascara1;
                elemento1 = elemento1 >>> (32 - numBits);
                vector[numEntero + 1] = vector[numEntero + 1] | elemento1;
            }
        }
    }
    
    public int sacar(int pos) {
        int mascara = (int) ((Math.pow(2, bitsPorElemento) - 1));
        int numBits = calcularPosicionBit(pos);
        int numEntero = calcularPosicionEntero(pos);
        mascara = mascara << numBits;
        mascara = mascara & vector[numEntero];
        mascara = mascara >>> numBits;
        if ((numBits + bitsPorElemento) > 32) {
           int mascara1 = (int) ((Math.pow(2, bitsPorElemento) - 1));
           mascara1 = mascara1 >>> (32 - numBits);
           mascara1 = mascara1 & vector[numEntero + 1];
           mascara1 = mascara1 << (32 - numBits);
           mascara = mascara | mascara1;
        }
        return mascara;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vector =[ ");
        for (int i = 1; i <= cantidad; i++) {
            sb.append(sacar(i)).append(" , ");
        }
        sb.append(" ]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
    }
}