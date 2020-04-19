package com.RJML.x00103719;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String nombre, puesto;
    protected double salario;
    protected List<Documento> documentos;


    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<Documento>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addDocumento(Documento documentito) {
        documentos.add(documentito);

    }

    public void removeDocumento(String nombre){
        documentos.removeIf(a -> {
            if (a.getNombre().equals(nombre)) {
                System.out.println("---Se ha eliminado con éxito--- ");
                return true;
            } else {
                return false;
            }
        });
    }
}
