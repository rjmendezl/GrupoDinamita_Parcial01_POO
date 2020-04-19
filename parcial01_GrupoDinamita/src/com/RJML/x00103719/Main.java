package com.RJML.x00103719;

import java.util.Scanner;

public class Main {
    //Scanner
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Se inicializa la variable opción
        byte opc = 0;
        //do while
        do{
            //Se muestra el menú
            System.out.println(mostrarMenu());
            //Se le pide al usuario indicar su opción
            opc = in.nextByte(); in.nextLine();
            //switch
            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while(opc != 0);
    }
    public static String mostrarMenu(){
        return "--------------Menú--------------\n" +
                "0) Salir\n" +
                "1) Agregar empleado\n" +
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n";
    }
}
