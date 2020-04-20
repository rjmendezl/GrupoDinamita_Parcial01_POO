package com.RJML.x00103719;

import java.util.ArrayList;

public class Empresa{

    private String nombre;
    protected ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.planilla = new ArrayList<>();
    }




    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado s){
        planilla.add(s);

    }

    public void quitEmpleado(String nombre) throws NotExistingEmployeeException {
        boolean existeEmpleado = false;
        for (Empleado empleado : planilla){
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                existeEmpleado = true;
                break;
            }
        }
        if (!existeEmpleado)
            throw new NotExistingEmployeeException("El empleado no está registrado en planilla. ");
        else
            planilla.removeIf(empleado -> empleado.getNombre().equalsIgnoreCase(nombre));
    }

}
