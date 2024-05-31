/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BitWise.COVIDAnalysis;

/**
 *
 * @author cvict
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        COVIDDataAnalysis dataAnalysis = new COVIDDataAnalysis(); // Crea una instancia de COVIDDataAnalysis
        
        // Inserta dos registros de datos
        dataAnalysis.insert(13398272, 19, 1, 74, "Julian Alvarez", 0, 0, 1, 1, 0, 1, 0, 0, 0);
        dataAnalysis.insert(11111111, 20, 0, 60, "Nicki Nicole", 1, 0, 0, 0, 0, 1, 0, 0, 0);
        
        // Imprime el análisis de datos
        System.out.println(dataAnalysis);
    }
}

/*
    Explicación de los resultados:

    Registro 1: 13398272, 19091, 44, Nombre: Julian Alvarez
    - 13398272: CI (Carnet de Identidad).
    - 19091: Combinación de edad, género y peso.
      - Edad: 25 años (últimos 7 bits).
      - Género: Masculino (bit 8).
      - Peso: 74 kg (bits restantes).
    - 44: Combinación de síntomas.
      - Fiebre: No (bit 0).
      - Dolor en el pecho: No (bit 1).
      - Dolor muscular: Sí (bit 2).
      - Tos: No (bit 3).
      - Dificultad para respirar: Sí (bit 4).
      - Pérdida de olfato: No (bit 5).
      - Dolor de garganta: Sí (bit 6).
      - Diarrea: No (bit 7).
      - Pérdida de gusto: No (bit 8).

    Registro 2: 11111111, 15380, 33, Nombre: Nicki Nicole
    - 11111111: CI (Carnet de Identidad).
    - 15380: Combinación de edad, género y peso.
      - Edad: 60 años (últimos 7 bits).
      - Género: Femenino (bit 8).
      - Peso: 60 kg (bits restantes).
    - 33: Combinación de síntomas.
      - Fiebre: Sí (bit 0).
      - Dolor en el pecho: No (bit 1).
      - Dolor muscular: No (bit 2).
      - Tos: No (bit 3).
      - Dificultad para respirar: No (bit 4).
      - Pérdida de olfato: Sí (bit 5).
      - Dolor de garganta: No (bit 6).
      - Diarrea: No (bit 7).
      - Pérdida de gusto: No (bit 8).
*/

