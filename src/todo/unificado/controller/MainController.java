package todo.unificado.controller;

import todo.reinas.view.ReinasSetupView;
import todo.unificado.view.MainFrame;
import todo.disco.view.DiscoSetupView;
import todo.caballo.controller.CaballoController;
import todo.reinas.controller.ReinasController;

public class MainController {
    private MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
    }

    public void selectGame(String game) {
        switch (game) {
            case "hanoi":
                new DiscoSetupView();
                break;
            case "caballo":
                new todo.caballo.view.CaballoSetupView();
                break;
            case "reinas":
                new ReinasSetupView();
                break;
            default:
                System.out.println("Juego no reconocido");
        }
    }
}
