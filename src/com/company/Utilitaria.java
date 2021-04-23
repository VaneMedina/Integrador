package com.company;

import java.util.List;
import java.util.Scanner;

public abstract class Utilitaria {

    public static int getInt(){
        Scanner sc = new Scanner(System.in);
        String texto = "";
        int numero= 0;
        boolean correcto = false;

        do {
            texto = sc.nextLine();
            try {
                numero = Integer.parseInt(texto);
                correcto = true;
            }catch (NumberFormatException e){
                System.out.println("Ingrese un  numero correcto.");
            }
        }while (!correcto);
        return numero;
    }


    public static void imprimirLineasDivisorias(){
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void imprimirTexto(){
        System.out.println("Ingrese la opción que desee.");
        System.out.println("1: Listar los autos registrados en todas las seccionales.");
        System.out.println("2: Listar a todos los propietarios (en orden alfabético) de camiones.");
        System.out.println("3: Cambiar el propietario de un automotor.");
        System.out.println("4: Dar alta a un automotor.");
        System.out.println("5: Conocer si pasó más de un año desde la fecha de registro del automotor.");
        System.out.println("0: Finalizar");
        imprimirLineasDivisorias();
    }

    public static void imprimirMenu(List<Seccional> seccionales, Automotor automotor, Conductor conductor){
        int op = Utilitaria.getInt();
        do {
            switch (op) {
                case 1:
                    //Imprimo automotores de una seccional.
                    System.out.println("Los automotores de la seccional "+seccionales.get(0).getNombre()+" son: ");
                    System.out.println();
                    seccionales.get(0).listarAutomotores();
                    Utilitaria.imprimirLineasDivisorias();
                    Utilitaria.imprimirTexto();
                    op = Utilitaria.getInt();
                    break;
                case 2:
                    //Muestro los nombres de los propietarios de camiones ordenados alfabeticamente
                    System.out.println("Los propietarios de camiones de las seccionales ordenados alfabeticamente son: ");
                    for (Seccional seccional : seccionales) {
                        for (String propietarioCamion : seccional.imprimirPropietariosCamiones()) {
                            System.out.println("-" + propietarioCamion);
                        }
                    }
                    Utilitaria.imprimirLineasDivisorias();
                    Utilitaria.imprimirTexto();
                    op = Utilitaria.getInt();
                    break;
                case 3:
                    //camion1 quiere cambiar de propietario por propietario1.
                    System.out.println("Ud. está por cambiar el propietario del "+automotor+" por el propietario " +conductor+".");
                    System.out.println(automotor.cambiarPropietario(conductor));
                    Utilitaria.imprimirLineasDivisorias();
                    Utilitaria.imprimirTexto();
                    op = Utilitaria.getInt();
                    break;
                case 4:
                    //Se agrega automotor a la lista de los automotores de la seccion con nombre "Mar del Plata".
                    seccionales.get(0).agregarAutomotor(automotor);
                    System.out.println(seccionales.get(0).getAutomotores());
                    System.out.println("El automotor fue agregado con exito.");
                    Utilitaria.imprimirLineasDivisorias();
                    Utilitaria.imprimirTexto();
                    op = Utilitaria.getInt();
                    break;
                case 5:
                    //Conocer si pasó mas de un año desde la fecha de registro de un automotor.
                    String patente = automotor.getPatente();
                        if (!(seccionales.get(0).pasoMasDeUnAñoDesdeElRegistro(patente)));
                            System.out.println("No pasó mas de un año desde la fecha de registro del automotor.");
                    Utilitaria.imprimirLineasDivisorias();
                    Utilitaria.imprimirTexto();
                    op = Utilitaria.getInt();
                    break;
            }
        } while (op != 0);
    }
}











