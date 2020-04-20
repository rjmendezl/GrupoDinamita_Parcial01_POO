package com.RJML.x00103719;

public final class CalculadoraImpuestos {
    private static double totalRenta = 0, totalISSS = 0, totalAFP = 0;
    private CalculadoraImpuestos() {
    }
    public static double calcularPago(Empleado empleado) {
        double isss = 0, pagoEmpleado, afp = 0, renta = 0;
        double restante, salarioLiq = empleado.getSalario();
        if (empleado instanceof PlazaFija) {
            afp = 0.0625 * salarioLiq;
            isss = 0.03 * salarioLiq;
            restante = salarioLiq - afp - isss;
            if (restante >= 0.01 && restante <= 472.00)
                renta = 0;
            else if (restante >= 472.01 && restante <= 895.24)
                renta = (0.1 * (restante - 472.00) + 17.67);
            else if (restante >= 895.25 && restante <= 2038.10)
                renta = (0.2 * (restante - 895.24) + 60);
            else if (restante >= 2038.11) {
                renta = (0.3 * (restante - 2038.10) + 288.57);
            }
            pagoEmpleado = restante - renta;
        }else{
            renta = 0.1 * salarioLiq;
            pagoEmpleado = salarioLiq - renta;
        }
        totalRenta += renta;
        totalAFP += afp;
        totalISSS += isss;
        return pagoEmpleado;
    }
    public static String mostrarTotales(){
        return ("\nTotal AFP: "+String.format("%.2f",totalAFP) +"\nTotal ISSS: "+String.format("%.2f",totalISSS)+"\nTotal Renta: "+String.format("%.2f",totalRenta));
    }
}