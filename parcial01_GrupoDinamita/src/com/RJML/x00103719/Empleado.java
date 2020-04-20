package com.RJML.x00103719;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre, puesto;
    protected double salario;
    protected ArrayList<Documento> documentos;
    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
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

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addDocumento(Documento documentito) {
        documentos.add(documentito);

    }

    public void removeDocumento(String nombre) {
        documentos.removeIf(documento -> documento.getNombre().equalsIgnoreCase(nombre));
    }
    @Override
    public String toString() {
        String auxiliar = "";
        for (Documento doc : documentos){
            auxiliar += doc.toString() + "\n";
        }
        return "Nombre : " + nombre +
                "\nPuesto : "+ puesto +
                "\nSalario : $" + String.format("%.2f",salario) +
                "\nDocumentos: \n"
                + auxiliar;
    }
}