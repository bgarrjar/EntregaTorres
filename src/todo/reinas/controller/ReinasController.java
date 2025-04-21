package todo.reinas.controller;

import todo.reinas.model.TableroReinas;
import todo.reinas.view.ReinasView;

import javax.swing.*;

public class ReinasController {

    public void execute(int dimension) {
        TableroReinas tablero = new TableroReinas(dimension);
        boolean exito = tablero.resolver();

        if (exito) {
            JOptionPane.showMessageDialog(null, "Las reinas han sido colocadas correctamente.");
            new ReinasView(tablero.getMovimientos(), dimension);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar una solución para este tamaño de tablero.");
        }
    }
}

