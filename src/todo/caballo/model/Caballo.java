//Representa la figura tipo caballo en el juego.
package todo.caballo.model;

import todo.modelo.Figura; //Importa la clase Figura para heredar de ella

public class Caballo extends Figura { //Crea clase Caballo que hereda de Figura
    public Caballo(String nombre) { //Constructor que recibe el nombre del caballo
        super(nombre);
    }

    @Override //Reescribe el método getNombre() de la clase Figura
    public String getTipo() { //Si se llama a este método, devuelve el tipo de figura
        return "Caballo";
    }
}


