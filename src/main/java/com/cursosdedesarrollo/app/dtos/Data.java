package com.cursosdedesarrollo.app.dtos;

/**
 * Created by pepesan on 15/04/2023.
 */

@lombok.Data
public class Data {
    private String nombre;
    private Integer edad;

    public Data() {
        this.nombre = "";
        this.edad = 0;
    }
    public Data(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

}
