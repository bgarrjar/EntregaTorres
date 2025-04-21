package todo.reinas.model;

import todo.modelo.Figura;

public class Reina extends Figura {

    public Reina(String nombre) {
        super(nombre);
    }

    @Override
    public String getTipo() {
        return "Reina";
    }
}

