package com.RJML.x00103719;

public final class CalculadoraImpuestos {
    private static double totalRenta = 0, totalISSS = 0, totalAFP = 0;

    public CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado contratado) {
        System.out.println("-------Calculando Pago--------");
        double isss = 0, PagoEmpleado = 0, afp = 0, Renta = 0;
        double Restante = 0, salarioLiq = contratado.getSalario();

        if (contratado instanceof PlazaFija) {
            afp = 0.0625 * salarioLiq;
            isss = 0.03 * salarioLiq;
            Restante = salarioLiq - afp - isss;
            if (Restante >= 0.01 && Restante <= 472.00)
                Renta = 0; //probar con = Restante
            else if (Restante >= 472.01 && Restante <= 895.24)
                Renta = (0.1 * (Restante - 472.00) + 17.67);
            else if (Restante >= 895.25 && Restante <= 2038.10)
                Renta = (0.2 * (Restante - 895.24) + 60);
            else if (Restante >= 2038.11) {
                Renta = (0.3 * (Restante - 2038.10) + 288.57);
            }

        }else
            Renta = 0.1 * salarioLiq;
        PagoEmpleado = salarioLiq - Renta;
        totalRenta += Renta;
        totalAFP += afp;
        totalISSS += isss;

        return PagoEmpleado;
    }

    public static String mostrarTotales(){
        return ("Total AFP: " + totalAFP + " Total ISSS: " + totalISSS + " Total Renta: " + totalRenta);
    }
}
