/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class Memoria {
    
    /** direccionMaxima, es el máximo de registros en la memoria. */
    int direccionMaxima=16;
    /** vector, es el vector donde se almacenan los datos. */
    String[] vector=new String[direccionMaxima];
    
    public void enlaceCodigo(){
        // e=(a+b+c)/3
        this.escritura(0,  "000000000078");  // a= 120
        this.escritura(1,  "000000000140");  // b= 320
        this.escritura(2,  "0000000000FF");  // c= 255
        this.escritura(3,  "000000000000");  // x
        this.escritura(4,  "000000000076");  // d= 118
        this.escritura(5,  "0000000001B8");  // e= 440
        this.escritura(6,  "000000000042");  // f= 66
        this.escritura(7,  "000000000000");  // y
        this.escritura(8,  "000000000032");  // g= 50
        this.escritura(9,  "000000000088");  // h= 136
        this.escritura(10,  "000000000296");  // i= 662
        this.escritura(11,  "000000000000");  // z   
        this.escritura(12, "0001000000010010");  // x=(a+b+c)/3
        this.escritura(13, "0001010001100111");  // y=(d+e+f)/3
        this.escritura(14, "0001100110101011");  // x=(g+h+i)/3
        this.escritura(15, "1111000000000000");  

    }
    
    /**
     * Este método ejecuta una operación de lectura sobre la memoria.
     * @param direccion, es la dirección de memoria que se quiere recuperar. 
     * @return regresa el valor almancenado en la dirección solicitada. 
     */
    public String lectura(int direccion){
        return this.vector[direccion];
    }
    
    /**
     * Este método ejecuta la operación escritura sobre la memoria de la computadora. 
     * @param direccion, es la dirección donde se va almacenar el dato
     * @param valor, es el valor del dato que se quiere almacenar. 
     */
    public void escritura(int direccion, String valor){
        this.vector[direccion]=valor;
        //System.out.println(valor);
    }
    
    
    public void muestraMemoria(){
        int i;
        String salida;
        for (i=0; i<this.direccionMaxima; i++){
            salida="["+i+"]="+this.vector[i];
            System.out.println(salida);
        }
    }
    
}
