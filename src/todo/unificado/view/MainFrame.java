package todo.unificado.view;

import todo.unificado.controller.MainController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MainFrame extends JFrame {
    private MainController controller;

    public MainFrame() {
        super("Elige un juego");
        // Inicializa el controlador
        controller = new MainController(this);
        // Configura la interfaz
        initUI();
        // Cierre de la ventana al pulsar la 'X'
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Ajusta el tamaño al contenido
        pack();
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        // Hacerla visible
        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton btnHanoi = new JButton("Torres de Hanoi");
        JButton btnCaballo = new JButton("Problema del Caballo");
        JButton btnReinas = new JButton("8 Reinas");

        // Asignar acciones a los botones
        btnHanoi.addActionListener(e -> controller.selectGame("hanoi"));
        btnCaballo.addActionListener(e -> controller.selectGame("caballo"));
        btnReinas.addActionListener(e -> controller.selectGame("reinas"));

        // Añadir botones al panel
        panel.add(btnHanoi);
        panel.add(btnCaballo);
        panel.add(btnReinas);
        // Añadir panel al frame
        add(panel);
    }
}

