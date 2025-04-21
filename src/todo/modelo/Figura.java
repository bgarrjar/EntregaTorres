package todo.modelo;

public abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String getTipo(); // Para saber si es Caballo, Reina o Disco

    // 👇 Subclases internas
    public static class Caballo extends Figura {
        public Caballo(String nombre) {
            super(nombre);
        }

        @Override
        public String getTipo() {
            return "Caballo";
        }
    }

    public static class Reina extends Figura {
        public Reina(String nombre) {
            super(nombre);
        }

        @Override
        public String getTipo() {
            return "Reina";
        }
    }

    public static class Disco extends Figura {
        private int ancho;

        public Disco(String nombre, int ancho) {
            super(nombre);
            this.ancho = ancho;
        }

        public int getAncho() {
            return ancho;
        }

        @Override
        public String getTipo() {
            return "Disco";
        }
    }
}
