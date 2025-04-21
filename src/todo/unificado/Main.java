package todo.unificado;

import javax.swing.SwingUtilities;
import todo.unificado.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());  //Arranca swing y llama a la ventana principal
    }
}


//MainFrame.java es la clase que construye la ventana principal de la aplicación.