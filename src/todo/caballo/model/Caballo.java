package todo.caballo.model;

import todo.modelo.Figura;

public class Caballo extends Figura {

    public Caballo(String nombre) {
        super(nombre);
    }

    @Override
    public String getTipo() {
        return "Caballo";
    }
}

