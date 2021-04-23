package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Seccional {
    private String nombre;
    private  List<Automotor> automotores;

    public Seccional(String nombre){
        this.automotores = new ArrayList<>();
        this.nombre = nombre;
    }


    public void agregarAutomotor(Automotor automotor){
        automotores.add(automotor);
    }


    public void listarAutomotores(){
        for (Automotor a: automotores) {
            System.out.println(a);
        }
    }


    // 2)Se desea poder listar a todos los propietarios (en orden alfabético) de camiones.
    public List<String> imprimirPropietariosCamiones(){
        List<String> nombrePropietariosCamiones = new ArrayList<>();
        for(Automotor automotor: automotores){
            if (automotor.getClass() == Camion.class)
                nombrePropietariosCamiones.add(automotor.getPropietario().getNombre());
        }
        Collections.sort(nombrePropietariosCamiones);
        return nombrePropietariosCamiones;
    }


    public boolean pasoMasDeUnAñoDesdeElRegistro(String patente){
        for (Automotor automotor : automotores) {
            if (automotor.getPatente().equals(patente)){
                LocalDate fechaRegistro = automotor.getFechaDeAlta();
                Period periodoDeAlta = Period.between(fechaRegistro, LocalDate.now());
                if (periodoDeAlta.getYears() >= 1){
                    return true;
                }
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Automotor> getAutomotores() {
        return automotores;
    }

    public void setAutomotores(List<Automotor> automotores) {
        this.automotores = automotores;
    }

    @Override
    public String toString() {
        return "Seccional{" +
                "nombre='" + nombre + '\'' +
                ", automotores=" + automotores +
                '}';
    }
}

