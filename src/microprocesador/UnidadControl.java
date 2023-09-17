/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class UnidadControl {
    String registroInstruccion=new String();
     /** es el registro que sabe la instrucción que se está ejecutando. */
     int contadorPrograma;
     /** esta variable es parte del decodificador y almacena la instrucción a ejecutarse. */
     String decodificarInstruccion=new String();
     /** esta variable es parte del decodificador y almacena la dirección del primer dato de la instruccion. */
     String decodificarDato1=new String();
     /** esta variable es parte del decodificador y almacena la dirección del segundo dato de la instruccion. */
     String decodificarDato2 = new String();
     /** esta variable es parte del decodificador y almacena la dirección del tercer dato de la instruccion. */
     String decodificarDato3 = new String();
     /** es la variable que contiene la dirección de donde se debe almacenar el resultado. */
     String decodificarResultado=new String();
    
     /**
      * Esta es el método constructor que se encarga de iniciar los atributos
      * de la clase. 
      */
    public  UnidadControl(){
        registroInstruccion="";
        contadorPrograma=0;
        decodificarInstruccion="";
        decodificarDato1="";
        decodificarDato2="";
        decodificarDato3 = "";
        decodificarResultado="";
    }
    
    /**
     * Este método muestra el contenido de los atributos de la clase y las 
     * imprime en la línea de comandos. 
     */
    public void muestraUC(){
        System.out.println("Registro de Instruccion="+this.registroInstruccion);
        System.out.println("contadorPrograma="+this.contadorPrograma);
        System.out.println("decodificarInstruccion="+this.decodificarInstruccion);
        System.out.println("decodificarDato1="+this.decodificarDato1);
        System.out.println("decodificarDato2="+this.decodificarDato2);
        System.out.println("decodificarDato3="+this.decodificarDato3);
        System.out.println("decodificarResultado="+this.decodificarResultado);
    }
    
    /**
     * Este método recupera la instrucción siguiente apuntada por el "contador
     * de programa" y lo pasa al registro de instrucción como lo indica la 
     * teoría del concepto de microprocesador. 
     */
     public void instructionFetch(){         
         microprocesador.MicroprocesadorVectores.UC.registroInstruccion=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(this.contadorPrograma);
    }
     
     /**
      * Este método sirve para realizar las acciones del decodificador de instrucciones de la memoria. 
      */
    public void decode(){
        this.decodificarInstruccion=this.registroInstruccion.substring(0, 4);
        this.decodificarDato1=this.registroInstruccion.substring(4,8);
        this.decodificarDato2=this.registroInstruccion.substring(8,12);
        this.decodificarDato3=this.registroInstruccion.substring(12,16);
        this.decodificarResultado=this.decodificarDato3;
        microprocesador.MicroprocesadorVectores.ALU.operacion=Integer.parseInt(this.decodificarInstruccion,2);
        microprocesador.MicroprocesadorVectores.ALU.banderas[0]=1;
    }
    
    /**
      * Este método recupera de memoria los datos necesarios para completar
      * la instrucción en funciones y los valores son pasados a la ALU para que
      * sean procesados. 
      */
     public void dataFetch(){
         int tmp;

         tmp= Integer.parseInt(this.decodificarDato1,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntrada1=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(9, 12);
         microprocesador.MicroprocesadorVectores.ALU.banderas[1]=1;
         
         tmp= Integer.parseInt(this.decodificarDato2,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntrada2=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(9, 12);
         microprocesador.MicroprocesadorVectores.ALU.banderas[2]=1;
         
         tmp= Integer.parseInt(this.decodificarDato3,2);
         microprocesador.MicroprocesadorVectores.ALU.registroEntrada3=microprocesador.MicroprocesadorVectores.MEMORIA.lectura(tmp).substring(9, 12);
         microprocesador.MicroprocesadorVectores.ALU.banderas[2]=1;
     }
     
     public int execute(){
        int salida;
        salida=microprocesador.MicroprocesadorVectores.ALU.ejecutarInstruccion();
        return salida;
    }
     
     /**
     * Este método almacena el resultado de la ejecución de una instrucción en la memoria donde diga el Registro decodificador.
     */
    public void store(){
        String tmp = "00000000";
        int direccion;
        int dato;
        tmp = microprocesador.MicroprocesadorVectores.ALU.acumulador;

        dato= Integer.parseInt(tmp, 16);
        
        direccion=Integer.parseInt(microprocesador.MicroprocesadorVectores.UC.decodificarResultado,2);
        
        System.out.println(direccion);
        
        microprocesador.MicroprocesadorVectores.MEMORIA.escritura(direccion, tmp);
        microprocesador.MicroprocesadorVectores.UC.contadorPrograma++;
    }
}
