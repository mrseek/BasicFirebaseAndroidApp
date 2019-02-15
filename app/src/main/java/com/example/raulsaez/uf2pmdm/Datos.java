package com.example.raulsaez.uf2pmdm;

public class Datos {

    String matricula, marca, color;

    //Clase que nos permite manipular los diferentes datos matricula, marca y color

    public Datos(String matricula, String marca, String color){
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
    }

    //setters y getters de los datos a manipular
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }
}
