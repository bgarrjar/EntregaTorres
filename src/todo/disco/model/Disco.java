package todo.disco.model;

import todo.modelo.Figura;

public class Disco extends Figura {
    private int ancho;
    private String color;

    public Disco(String nombre, int ancho, String color) {
        super(nombre);
        this.ancho = ancho;
        this.color = color;
    }

    public int getAncho() {
        return ancho;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getTipo() {
        return "Disco";
    }
}


