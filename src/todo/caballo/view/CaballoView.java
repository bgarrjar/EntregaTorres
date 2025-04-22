//Crea una ventana que muestra el recorrido del caballo en un tablero de ajedrez
package todo.caballo.view;

import todo.modelo.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.List; //Para manejar la lista de movimientos

public class CaballoView extends JFrame { //Ventana que muestra el recorrido del caballo
    private int dimension;
    private List<Nodo> movimientos;
    private int pasoActual = 0;

    public CaballoView(List<Nodo> movimientos, int dimension) {
        //Constructor que recibe la lista de movimientos y la dimensión del tablero
        this.dimension = dimension; //Guarda los datos
        this.movimientos = movimientos;

        setTitle("Recorrido del Caballo");
        setSize(600, 600); //Tamaño de la ventana en píxeles
        setLocationRelativeTo(null); //Centra la ventana en la pantalla
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cierra la ventana al salir, no la aplicación
        setContentPane(new TableroPanel()); //Crea un panel para dibujar el tablero
        setVisible(true); //Muestra la ventana

        new Thread(this::animarMovimientos).start();
        //Inicia un hilo para animar los movimientos del caballo
    }

    private void animarMovimientos() {
        for (int i = 0; i < movimientos.size(); i++) { //Recorre la lista de movimientos
            pasoActual = i + 1; //Aumenta el paso actual
            repaint(); //Pinta el panel para mostrar el movimiento
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Pausa de 300ms entre cada movimiento para ver la animación
        }
    }

    private class TableroPanel extends JPanel {
        //Clase donde se dibuja el tablero
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //Limpia la pantalla
            int anchoCelda = getWidth() / dimension; //Calcula las dimensiones de cada celda
            int altoCelda = getHeight() / dimension;
            /*Este método se ejecuta cuando se llama a repaint()*/

            // Dibuja líneas del tablero
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i <= dimension; i++) {
                g.drawLine(i * anchoCelda, 0, i * anchoCelda, getHeight());
                g.drawLine(0, i * altoCelda, getWidth(), i * altoCelda);
            }

            // Dibuja líneas del recorrido
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

            // Dibuja el emoji del caballo
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


