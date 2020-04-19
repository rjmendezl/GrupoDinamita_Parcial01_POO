package com.RJML.x00103719;

import java.util.ArrayList;
import java.util.List;

public class Empresa{

    private String nombre;
    protected ArrayList<Empleado> planilla;

    public Empresa(String nombre, ArrayList<Empleado> planilla) {
        this.nombre = nombre;
        this.planilla = planilla;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado s){
        planilla.add(s);

    }

    public void quitEmpleado(String nombre){
        planilla.removeIf(a -> {
            if (a.getNombre().equals(nombre)) {
                System.out.println("---Se ha eliminado con exito--- ");
                return true;
            } else {
                return false;
            }
        });
    }

}
