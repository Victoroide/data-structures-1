/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitWise.Encuesta;

/**
 *
 * @author cvict
 */
public class TDAEncuesta {
    VectorNbits V1;
    VectorNbits V2CI;
    VectorNbits V3Telefono;
  //  VectorNbits V4Hora;
    int cant;
    String[] Nombre;

    public TDAEncuesta(int cantidad) {
        Nombre=new String[cantidad];
        V1=new VectorNbits(cantidad,26);
        V2CI=new VectorNbits(cantidad,27);
        V3Telefono=new VectorNbits(cantidad,27);
   //     V4Hora=new VectorNbits(cantidad,17);
        cant=1;
    }
    
    public void insertar(String nombre,int dia,int mes,int anio,int nroHijos,
            int estadoCivil,int primaria,int bachiller,int Tecnico,int Licenciado,
            int Postgrado,int ci,int telefono){
        int mask=dia;
          // System.out.println(Integer.toBinaryString(mask));
            mask=mask<<4;
            mask=mask|mes;//5+4=9;
          //  System.out.println(Integer.toBinaryString(mask));
            mask=mask<<6;
            anio=anio-1980;
            mask=mask|anio;
            mask=mask<<4;
            mask=mask|nroHijos;
            mask=mask<<2;
            mask=mask|estadoCivil;
            mask=mask<<1;
            mask=mask|primaria;
            mask=mask<<1;
            mask=mask|bachiller;
            mask=mask<<1;
            mask=mask|Tecnico;
            mask=mask<<1;
            mask=mask|Licenciado;
            mask=mask<<1;
            mask=mask|Postgrado;
          //   System.out.println(Integer.toBinaryString(mask));
            V1.insertar(mask, cant);
            System.out.println(V1.toString());
            V2CI.insertar(ci, cant);
            V3Telefono.insertar(telefono, cant);
     //       int mask2=hora;
     //       mask2=mask2<<6;
     //       mask2=mask2|minuto;
     //       mask2=mask2<<6;
     //       mask2=mask2|segundo;
     //       V4Hora.insertar(mask2, cant);
            Nombre[cant-1]=nombre;
            cant++;
    }
    public int getCantidad()
    {
        return cant;
    }
    public String getNombre(int pos)
    {
        return Nombre[pos-1];
    }        
     
    public int getdia(int pos){
        int dato=V1.sacar(pos);
        //26-5=21;
        int mask=(int)(Math.pow(2, 5)-1);
        dato=dato>>>21;
        dato=dato&mask;
        return dato;
    }
     public int getMes(int pos){
        int dato=V1.sacar(pos);
        //21-4=17;
        int mask=(int)(Math.pow(2, 4)-1);
        dato=dato>>>17;
        dato=dato&mask;
        return dato;
    }
      public int getAño(int pos){
        int dato=V1.sacar(pos);
        //17-6=11;
        int mask=(int)(Math.pow(2, 6)-1);
        dato=dato>>>11;
        dato=dato&mask;
        dato=dato+1980;
        return dato;
    }
      
     public int getNroHijos(int pos){
        int dato=V1.sacar(pos);
        //11-4=7;
        int mask=(int)(Math.pow(2, 4)-1);
        dato=dato>>>7;
        dato=dato&mask;
        return dato;
    }
     
      public String getEstadoCivil(int pos){
        int dato=V1.sacar(pos);
        //7-2=5;
        int mask=(int)(Math.pow(2, 2)-1);
        dato=dato>>>5;
        dato=dato&mask;
        String S="";
        if((dato==0)||(dato==1)||(dato==2)||(dato==3))
        {
            switch(dato){
                case 0:
                    S=S+"Soltero";
                    break;
                case 1:
                    S=S+"Casado";
                    break;
                case 2:
                    S=S+"Divorsiado";
                    break;
                case 3:
                    S=S+"Viudo";
            }
        }
        return S;
    }
       public int getPrimaria(int pos){
        int dato=V1.sacar(pos);
        //5-1=4;
        int mask=(int)(Math.pow(2, 1)-1);
        dato=dato>>>4;
        dato=dato&mask;
        return dato;
    }
    
    public int getBachiller(int pos){
        int dato=V1.sacar(pos);
        //4-1=3;
        int mask=(int)(Math.pow(2, 1)-1);
        dato=dato>>>1;
        dato=dato&mask;
        return dato;
    }
     public int getTecnico(int pos){
        int dato=V1.sacar(pos);
        //3-1=2;
        int mask=(int)(Math.pow(2, 1)-1);
        dato=dato>>>2;
        dato=dato&mask;
        return dato;
    }
      
    public int getLicenciado(int pos){
        int dato=V1.sacar(pos);
        //2-1=1;
        int mask=(int)(Math.pow(2, 1)-1);
        dato=dato>>>1;
        dato=dato&mask;
        return dato;
    }
    
    public int getPostGrado(int pos){
        int dato=V1.sacar(pos);
        //1-1=0;
        int mask=(int)(Math.pow(2, 1)-1);
        dato=dato>>>1;
        dato=dato&mask;
        return dato;
    }
    
    //-----------------------------------------------
    public int getCI(int pos)
    {
         int dato=V2CI.sacar(pos);
        //27-27=0;
        int mask=(int)(Math.pow(2, 27)-1);
        dato=dato>>>0;
        dato=dato&mask;
        return dato;
    }
    
    public int getTelefono(int pos)
    {
        int dato=V3Telefono.sacar(pos);
        //27-27=0;
        int mask=(int)(Math.pow(2, 27)-1);
        dato=dato>>>0;
        dato=dato&mask;
        return dato;
    }
    
   /* public int getHora(int pos)
    {
        int dato=V4Hora.sacar(pos);
        //17-5=12;
        int mask=(int)(Math.pow(2, 5)-1);
        dato=dato>>>12;
        dato=dato&mask;
        return dato;
    }*/
    
   /* public int getMinuto(int pos)
    {
        int dato=V4Hora.sacar(pos);
        //12-6=6;
        int mask=(int)(Math.pow(2, 6)-1);
        dato=dato>>>6;
        dato=dato&mask;
        return dato;
    }*/
    
  /*  public int getSegundo(int pos)
    {
         int dato=V4Hora.sacar(pos);
        //6-6=0;
        int mask=(int)(Math.pow(2, 6)-1);
        dato=dato>>>0;
        dato=dato&mask;
        return dato;
    }*/
    
    public String Mostrar(int pos) {
        String s="";
        s=s + "\nNro: "+ pos
            + "\nNombre: "+ getNombre(pos)
            + "\nFecha Nacimiento: "+getdia(pos)+ " / "+getMes(pos)+" / "+ getAño(pos)
            + "\nNroHijos: "+getNroHijos(pos)
            + "\nEstado Civil: "+getEstadoCivil(pos)
            + "\nPrimaria: "+(getPrimaria(pos)==1 ? "si" : "no")    
            + "\nBachiller: "+(getBachiller(pos)==1 ? "si" : "no") 
            + "\nTecnico: "+(getTecnico(pos)==1 ? "si" : "no")    
            + "\nLicenciatura: "+(+getLicenciado(pos)==1 ? "si" : "no")
            + "\nPost Grado: "+(getPostGrado(pos)==1 ? "si" : "no")
            + "\nCI: "+getCI(pos)
            + "\nTelefono: "+getTelefono(pos);
       //     + "\nHora: "+getHora(pos)+":"+getMinuto(pos)+":"+getSegundo(pos);
        return s;
    }
    
    
    
    public static void main(String[] args)
    {
        TDAEncuesta A=new TDAEncuesta(10);
        A.insertar("Mario", 31, 12, 2023, 10, 3, 1,1,1,1,1,12315321,70265765);
      //  System.out.println(A.getNombre(1));
      //  System.out.println(A.getdia(1));
      //  System.out.println(A.getMes(1));
      //  System.out.println(A.getAño(1));
      //  System.out.println(A.getNroHijos(1));
      //  System.out.println(A.getTelefono(1));
      //  System.out.println(A.getHora(1));
      //  System.out.println(A.getMinuto(1));
      //  System.out.println(A.getSegundo(1));
        //System.out.println(A.Mostrar(1))
       System.out.println(A.Mostrar(1));
    }
}

