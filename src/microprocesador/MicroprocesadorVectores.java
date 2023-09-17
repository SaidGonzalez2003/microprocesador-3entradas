/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package microprocesador;

/**
 *
 * @author Alan
 */
public class MicroprocesadorVectores {

    /**
     * MEMORIA, es la clase que implementa una memoria fuera del
     * microprocesador.
     */
    static Memoria MEMORIA;
    /**
     * UC, es la clase que implementa la funcionalidad de una Unidad de Control.
     */
    static UnidadControl UC;
    /**
     * ALU, es la clase que implementa una unidad aritmética-lógica.
     */
    static ALU ALU;

    /**
     * numeroOperaciones, es el atributo que cuenta el número de operaciones
     * realizadas.
     */
    int numeroOperaciones;
    /**
     * numeroNucleos, es el atributo que cuenta el número de núcleos en el
     * microprocesador.
     */
    int numeroNucleos;
    /**
     * usoHilos, este atributo decide que la implementación usa hilos o no.
     */
    int usoHilos;

    /**
     * Este es el método constructor de la clase que inicia los atributos de la
     * misma para llevar una estadística de las operaciones realizadas.
     */
    public MicroprocesadorVectores() {
        numeroOperaciones = 0;
        numeroNucleos = 0;
        usoHilos = 0;
    }

    /**
     * Este método es para uso de depuración del programa.
     *
     * @return salida, es para saber cuando el microprocesador debe detenerse.
     */
    public static int cicloDeComputoDEBUG() {
        /**
         * salida, es una variable que declara si el microprocesador debe
         * terminar o no.
         */
        int salida;

        System.out.println("INICIA---------------------");
        System.out.println("---------------------");
        System.out.println("INSTRUCTION FETCH");
        System.out.println("---------------------");
        UC.instructionFetch();
        UC.muestraUC();
        ALU.muestraALU();

        System.out.println("---------------------");
        System.out.println("DECODE");
        System.out.println("---------------------");
        UC.decode();
        UC.muestraUC();
        ALU.muestraALU();

        System.out.println("---------------------");
        System.out.println("DATA FETCH");
        System.out.println("---------------------");
        UC.dataFetch();
        UC.muestraUC();
        ALU.muestraALU();

        System.out.println("---------------------");
        System.out.println("EXECUTE");
        System.out.println("---------------------");
        salida = UC.execute();
        UC.muestraUC();
        ALU.muestraALU();
        MEMORIA.muestraMemoria();

        System.out.println("---------------------");
        System.out.println("STORE");
        System.out.println("---------------------");
        UC.store();
        UC.muestraUC();
        ALU.muestraALU();
        MEMORIA.muestraMemoria();
        System.out.println("FINALIZA---------------------");

        //salir
        return salida;
    }

    public static void main(String[] args) {

        MEMORIA = new Memoria();
        UC = new UnidadControl();
        ALU = new ALU();

        int i;
        int salida;

        UC.contadorPrograma = 12;

        //MEMORIA.iniciaMemoria();
        MEMORIA.enlaceCodigo();

        do {
            salida = microprocesador.MicroprocesadorVectores.cicloDeComputoDEBUG();
        } while (salida == 0);

    }

}
