/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.COVIDAnalysis;

/**
 *
 * @author cvict
 */
public class BitwiseVector {
    int V[]; // Arreglo de enteros para almacenar los datos compactados
    int dim; // Dimensión del vector
    int nbits; // Número de bits por elemento

    public BitwiseVector(int capacity, int nbits) {
        int nb = capacity * nbits; // Total de bits necesarios
        int NE = nb / 32; // Número de enteros necesarios
        if ((nb % 32) != 0) {
            NE++; // Incrementa si hay un resto
        }
        V = new int[NE]; // Inicializa el arreglo de enteros
        this.dim = capacity; // Asigna la capacidad
        this.nbits = nbits; // Asigna el número de bits por elemento
    }
    
    // Calcula el índice del entero en el que se encuentra el bit.
    private int calculateElement(int pos) {
        return (((pos - 1) * nbits) / 32);
    }
    
    // Calcula la posición del bit dentro del entero.
    private int calculateBit(int pos) {
        return (((pos - 1) * nbits) % 32);
    }
    
    // Inserta un valor en una posición específica.
    public void insert(int value, int position){
        int value1 = value; // Copia del valor a insertar
        int mask = (int)Math.pow(2, nbits) - 1; // Máscara para limpiar bits
        int elementIndex = calculateElement(position); // Índice del entero
        int bitIndex = calculateBit(position); // Índice del bit
        mask = mask << bitIndex; // Desplaza la máscara
        mask = ~mask; // Invierte la máscara
        V[elementIndex] = V[elementIndex] & mask; // Limpia los bits en la posición
        value = value << bitIndex; // Desplaza el valor
        V[elementIndex] = V[elementIndex] | value; // Inserta el valor en la posición
        if ((bitIndex + nbits) > 32) { // Si el valor se extiende a otro entero
            int mask1 = (int)Math.pow(2, nbits) - 1;
            mask1 = mask1 >>> (32 - bitIndex);
            value1 = value1 >>> (32 - bitIndex);
            mask1 = ~mask1;
            V[elementIndex + 1] = V[elementIndex + 1] & mask1;
            V[elementIndex + 1] = V[elementIndex + 1] | value1;
        }
    }
    
    // Obtiene un valor de una posición específica.
    public int get(int position){
        int mask = (int)Math.pow(2, nbits) - 1; // Máscara para extraer bits
        int elementIndex = calculateElement(position); // Índice del entero
        int bitIndex = calculateBit(position); // Índice del bit
        mask = mask << bitIndex; // Desplaza la máscara
        mask = mask & V[elementIndex]; // Aplica la máscara
        mask = mask >>> bitIndex; // Desplaza el resultado
        if ((bitIndex + nbits) > 32) { // Si el valor se extiende a otro entero
            int mask1 = (int)Math.pow(2, nbits) - 1;
            mask1 = mask1 >>> (32 - bitIndex);
            mask1 = mask1 & V[elementIndex + 1];
            mask1 = mask1 << (32 - bitIndex);
            mask = mask | mask1;
        }
        return mask;
    }

    // Convierte el vector a una cadena de texto.
    @Override
    public String toString() {
        String S = "V={";
        for (int i = 1; i <= dim; i++) {
            S = S + get(i) + " , ";
        }
        S = S + "}";
        return S;
    }
}