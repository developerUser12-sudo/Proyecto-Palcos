package com.reservapalcos.reservapalcos.enums;

public enum DiasSemana {
    DOMINGORAMOS("Domingo de Ramos"), LUNES("Lunes Santo"), MARTES("Martes Santo"), MIERCOLES("Miércoles Santo"), JUEVES("Jueves Santo"), VIERNES("Viernes Santo"), SABADO("Sábado Santo");
    private final String nombre;

    DiasSemana(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
