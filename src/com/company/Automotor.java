package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Automotor {
    private Conductor propietario;
    private List<Conductor> autorizados;
    private Uso uso; //false: profesional , true :particular
    private String patente;
    private LocalDate fechaDeAlta;
    private LocalDate fechaCambioPropietario;
    private List<String> patentes = new ArrayList<>();


    public Automotor(Conductor propietario, List<Conductor> autorizados, Uso uso) {
        this.propietario = propietario;
        this.autorizados = new ArrayList<>();
        this.uso = uso;
        try {
            this.patente = setPatente();
        } catch (DatosIncorrectosException e) {
            e.printStackTrace();
        }
        this.fechaDeAlta = LocalDate.now();
        this.fechaCambioPropietario = LocalDate.now();
    }


    public Conductor getPropietario() {
        return propietario;
    }

    public void agregarAutorizados(Conductor conductor){
        autorizados.add(conductor);
    }


    public List<Conductor> getAutorizados() {
        return autorizados;
    }

    public Uso getUso() {
        return uso;
    }

    public String generarPatente(){
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            if(i < 3)
                patente += (char)(rnd.nextInt(26) + 65);
            else
                patente += rnd.nextInt(10);
        }
        return patente;
    }


    public String setPatente() throws DatosIncorrectosException{
        Boolean aux = false;
        do {
            patente = generarPatente();
            for (String p: patentes) {
                if (patente.equals(p)){
                    aux = true;
                }
            }
        }while (aux);
        if ((patente.length() != 10)){
            throw new DatosIncorrectosException("La patente debe contener 6 caracteres");
        }else
            patentes.add(patente);
        return patente;
    }


    public String getPatente() {
        return patente;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public LocalDate getFechaCambioPropietario() {
        return fechaCambioPropietario;
    }

    //6)No se puede cambiar de propietario si pasó menos de 1 año desde la fecha del último cambio de propietario.

    public String cambiarPropietario(Conductor propietario) {
        Period periodoDeUltimoCambioPropietario = Period.between(fechaCambioPropietario, LocalDate.now());
        if (periodoDeUltimoCambioPropietario.getYears() >= 1) {
            this.propietario = propietario;
            fechaCambioPropietario = LocalDate.now();
            return "El cambio de propietario fue exitoso.";
        }
        return "Pero el cambio de propietario no se pudo registrar porque no pasó un año desde el último cambio.";
    }


    @Override
    public String toString() {
        return "Automotor que posee los siguientes datos: "+
                "Propietario= " + propietario +
                ", Autorizados= " + autorizados +
                ", para uso= " + getUso() +
                ", con patente= " + patente +
                ", Fecha De Alta= " + fechaDeAlta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Fecha Cambio Propietario= " + fechaCambioPropietario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
                '.';
    }
}

