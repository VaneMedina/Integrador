package com.company;

import java.util.List;

public class AutoElectrico extends Automotor implements VehiculoElectrico {
    private Integer voltaje;

    public AutoElectrico(Conductor propietario, List<Conductor> autorizados, Uso uso, int voltaje) {
        super(propietario, autorizados, uso);
        this.voltaje = voltaje;
    }

    @Override
    public Integer indicarVoltaje() {
        return voltaje;
    }
}
