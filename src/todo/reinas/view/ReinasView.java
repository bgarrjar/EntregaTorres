package todo.reinas.view;

import todo.modelo.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReinasView extends JFrame {
    private int dimension;
    private List<Nodo> movimientos;

    public ReinasView(List<Nodo> movimientos, int dimension) {
        this.dimension = dimension;
        this.movimientos = movimientos;

        setTitle("Solución de las Reinas");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new TableroPanel());
        setVisible(true);
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

            // Dibujar las reinas centradas con emoji 👑
            Font font = new Font("Segoe UI Emoji", Font.PLAIN, Math.min(anchoCelda, altoCelda) - 4);
            g.setFont(font);
            FontMetrics metrics = g.getFontMetrics(font);
            String reina = "👑";

            for (Nodo nodo : movimientos) {
                int x = nodo.getXFinal();
                int y = nodo.getYFinal();

                int textWidth = metrics.stringWidth(reina);
                int textHeight = metrics.getAscent();

                int posX = y * anchoCelda + (anchoCelda - textWidth) / 2;
                int posY = x * altoCelda + (altoCelda + textHeight) / 2;

                g.drawString(reina, posX, posY);
            }
        }
    }
}
