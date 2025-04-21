package todo.disco.controller;

import todo.disco.model.TableroDiscos;
import todo.disco.view.DiscoView;

import javax.swing.*;

public class DiscoController {

    public void execute(int discos) {
        TableroDiscos tablero = new TableroDiscos(discos);
        tablero.resolver();

        JOptionPane.showMessageDialog(null, "Las torres han sido resueltas en " + tablero.getMovimientos().size() + " movimientos.");
        new DiscoView(tablero.getMovimientos(), discos);
    }
}

