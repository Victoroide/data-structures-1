/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercisee14;

/**
 *
 * @author cvict
 */

public class ApplicationComplejoReal {
    private double parteReal;
    private double parteImaginaria;

    public ApplicationComplejoReal() {
        this.parteReal = 0.0;
        this.parteImaginaria = 0.0;
    }

    public void establecer(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public void imprimir() {
        System.out.printf("Número complejo: %.2f + %.2fi\n", parteReal, parteImaginaria);
    }

    public void agregar(ApplicationComplejoReal otro) {
        this.parteReal += otro.parteReal;
        this.parteImaginaria += otro.parteImaginaria;
    }

    public void agregar(double parteReal, double parteImaginaria) {
        this.parteReal += parteReal;
        this.parteImaginaria += parteImaginaria;
    }
}
