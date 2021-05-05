package Principal;


public class Buscaminas {
    private int fila;
    private int columna;
    private boolean mina;
    private int minascerca;
    private boolean abierto;
    public Buscaminas(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getMinascerca() {
        return minascerca;
    }

    public void setMinascerca(int minascerca) {
        this.minascerca = minascerca;
    }
    public void incrementarminas(){
        this.minascerca++;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
    
}
