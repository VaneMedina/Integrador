package com.company;

import java.util.List;

public class Utilitario extends Automotor implements VehiculoCombustion {
    private String tipoCombustible;
    private Integer capacidadTanque;

    public Utilitario(Conductor propietario, List<Conductor> autorizados, Uso uso, String tipoCombustible, Integer capacidadTanque) {
        super(propietario, autorizados, uso);
        this.tipoCombustible = tipoCombustible;
        this.capacidadTanque = capacidadTanque;
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
