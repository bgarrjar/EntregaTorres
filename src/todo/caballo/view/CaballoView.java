package todo.caballo.view;

import todo.modelo.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CaballoView extends JFrame {
    private int dimension;
    private List<Nodo> movimientos;
    private int pasoActual = 0;

    public CaballoView(List<Nodo> movimientos, int dimension) {
        this.dimension = dimension;
        this.movimientos = movimientos;

        setTitle("Recorrido del Caballo");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new TableroPanel());
        setVisible(true);

        new Thread(this::animarMovimientos).start();
    }

    private void animarMovimientos() {
        for (int i = 0; i < movimientos.size(); i++) {
            pasoActual = i + 1;
            repaint();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class TableroPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int anchoCelda = getWidth() / dimension;
            int altoCelda = getHeight() / dimension;

            // Dibujar líneas del tablero
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i <= dimension; i++) {
                g.drawLine(i * anchoCelda, 0, i * anchoCelda, getHeight());
                g.drawLine(0, i * altoCelda, getWidth(), i * altoCelda);
            }

            // Dibujar líneas del recorrido
            g.setColor(Color.BLUE);
            for (int i = 0; i < pasoActual - 1; i++) {
                Nodo n1 = movimientos.get(i);
                Nodo n2 = movimientos.get(i + 1);
                int x1 = n1.getXFinal() * anchoCelda + anchoCelda / 2;
                int y1 = n1.getYFinal() * altoCelda + altoCelda / 2;
                int x2 = n2.getXFinal() * anchoCelda + anchoCelda / 2;
                int y2 = n2.getYFinal() * altoCelda + altoCelda / 2;
                g.drawLine(x1, y1, x2, y2);
            }

            // Dibujar el emoji del caballo
            if (pasoActual > 0 && pasoActual <= movimientos.size()) {
                Nodo actual = movimientos.get(pasoActual - 1);
                int x = actual.getXFinal();
                int y = actual.getYFinal();
                g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, Math.min(anchoCelda, altoCelda) - 4));
                g.drawString("🐴", x * anchoCelda + anchoCelda / 4, y * altoCelda + 3 * altoCelda / 4);
            }
        }
    }
}


