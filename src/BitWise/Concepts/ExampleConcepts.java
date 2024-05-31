/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BitWise.Concepts;

/**
 *
 * @author cvict
 */
public class ExampleConcepts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejemplo práctico combinando datos
        int edad = 25;  // 7 bits
        int genero = 1; // 1 bit
        int peso = 70;  // 8 bits

        int datos = 0;
        datos = datos | edad;        // edad en los bits menos significativos
        datos = datos | (genero << 7); // desplazamos género 7 bits a la izquierda
        datos = datos | (peso << 8);   // desplazamos peso 8 bits a la izquierda

        System.out.println("Datos combinados: " + datos);

        // Extraer los datos
        int maskEdad = (1 << 7) - 1; // 01111111 (máscara para extraer la edad)
        int maskGenero = 1 << 7;     // 10000000 (máscara para extraer el género)
        int maskPeso = (1 << 8) - 1; // 11111111 (máscara para extraer el peso)

        int extraidoEdad = datos & maskEdad;
        int extraidoGenero = (datos & maskGenero) >> 7;
        int extraidoPeso = (datos >> 8) & maskPeso;

        System.out.println("Edad: " + extraidoEdad);
        System.out.println("Género: " + extraidoGenero);
        System.out.println("Peso: " + extraidoPeso);
    }
    
}
