//Crea la ventana donde se escribe el tamaño del tablero y al pulsar el botón iniciar se inicia el juego
package todo.caballo.view;

import todo.caballo.controller.CaballoController;

import javax.swing.*;
import java.awt.*; //Para ciertas componentes visuales

public class CaballoSetupView extends JFrame {
    private JTextField inputDimension; //Caja de texto para introducir la dimensión del tablero
    private JButton botonIniciar; //Botón para iniciar el juego

    public CaballoSetupView() { //Constructor de la ventana
        setTitle("Configurar Tablero del Caballo");
        setLayout(new GridLayout(3, 1, 10, 10));

        inputDimension = new JTextField("8");
        botonIniciar = new JButton("Iniciar");

        add(new JLabel("Introduce la dimensión del tablero (ej: 8):", SwingConstants.CENTER));
        add(inputDimension);
        add(botonIniciar);

        botonIniciar.addActionListener(e -> { //Acción al pulsar el botón
            try {
                int dimension = Integer.parseInt(inputDimension.getText()); //Convierte el texto a número
                if (dimension < 1 || dimension > 20) {
                    JOptionPane.showMessageDialog(this, "Introduce un número entre 1 y 20.");
                    return;
                }
                dispose(); // Cierra esta ventana
                new CaballoController().execute(dimension); // Lanza el juego llamando al controlador
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce un número válido.");
            }
        });

        setSize(300, 150); //Tamaño de la ventana en pixeles
        setLocationRelativeTo(null); //Centra la ventana en la pantalla
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Si se cierra esta ventana no se cierra todo el programa
        setVisible(true); //Muestra la ventana
    }
}

