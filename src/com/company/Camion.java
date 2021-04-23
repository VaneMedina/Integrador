package com.company;

import java.util.List;

public class Camion extends Automotor implements VehiculoCombustion {
    private String tipoCombustible;
    private Integer capacidadTanque;

    public Camion(Conductor propietario, List<Conductor> autorizados, Uso uso, String tipoCombustible, Integer capacidadTanque) {
        super(propietario, autorizados, uso);
    }


    @Override
    public String indicarTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public Integer indicarCapacidadTanque() {
        return capacidadTanque;
    }

}
