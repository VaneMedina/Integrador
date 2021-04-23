package com.company;


public class Conductor {
    private String nombre;
    private String direccion;
    private int dni;


    public Conductor(String nombre, String direccion, int dni){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDni(int dni){
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "" +
                "Nombre= " + nombre +
                ", Direccion= " + direccion +
                ", Dni= " + dni;
    }
}

























