package todo.modelo;

public class Nodo {
    private int xInicial;
    private int yInicial;
    private int xFinal;
    private int yFinal;
    private Figura figura;

    public Nodo(int xInicial, int yInicial, int xFinal, int yFinal, Figura figura) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.xFinal = xFinal;
        this.yFinal = yFinal;
        this.figura = figura;
    }

    public int getXInicial() {
        return xInicial;
    }

    public int getYInicial() {
        return yInicial;
    }

    public int getXFinal() {
        return xFinal;
    }

    public int getYFinal() {
        return yFinal;
    }

    public Figura getFigura() {
        return figura;
    }
}
