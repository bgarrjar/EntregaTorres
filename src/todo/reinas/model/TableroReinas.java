//Aqui el sistema busca una forma de colocar N reinas en el tablero
package todo.reinas.model;

import todo.modelo.Figura;
import todo.modelo.Nodo;
import todo.reinas.model.Reina;

import java.util.ArrayList; //Para guardar los movimientos
import java.util.List;

public class TableroReinas {
    private int dimension; //Tamaño del tablero
    private int[] posiciones; // Guarda la columna donde está la reina en cada fila
    private List<Nodo> movimientos; // Lista de movimientos de las reinas

    public TableroReinas(int dimension) { //Constructor
        this.dimension = dimension;
        this.posiciones = new int[dimension]; //Crea un array de posiciones
        this.movimientos = new ArrayList<>(); //Crea una lista vacía de movimientos
    }

    public boolean resolver() {
        return colocarReina(0);
    } //Método que coloca las reinas

    private boolean colocarReina(int fila) {
        if (fila == dimension) { //Si se han colocado todas las reinas se ha encontrado una solución
            generarMovimientos();
            return true;
        }
        for (int columna = 0; columna < dimension; columna++) {
            if (esValido(fila, columna)) {
                posiciones[fila] = columna;
                if (colocarReina(fila + 1)) return true;
            }
        }
        return false;
    }

    private boolean esValido(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            int col = posiciones[i];
            if (col == columna || Math.abs(i - fila) == Math.abs(col - columna)) {
                return false;
            }
        }
        return true;
    }

    private void generarMovimientos() {
        Figura reina;
        for (int fila = 0; fila < dimension; fila++) {
            reina = new Reina("Reina" + fila);
            int columna = posiciones[fila];
            movimientos.add(new Nodo(-1, -1, fila, columna, reina));
        }
    }

    public List<Nodo> getMovimientos() {
        return movimientos;
    }
}

