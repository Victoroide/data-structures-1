/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise;

/**
 *
 * @author cvict
 */
public class TDABitWise {
    int x;
    public TDABitWise()
    {
        this.x=0;
    }
    public void Setbit1(int pos)
    {
        if(pos<=32)
        {
            int mask=1;
            mask=mask<<pos-1;
            x=x|mask;
        }
    }
    public void SetBit0(int pos)
    {
        if (pos<=32) 
        {
          int mask=1;
          mask=mask<<pos-1;
          mask=~mask;
          x=x&mask;
        }
    }
    public int Getbit(int pos)
    {
        int mask=1;
        mask=mask<<pos-1;
        mask=mask&x;
        mask=mask>>>pos-1;
        return(mask);
    }

    @Override
    public String toString() {
        String S="X[";
        for (int i = 32; i >= 1; i--) {
            S=S+" "+Getbit(i);
        }
        S=S+" ]";
        return(S);
    }
    
    public String toString2() {
        String S="[";
        for (int i = 32; i >= 1; i--) {
            S=S+" "+Getbit(i);
        }
        S=S+" ]";
        return(S);
    }
    public static void main(String[]args)
    {
        TDABitWise P=new TDABitWise();
        System.out.println(P);
        P.Setbit1(1);
        P.Setbit1(2);
        P.Setbit1(3);
        P.Setbit1(4);
        System.out.println(P);
    }
}

