package todo.disco.view;

import todo.disco.controller.DiscoController;

import javax.swing.*;
import java.awt.*;

public class DiscoSetupView extends JFrame {
    private JTextField inputDiscos;
    private JButton botonIniciar;

    public DiscoSetupView() {
        setTitle("Configurar Torres de Hanoi");
        setLayout(new GridLayout(3, 1, 10, 10));

        inputDiscos = new JTextField("3");
        botonIniciar = new JButton("Iniciar");

        add(new JLabel("Introduce el número de discos (ej: 3):", SwingConstants.CENTER));
        add(inputDiscos);
        add(botonIniciar);

        botonIniciar.addActionListener(e -> {
            try {
                int discos = Integer.parseInt(inputDiscos.getText());
                if (discos < 1 || discos > 10) {
                    JOptionPane.showMessageDialog(this, "Introduce un número entre 1 y 10.");
                    return;
                }
                dispose();
                new DiscoController().execute(discos);
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

