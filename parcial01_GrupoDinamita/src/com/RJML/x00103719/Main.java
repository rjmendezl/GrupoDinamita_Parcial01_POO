package com.RJML.x00103719;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre, puesto;
        double salario;
        Empleado auxEmpleado;
        int extension,mesesDeContrato, tipo;
        Empresa papitas = new Empresa("Papitas");
        String menuPrincipal = "\n-------------------------Menú-------------------------\n" +
                "Por favor, seleccione una de las siguientes opciones:\n\n" +
                "1. Agregar Empleado\n" +
                "2. Despedir Empleado\n" +
                "3. Ver lista de empleados\n" +
                "4. Calcular sueldo\n" +
                "5. Mostrar Totales\n" +
                "0. Salir\n"+
                "Su opción : ";
        byte op = 6;
        do {
            try {
                System.out.print(menuPrincipal);
                op = in.nextByte(); in.nextLine();
            }catch(InputMismatchException ime) {
                System.out.println("\nSólo puedes ingresar números.");
                in.next();
            }

            switch (op) {
                case 1:
                    try {
                        System.out.println("\n-------Agregando Empleado--------");
                        System.out.print("\nNombre: ");
                        nombre = in.nextLine();
                        if (nombre.isEmpty())
                            throw new EmptyFieldException("Debe ingresar un nombre.");
                        System.out.print("Desea que sea \n1.Plaza Fija o 2.Servicio Profesional?: ");
                        tipo = in.nextInt();
                        in.nextLine();
                        switch (tipo) {
                            case 1:
                                System.out.print("Puesto: ");
                                puesto = in.nextLine();
                                if (puesto.isEmpty())
                                    throw new EmptyFieldException("Debe ingresar un puesto.");
                                System.out.print("Salario: ");
                                salario = in.nextDouble();
                                in.nextLine();
                                if (salario <= 0)
                                    throw new EmptyFieldException("Debe ingresar un salario válido.");
                                System.out.print("Extension: ");
                                extension = in.nextInt();
                                if (extension <=0)
                                    throw new EmptyFieldException("Debe ingresar una extensión válida.");
                                in.nextLine();
                                auxEmpleado = new PlazaFija(nombre, puesto, salario, extension);
                                solicitarDocumentos(auxEmpleado);
                                papitas.addEmpleado(auxEmpleado);
                                break;
                            case 2:
                                System.out.print("Puesto: ");
                                puesto = in.nextLine();
                                if (puesto.isEmpty())
                                    throw new EmptyFieldException("Debe ingresar un puesto.");
                                System.out.print("Salario: ");
                                salario = in.nextDouble();
                                in.nextLine();
                                if (salario == 0)
                                    throw new EmptyFieldException("Debe ingresar un salario.");
                                System.out.print("Meses de Contrato: ");
                                mesesDeContrato = in.nextInt();
                                if (mesesDeContrato==0)
                                    throw new EmptyFieldException("Debe ingresar la cantidad de meses de contrato.");
                                in.nextLine();
                                auxEmpleado = new ServicioProfesional(nombre, puesto, salario, mesesDeContrato);
                                solicitarDocumentos(auxEmpleado);
                                papitas.addEmpleado(auxEmpleado);
                                break;
                            default:
                                System.out.println("La opción ingresada es inválida.");
                                break;
                        }
                    } catch (ExistingDocumentException|EmptyFieldException e) {
                        System.out.println(e.getMessage() + "\nEl empleado no pudo ser ingresado.");
                    } catch (InputMismatchException e) {
                        System.out.println("Datos numéricos erroneos.\nEl empleado no pudo ser ingresado.");
                        in.nextLine();
                    }
                    break;
                case 2:
                    try{
                        System.out.println("\nIngrese el nombre de empleado a despedir : ");
                        nombre = in.nextLine();
                        if (nombre.isEmpty())
                            throw new EmptyFieldException("Debe ingresar un nombre.");
                        papitas.quitEmpleado(nombre);
                        System.out.println("El empleado ha sido despedido con éxito.");
                    }catch (EmptyFieldException | NotExistingEmployeeException e){
                        System.out.println(e.getMessage() + "\nEl empleado no pudo ser despedido.");
                    }
                    break;
                case 3:
                    System.out.println("\n-------Mostrando empleados--------");
                    for (Empleado e : papitas.getPlanilla()){
                        System.out.println(e.toString());
                    }
                    break;
                case 4:try{
                    boolean existeEmpleado = false;
                    System.out.println("\n-------Calcular salario--------");
                    System.out.print("Ingrese el nombre del empleado : ");
                    nombre = in.nextLine();
                    if (nombre.isEmpty())
                        throw new EmptyFieldException("Debe ingresar un nombre de empleado a consultar.");
                    for (Empleado empleado : papitas.getPlanilla()){
                        if (empleado.getNombre().equalsIgnoreCase(nombre))
                            existeEmpleado = true;
                    }
                    if (!existeEmpleado)
                        throw new NotExistingEmployeeException("El empleado no está registrado en planilla.");
                    else
                        for (Empleado empleado : papitas.getPlanilla()){
                            if (empleado.getNombre().equalsIgnoreCase(nombre))
                                System.out.println("El salario líquido  de " + nombre + " es de: $"+ String.format("%.2f",CalculadoraImpuestos.calcularPago(empleado)));
                        }
                }catch (EmptyFieldException | NotExistingEmployeeException e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 5:
                    System.out.print("\n-------Mostrando totales--------");
                    System.out.println(CalculadoraImpuestos.mostrarTotales());
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }
    public static void solicitarDocumentos(Empleado empleado) throws EmptyFieldException, ExistingDocumentException{
        String nombreDeDocumento, numeroDeDocumento;
        char opcion;
        do {
            System.out.print("Ingrese el nombre de documento: ");
            nombreDeDocumento = in.nextLine();
            if (nombreDeDocumento.isEmpty())
                throw new EmptyFieldException("Debe ingresar un nombre de documento.");
            else for (Documento doc: empleado.getDocumentos()){
                if (doc.getNombre().equalsIgnoreCase(nombreDeDocumento))
                    throw new ExistingDocumentException("\nEl documento ya ha sido ingresado.");
            }
            System.out.print("Ingrese el número de documento: ");
            numeroDeDocumento = in.nextLine();
            System.out.print("¿Desea agregar otro documento?(s/n):  ");
            opcion = in.nextLine().toLowerCase().charAt(0);
            empleado.addDocumento(new Documento(nombreDeDocumento,numeroDeDocumento));
        }while(opcion != 'n');
    }
}
