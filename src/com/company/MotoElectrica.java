package com.company;

import java.util.List;

public class MotoElectrica extends Automotor implements VehiculoElectrico {
    private Integer voltaje;

    public MotoElectrica(Conductor propietario, List<Conductor> autorizados, Uso uso, Integer voltaje) {
        super(propietario, autorizados, uso);
        this.voltaje = voltaje;
    }

    @Override
    public Integer indicarVoltaje() {
        return voltaje;
    }
}
