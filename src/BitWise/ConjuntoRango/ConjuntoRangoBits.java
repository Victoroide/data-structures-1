/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.ConjuntoRango;

/**
 *
 * @author cvict
 */

public class ConjuntoRangoBits {
    TDABitWise[] bitwiseArrays;
    int cantidad;
    int inicioRango;
    int finRango;
    
    public ConjuntoRangoBits(int inicioRango, int finRango) {
        this.inicioRango = inicioRango;
        this.finRango = finRango;
        int totalElementos = finRango - inicioRango + 1;
        int numArrays = totalElementos / 32;
        if (totalElementos % 32 != 0) {
            numArrays++;
        }
        this.bitwiseArrays = new TDABitWise[numArrays];
        for (int i = 0; i < numArrays; i++) {
            bitwiseArrays[i] = new TDABitWise();
        }
    }
    
    private int calcularIndiceBit(int elemento) {
        return ((elemento - 1) % 32) + 1;
    }

    private int calcularIndiceArray(int elemento) {
        return (elemento - 1) / 32;
    }

    public void insertar(int elemento) {
        if ((elemento >= inicioRango) && (elemento <= finRango)) {
            int indiceArray = calcularIndiceArray(elemento - inicioRango);
            int indiceBit = calcularIndiceBit(elemento - inicioRango);
            bitwiseArrays[indiceArray].establecerBit1(indiceBit);
        } else {
            System.out.println("Error al insertar: Elemento fuera de rango");
            System.exit(1);
        }
    }

    public boolean pertenece(int elemento) {
        int indiceArray = calcularIndiceArray(elemento - inicioRango);
        int indiceBit = calcularIndiceBit(elemento - inicioRango);
        return bitwiseArrays[indiceArray].obtenerBit(indiceBit) == 1;
    }

    public void eliminar(int elemento) {
        if (elemento <= cantidad) {
            int indiceArray = calcularIndiceArray(elemento);
            int indiceBit = calcularIndiceBit(elemento);
            bitwiseArrays[indiceArray].establecerBit0(indiceBit);
        } else {
            System.out.println("Error al eliminar: Elemento fuera de rango");
            System.exit(1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Conjunto={");
        for (int i = inicioRango; i <= finRango; i++) {
            if (pertenece(i)) {
                sb.append(i).append(" , ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        ConjuntoRangoBits conjunto = new ConjuntoRangoBits(1, 10);
        conjunto.insertar(1);
        conjunto.insertar(2);
        conjunto.insertar(3);
        System.out.println(Integer.toBinaryString(conjunto.calcularIndiceBit(3)));
        conjunto.insertar(4);
        conjunto.insertar(5);
        System.out.println(conjunto.toString());
    }
}