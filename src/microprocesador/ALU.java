/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class ALU {
    
    /** operacion, muestra la operación que está en ejecución. Esta operación 
     * está ya en número decimal. 
     */
    int operacion;
    /** registroEntrada1, es el registro de entrada 1 de la ALU. */
    String registroEntrada1;

    /** registroEntrada1, es el registro de entrada 2 de la ALU. */
    String registroEntrada2;
    /** registroEntrada1, es el registro de entrada 3 de la ALU. */
    String registroEntrada3;
    /** acumulador, es el registro donde se almacena el resultado de la operación
     * recién ejecutada. 
     */
    String acumulador;
    /** banderas, es el vector que almacenan las banderas del sistema, los valores son:
     * 0-InstruccionLista, 1-Dato1Listo, 2-Dato2Listo, 3-ResultadoListo
     */
    int[] banderas=new int[5];
    
    /**
     * este método constructor es para iniciar los atributos de la clase. 
     */
    public ALU(){
        acumulador="0";
        operacion=0;
        registroEntrada1 = "";
        registroEntrada2 = "";
        registroEntrada3 = "";
    }
    
    public void muestraALU(){
        System.out.println("operacion="+this.operacion);
        System.out.println("registroEntrada1="+this.registroEntrada1);
        System.out.println("registroEntrada2="+this.registroEntrada2);
        System.out.println("registroEntrada3="+this.registroEntrada3);
        System.out.println("acumulador="+this.acumulador);
        System.out.println("Banderas="+this.banderas[0]+","+this.banderas[1]+","+this.banderas[2]+","+this.banderas[3]);
    }
    
    /**
     * Es una de las operaciones de la ALU. La operación es la SUMA de los elementos. 
     * @param a, es el primero valor de la operación.
     * @param b, es el segundo valor de la operación.
     * @return regresa el valor de la suma de los elementos.
     */
    public String promedio (String dato1,String dato2, String dato3){
        double tmp1=Integer.parseInt(dato1,16);
        double tmp2=Integer.parseInt(dato2,16);
        double tmp3=Integer.parseInt(dato3,16);
        
        double res = (tmp1 + tmp2 + tmp3) / 3;
        
        int redondear =(int) Math.round(res);
        
        return String.format("%04X",  Integer.parseInt(String.valueOf(redondear), 10));
        
    }
    
    public int ejecutarInstruccion(){
        int salida=0;
        
        switch(this.operacion){
            case 1:
                this.acumulador=this.promedio(
                        this.registroEntrada1, 
                        this.registroEntrada2,
                        this.registroEntrada3);
                
                this.banderas[3]=1;
                salida=0;
                break;
            
            case 15:
                salida=1;
                break;
        }
        return salida;
    }
    
}
