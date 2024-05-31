/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.COVIDAnalysis;

/**
 *
 * @author cvict
 */
public class COVIDDataAnalysis {
    BitwiseVector data[]; // Arreglo de vectores bitwise para almacenar los datos
    int capacity = 100; // Capacidad inicial del arreglo
    int recordCount; // Contador de registros
    String names[]; // Arreglo para almacenar los nombres
    
    public COVIDDataAnalysis(){
        data = new BitwiseVector[3]; // Inicializa el arreglo de vectores bitwise
        data[0] = new BitwiseVector(capacity, 24); // Vector para CI
        data[1] = new BitwiseVector(capacity, 19); // Vector para edad, género y peso
        data[2] = new BitwiseVector(capacity, 9); // Vector para síntomas
        names = new String[capacity]; // Inicializa el arreglo de nombres
        recordCount = 0; // Inicializa el contador de registros
    }

    // Método para insertar un nuevo registro de datos.
    public void insert(int id, int age, int gender, int weight, String name, int fever, int chestPain, int musclePain, int cough,
                         int breathlessness, int smellLoss, int throatPain, int diarrhea, int tasteLoss){
        recordCount++; // Incrementa el contador de registros
        data[0].insert(id, recordCount); // Inserta el CI en el primer vector
        gender = gender << 7; // Desplaza género 7 bits a la izquierda
        gender = gender | age; // Combina edad y género
        weight = weight << 8; // Desplaza peso 8 bits a la izquierda
        weight = weight | gender; // Combina peso con edad y género
        data[1].insert(weight, recordCount); // Inserta el dato combinado en el segundo vector
        
        // Combina los síntomas en un solo entero utilizando desplazamientos y operaciones OR bitwise
        chestPain = chestPain << 1;
        chestPain = chestPain | fever;
        musclePain = musclePain << 2;
        musclePain = musclePain | chestPain;
        cough = cough << 3;
        cough = cough | musclePain;
        breathlessness = breathlessness << 4;
        breathlessness = breathlessness | cough;
        smellLoss = smellLoss << 5;
        smellLoss = smellLoss | breathlessness;
        throatPain = throatPain << 6;
        throatPain = throatPain | smellLoss;
        diarrhea = diarrhea << 7;
        diarrhea = diarrhea | throatPain;
        tasteLoss = tasteLoss << 8;
        tasteLoss = tasteLoss | diarrhea;
        data[2].insert(tasteLoss, recordCount); // Inserta el dato combinado en el tercer vector
        names[recordCount - 1] = name; // Almacena el nombre en el arreglo de nombres
    }

    // Método para convertir el objeto a una cadena de texto.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= recordCount; i++) {
            sb.append("Registro ").append(i).append(": ").append(data[0].get(i)).append(", ").append(data[1].get(i)).append(", ").append(data[2].get(i)).append(", Nombre: ").append(names[i - 1]).append("\n");
        }
        return sb.toString();
    }
}
