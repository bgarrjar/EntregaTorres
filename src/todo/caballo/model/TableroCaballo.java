//En esta clase se calcula el recorrido que debe seguir el caballo en el tablero.

package todo.caballo.model;

import todo.modelo.Nodo;
import java.util.ArrayList;
import java.util.List;

public class TableroCaballo {
    private int N; // tamaño del tablero NxN (atributo)
    private int[][] tablero; // matriz que representa el tablero ej 8x8
    private int[] movX = {2, 1, -1, -2, -2, -1, 1, 2}; //Representación de los movimientos del caballo posibles
    private int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};
    private List<Nodo> movimientos; // lista de movimientos realizados por el caballo

    public TableroCaballo(int dimension) { // constructor que recibe el tamaño del tablero
        this.N = dimension;
        tablero = new int[N][N]; //Crea el tablero vacio
        movimientos = new ArrayList<>(); //Inicializa la lista de movimientos para guardar los nodos de movimientos
    }

    public int resolver() { // método para resolver el problema
        Caballo caballo = new Caballo("Caballo1"); //Crea un caballo
        tablero[0][0] = 1; // marca la posición inicial del caballo con un 1
        if (moverCaballo(0, 0, 2, caballo)) { //"Desde (0,0), intenta buscar el paso 2 en las posibles casillas para que el caballo pueda saltar"
            return movimientos.size(); //Si encuentra una solución devuelve la cantidad de movimientos
        } else {
            return -1; // si no encuentra solución devuelve -1
        }
    }

    private boolean moverCaballo(int x, int y, int paso, Caballo caballo) {
        if (paso > N * N) return true; // Si el caballo ha recorrido todas las casillas, se ha completado el tablero.

        for (int i = 0; i < 8; i++) { //Recorre los movimientos posibles del caballo
            int siguienteX = x + movX[i];
            int siguienteY = y + movY[i];

            if (esValido(siguienteX, siguienteY)) { //Si el movimiento es válido, lo marca en el tablero y lo guarda en la lista de movimientos.
                tablero[siguienteX][siguienteY] = paso;
                movimientos.add(new Nodo(x, y, siguienteX, siguienteY, caballo));

                if (moverCaballo(siguienteX, siguienteY, paso + 1, caballo)) { //Intenta ir a una nueva casilla
                    return true;
                } else { //si no puede, borra el movimiento
                    tablero[siguienteX][siguienteY] = 0;
                    movimientos.remove(movimientos.size() - 1);
                }
            }
        }
        return false;
    }

    private boolean esValido(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && tablero[x][y] == 0;
        /*Verifica que la casilla no se ha visitado antes ya que las visitadas son distintas de 0 y
        que no se sale del tablero*/
    }

    public List<Nodo> getMovimientos() { //Para que otras clases puedan acceder a la lista de movimientos hechos (ej: vista)
        return movimientos;
    }
}
