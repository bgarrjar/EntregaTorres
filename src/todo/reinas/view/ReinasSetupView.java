package todo.reinas.view;

import todo.reinas.controller.ReinasController;

import javax.swing.*;
import java.awt.*;

public class ReinasSetupView extends JFrame {
    private JTextField inputDimension;
    private JButton botonIniciar;

    public ReinasSetupView() {
        setTitle("Configurar Tablero de las Reinas");
        setLayout(new GridLayout(3, 1, 10, 10));

        inputDimension = new JTextField("8");
        botonIniciar = new JButton("Iniciar");

        add(new JLabel("Introduce la dimensión del tablero (ej: 8):", SwingConstants.CENTER));
        add(inputDimension);
        add(botonIniciar);

        botonIniciar.addActionListener(e -> {
            try {
                int dimension = Integer.parseInt(inputDimension.getText());
                if (dimension < 1 || dimension > 20) {
                    JOptionPane.showMessageDialog(this, "Introduce un número entre 1 y 20.");
                    return;
                }
                dispose();
                new ReinasController().execute(dimension);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce un número válido.");
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
