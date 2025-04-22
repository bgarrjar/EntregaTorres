package todo.caballo.controller;

import todo.caballo.view.CaballoView;

import todo.caballo.model.TableroCaballo;

import javax.swing.JOptionPane; //Se usa para ver ventanas de mensajes

public class CaballoController {

    public void execute(int dimension) {
        //Método usado cuando se elige el juego del caballo
        TableroCaballo tablero = new TableroCaballo(dimension); //Crea el tablero del caballo con la dimensión elegida
        int movimientos = tablero.resolver(); //Llama al método resolver del tablero, que intenta encontrar una solución al recorrido del caballo

        if (movimientos != -1) {
            JOptionPane.showMessageDialog(null, "El caballo ha completado el recorrido en " + movimientos + " movimientos.");
            new CaballoView(tablero.getMovimientos(), dimension);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar una solución completa para el caballo.");
        }
        /*Si hay solución, se muestra un mensaje con el número de movimientos y se llama a la vista
        del caballo. Si no hay solución, muestra mensaje de error.
         */
    }
}


