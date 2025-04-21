package todo.disco.model;

import todo.modelo.Figura;
import todo.modelo.Nodo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TableroDiscos {
    private int numDiscos;
    private List<Nodo> movimientos;
    private Stack<Figura>[] torres;

    public TableroDiscos(int numDiscos) {
        this.numDiscos = numDiscos;
        this.movimientos = new ArrayList<>();
        this.torres = new Stack[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }

        // Crear discos y colocarlos en la primera torre con colores diferentes
        String[] colores = {"orange", "cyan", "green", "pink", "blue", "magenta", "red", "gray"};
        for (int i = numDiscos; i >= 1; i--) {
            String color = colores[(i - 1) % colores.length];
            torres[0].push(new Disco("Disco" + i, i, color));
        }
    }

    public int resolver() {
        hanoi(numDiscos, 0, 2, 1); // De torre 0 a torre 2 usando la 1 como auxiliar
        return movimientos.size();
    }

    private void hanoi(int n, int origen, int destino, int auxiliar) {
        if (n == 1) {
            moverDisco(origen, destino);
        } else {
            hanoi(n - 1, origen, auxiliar, destino);
            moverDisco(origen, destino);
            hanoi(n - 1, auxiliar, destino, origen);
        }
    }

    private void moverDisco(int origen, int destino) {
        if (!torres[origen].isEmpty()) {
            Figura disco = torres[origen].pop();
            torres[destino].push(disco);
            movimientos.add(new Nodo(origen, 0, destino, 0, disco));
        }
    }

    public List<Nodo> getMovimientos() {
        return movimientos;
    }

    public Stack<Figura>[] getEstadoTorres() {
        return torres;
    }
}
