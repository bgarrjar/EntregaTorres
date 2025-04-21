package todo.reinas.model;

import todo.modelo.Figura;
import todo.modelo.Nodo;
import todo.reinas.model.Reina;

import java.util.ArrayList;
import java.util.List;

public class TableroReinas {
    private int dimension;
    private int[] posiciones; // posiciones[fila] = columna donde está la reina
    private List<Nodo> movimientos;

    public TableroReinas(int dimension) {
        this.dimension = dimension;
        this.posiciones = new int[dimension];
        this.movimientos = new ArrayList<>();
    }

    public boolean resolver() {
        return colocarReina(0);
    }

    private boolean colocarReina(int fila) {
        if (fila == dimension) {
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

