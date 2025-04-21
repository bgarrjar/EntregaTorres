package todo.unificado.controller;

import todo.unificado.view.MainFrame;
import todo.disco.controller.HanoiController;
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
                new HanoiController().execute();
                break;
            case "caballo":
                new CaballoController().execute();
                break;
            case "reinas":
                new ReinasController().execute();
                break;
            default:
                System.out.println("Juego no reconocido");
        }
    }
}
