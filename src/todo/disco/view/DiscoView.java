package todo.disco.view;

import todo.modelo.Nodo;
import todo.disco.model.Disco;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Stack;

public class DiscoView extends JFrame {
    private int numDiscos;
    private List<Nodo> movimientos;
    private Stack<Disco>[] torres;
    private int pasoActual = 0;

    public DiscoView(List<Nodo> movimientos, int numDiscos) {
        this.numDiscos = numDiscos;
        this.movimientos = movimientos;
        this.torres = new Stack[3];

        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }

        setTitle("Torres de Hanoi");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new TableroPanel());
        setVisible(true);

        new Thread(this::animarMovimientos).start();
    }

    private void animarMovimientos() {
        for (Nodo nodo : movimientos) {
            Disco disco = (Disco) nodo.getFigura();
            int origen = nodo.getXInicial();
            int destino = nodo.getXFinal();

            if (!torres[origen].isEmpty()) {
                torres[origen].pop();
            }
            torres[destino].push(disco);

            pasoActual++;
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class TableroPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int anchoTorre = getWidth() / 4;
            int baseY = getHeight() - 50;
            int torreAncho = 10;
            int discoAltura = 20;

            // Dibujar las torres (más largas)
            g2.setColor(Color.DARK_GRAY);
            for (int i = 0; i < 3; i++) {
                int x = anchoTorre * (i + 1);
                g2.fillRect(x, baseY - numDiscos * discoAltura - 30, torreAncho, numDiscos * discoAltura + 30);
            }

            // Dibujar discos en cada torre
            for (int i = 0; i < 3; i++) {
                Stack<Disco> torre = torres[i];
                int xCentro = anchoTorre * (i + 1);
                int altura = 0;

                for (int j = 0; j < torre.size(); j++) {
                    Disco disco = torre.get(j);
                    int anchoDisco = disco.getAncho() * 10 + 20;
                    int y = baseY - (++altura) * discoAltura;

                    g2.setColor(getColorPorAncho(disco.getAncho()));
                    g2.fillRoundRect(xCentro - anchoDisco / 2, y, anchoDisco, discoAltura, 10, 10);
                }

            }
        }

        private Color getColorPorAncho(int ancho) {
            return switch (ancho) {
                case 1 -> new Color(255, 204, 102); // naranja claro
                case 2 -> new Color(102, 204, 255); // azul claro
                case 3 -> new Color(153, 255, 153); // verde claro
                case 4 -> new Color(255, 153, 204); // rosa
                case 5 -> new Color(204, 153, 255); // lila
                default -> Color.LIGHT_GRAY;
            };
        }
    }
}




