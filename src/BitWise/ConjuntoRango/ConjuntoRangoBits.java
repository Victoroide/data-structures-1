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
    TDABitWise C[];
    int cant;
    int RangoInicio;
    int RangoFinal;
    
    public ConjuntoRangoBits(int rangoInicio,int rangoFinal){
        this.RangoInicio=rangoInicio;
        this.RangoFinal=rangoFinal;
        int Nele=RangoFinal-RangoInicio+1;
        int Nbw=Nele/32;
        if (Nele%32!=0) {
            Nbw++;
        }
            this.C=new TDABitWise[Nbw];
        for (int i = 0; i < Nbw; i++) {
            C[i]=new TDABitWise();
            }
    }
    private int CalcNbit(int ele)
    {
        return(((ele-1)%32)+1);
    }
     private int CalcNBW(int ele)
    {
        return((ele-1)/32);
    }
    public void Insertar(int elemento)
    {
         if ((elemento>=RangoInicio)&&(elemento<=RangoFinal)) {
            int NBW=CalcNBW(elemento-RangoInicio);
            int Nbit=CalcNbit(elemento-RangoInicio);
            C[NBW].Setbit1(Nbit);
        }
        else
        {
            System.out.println("Error::CojuntoBit:Eliminar:Elemento Fuera de Rango");
            System.exit(1);
        }
    }
    public boolean Pertenece(int ele)
    {
        int NBW=CalcNBW(ele-RangoInicio);
        int Nbit=CalcNbit(ele-RangoInicio);
        return(C[NBW].Getbit(Nbit)==1);
    }
  /*  public void SetCant(int cantidad)
    {
        this.cant=cantidad;
    }
    public int getCantidad()
    {
        return this.cant;
    }*/
     public void Eliminar(int ele)
    {
        if (ele<=cant) {
            int NBW=CalcNBW(ele);
            int Nbit=CalcNbit(ele);
            C[NBW].SetBit0(Nbit);
            
        }
        else
        {
            System.out.println("Error::ConjuntioBit:Eliminar:Elemento fuera de Rango");
            System.exit(1);
        }
    }
    public String toString() {
        String S="C={";
        for (int i = RangoInicio; i <= RangoFinal; i++) {
            if(Pertenece(i))
            S=S+i+" , ";
        }
        S=S+"}";
        return S;
    }
    public static void main(String[]args)
    {
        ConjuntoRangoBits A=new ConjuntoRangoBits(1,10);
        A.Insertar(1);
        A.Insertar(2);
        A.Insertar(3);
        System.out.println(Integer.toBinaryString(A.CalcNbit(3)));
        A.Insertar(4);
        A.Insertar(5);
        System.out.println(A.toString());
    }
     
}

