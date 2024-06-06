/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author eliocolmenares
 */
public class Grafo {
    private Vertice[][] tablero;
    private boolean[][] adyacencia;
    private final int TAMANIO = 4;

    public Grafo(char[][] letras) {
        tablero = new Vertice[TAMANIO][TAMANIO];
        adyacencia = new boolean[TAMANIO * TAMANIO][TAMANIO * TAMANIO];
        inicializarTablero(letras);
        inicializarAdyacencias();
    }

    private void inicializarTablero(char[][] letras) {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = new Vertice(letras[i][j], i, j);
            }
        }
    }

    private void inicializarAdyacencias() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                conectarAdyacencias(i, j);
            }
        }
    }

    private void conectarAdyacencias(int fila, int columna) {
        int[][] direcciones = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int indiceActual = fila * TAMANIO + columna;
        for (int[] dir : direcciones) {
            int nuevaFila = fila + dir[0];
            int nuevaColumna = columna + dir[1];
            if (esValido(nuevaFila, nuevaColumna)) {
                int indiceAdyacente = nuevaFila * TAMANIO + nuevaColumna;
                adyacencia[indiceActual][indiceAdyacente] = true;
                adyacencia[indiceAdyacente][indiceActual] = true;
            }
        }
    }

    private boolean esValido(int fila, int columna) {
        return fila >= 0 && fila < TAMANIO && columna >= 0 && columna < TAMANIO;
    }

    public ListaSimple obtenerAdyacentes(Vertice nodo) {
        ListaSimple adyacentes = new ListaSimple();
        int indiceNodo = nodo.getFila() * TAMANIO + nodo.getColumna();
        for (int i = 0; i < TAMANIO * TAMANIO; i++) {
            if (adyacencia[indiceNodo][i]) {
                int fila = i / TAMANIO;
                int columna = i % TAMANIO;
                adyacentes.InsertarFinal(tablero[fila][columna]);
            }
        }
        return adyacentes;
    }

    public Vertice getNodo(int fila, int columna) {
        if (esValido(fila, columna)) {
            return tablero[fila][columna];
        }
        return null;
    }

    public void mostrarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(tablero[i][j].getLetra() + " ");
            }
            System.out.println();
        }

    }
}
