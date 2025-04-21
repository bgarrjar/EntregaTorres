package todo.caballo.controller;

import todo.caballo.view.CaballoView;

import todo.caballo.model.TableroCaballo;

import javax.swing.JOptionPane;

public class CaballoController {

    public void execute(int dimension) {
        TableroCaballo tablero = new TableroCaballo(dimension);
        int movimientos = tablero.resolver();

        if (movimientos != -1) {
            JOptionPane.showMessageDialog(null, "El caballo ha completado el recorrido en " + movimientos + " movimientos.");
            new CaballoView(tablero.getMovimientos(), dimension);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar una solución completa para el caballo.");
        }
    }
}


