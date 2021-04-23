package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Seccional> seccionales = new ArrayList<>();
        Seccional seccional1 = new Seccional("Mar del Plata");
        seccionales.add(seccional1);
        List<Conductor> autorizados = new ArrayList<>();

        //Genero instancias de Conductor
        Conductor propietario1 = new Conductor("Milo", "av Pepito", 40533297);
        Conductor propietario2 = new Conductor("Pepe", "Las Heras", 40533298);
        Conductor propietario3 = new Conductor("Alberto", "Las Acacias", 40533296);

        //Genero instancias de Automotor
        Colectivo colectivo = new Colectivo(propietario1, autorizados, Uso.PARTICULAR, "f", 3);
        colectivo.agregarAutorizados(new Conductor("Toto", "aldrey", 12345678));
        colectivo.agregarAutorizados(new Conductor("Vane", "luro", 34343456));
        colectivo.agregarAutorizados(new Conductor("Pablo", "FSD", 567565));

        Camion camion1 = new Camion(propietario1, autorizados, Uso.PROFESIONAL, "ds", 5);
        camion1.agregarAutorizados(new Conductor("Nestor", "las heras", 28222489));
        Camion camion2 = new Camion(propietario2, autorizados, Uso.PARTICULAR, "ds", 5);
        Camion camion3 = new Camion(propietario3, autorizados, Uso.PROFESIONAL, "ds", 5);
        AutoElectrico ae = new AutoElectrico(propietario1, autorizados, Uso.PARTICULAR, 6);

        //Agrego automotores a seccional
        seccionales.get(0).agregarAutomotor(camion1);
        seccionales.get(0).agregarAutomotor(camion2);
        seccionales.get(0).agregarAutomotor(colectivo);
        seccionales.get(0).agregarAutomotor(camion3);

        System.out.println("¡Bienvenido!");
        Utilitaria.imprimirLineasDivisorias();
        Utilitaria.imprimirTexto();

        //Imprimo menu y asigno la lista de seccionales y las instancias que voy a usar de prueba.
        Utilitaria.imprimirMenu(seccionales, camion1, propietario1);
    }
}








