package Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Minas {

    Buscaminas[][] casillas;

    int numerofilas;
    int numerocolumnas;
    int numerominas;
    boolean ganado;
    int casillasAbiertas;
    private Consumer<List<Buscaminas>> perdido;
    private Consumer<List<Buscaminas>> ganada;
    private Consumer<Buscaminas> casillaseabre;

    public Minas(int numerofilas, int numerocolumnas, int numerominas) {
        this.numerofilas = numerofilas;
        this.numerocolumnas = numerocolumnas;
        this.numerominas = numerominas;
        this.generarcasilla();
    }

    public void generarcasilla() {
        casillas = new Buscaminas[this.numerofilas][this.numerocolumnas];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Buscaminas(i, j);
            }
        }
        generarminas();
    }

    public void generarminas() {
        int minas = 0;
        while (minas != numerominas) {
            int posicionfila = (int) (Math.random() * casillas.length);
            int posicioncolumna = (int) (Math.random() * casillas[0].length);
            if (!casillas[posicionfila][posicioncolumna].isMina()) {
                casillas[posicionfila][posicioncolumna].setMina(true);
                minas++;
            }
        }
        minasalrededor();
    }

    public void minasalrededor() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()) {
                    List<Buscaminas> alrededorcasillas = listadominas(i, j);
                    alrededorcasillas.forEach((c) -> c.incrementarminas());
                }
            }
        }
    }

    private List<Buscaminas> listadominas(int posfila, int poscolumna) {
        List<Buscaminas> listado = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            int pfila = posfila;
            int pcolumna = poscolumna;
            switch (i) {
                case 0 ->
                    pfila--; //Cuando existe mina en la parte de arriba
                case 1 -> {
                    pfila--;
                    pcolumna++; //Cuando existe mina en la parte de arriba derecha
                }
                case 2 ->
                    pcolumna++; //Cuando existe mina en la parte de la derecha
                case 3 -> {
                    pcolumna++;
                    pfila++; //Cuando existe mina en la parte de la derecha abajo
                }
                case 4 ->
                    pfila++; //Cuando existe mina en la parte de abajo
                case 5 -> {
                    pfila++;
                    pcolumna--; //Cuando existe mina en la parte de abajo izquierda
                }
                case 6 ->
                    pcolumna--; //Cuando existe mina en la parte de la izquierda
                case 7 -> {
                    pfila--;  //Cuando existe mina en la parte de izquierda arriba
                    pcolumna--;
                }
            }
            if (pfila >= 0 && pfila < this.casillas.length && pcolumna >= 0 && pcolumna < this.casillas[0].length) {
                listado.add(this.casillas[pfila][pcolumna]);
            }
        }

        return listado;
    }
    List <Buscaminas>CasillasConMinas(){
         List<Buscaminas> posiciondeminas = new LinkedList<>();
            for (int i =0;i<casillas.length;i++){
                for (int j=0;j<casillas[i].length;j++){
                    if (casillas[i][j].isMina()){
                        posiciondeminas.add(casillas[i][j]);
                    }
                }
            }
            return posiciondeminas;
    }

    public void Seleccioncasillas(int fila, int columna) {
        casillaseabre.accept(this.casillas[fila][columna]);
        if (this.casillas[fila][columna].isMina()) {
            
            perdido.accept(CasillasConMinas());
        } else if (this.casillas[fila][columna].getMinascerca() == 0) {
            marcarcasillas(fila, columna);
            List<Buscaminas> alrededorcasillas = listadominas(fila, columna);
            for (Buscaminas Buscaminas : alrededorcasillas) {
                if (!Buscaminas.isAbierto()) {
                    
                    Seleccioncasillas(Buscaminas.getFila(), Buscaminas.getColumna());
                }
            }
        } else {
            marcarcasillas(fila, columna);
        }
        if (partidaTerminada()) {
            ganada.accept(CasillasConMinas());

        }
    }

    void marcarcasillas(int PFILA, int PCOLUMNA) {
        if (!this.casillas[PFILA][PCOLUMNA].isAbierto()) {
            casillasAbiertas++;
            this.casillas[PFILA][PCOLUMNA].setAbierto(true);
        }
    }

    boolean partidaTerminada() {
        return casillasAbiertas >= (numerofilas * numerocolumnas) - numerominas;

    }

    public void setPerdido(Consumer<List<Buscaminas>> perdido) {
        this.perdido = perdido;
    }

    public Consumer<Buscaminas> getCasillaseabre() {
        return casillaseabre;
    }

    public void setCasillaseabre(Consumer<Buscaminas> casillaseabre) {
        this.casillaseabre = casillaseabre;
    }

    public void setGanada(Consumer<List<Buscaminas>> ganada) {
        this.ganada = ganada;
    }
}
