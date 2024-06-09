/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * * @author eliocolmenares, luisfdasilva
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
    public void mostrarTableroGraphStream() {

        GrafoGraphStream grafo = new GrafoGraphStream();


        for (int i = 0; i < TAMANIO; i++) {

            for (int j = 0; j < TAMANIO; j++) {

                Vertice nodo = tablero[i][j];

                grafo.addNode(String.valueOf(nodo.getLetra()), String.valueOf(nodo.getLetra()));


                ListaSimple adyacentes = obtenerAdyacentes(nodo);

                for (int k = 0; k < adyacentes.getSize(); k++) {

                    Object objeto = adyacentes.getValor(k);

                    Vertice adyacente = (Vertice) objeto;

                    grafo.addEdge(String.valueOf(nodo.getLetra()) + "-" + String.valueOf(adyacente.getLetra()), String.valueOf(nodo.getLetra()), String.valueOf(adyacente.getLetra()));

                }

            }

        }


        grafo.mostrarGrafo();

    }
//    public void mostrarGrafo() {
//            Graph graph = new SingleGraph("Grafo");
//
//            // Añadir nodos al grafo
//            for (int i = 0; i < TAMANIO; i++) {
//                for (int j = 0; j < TAMANIO; j++) {
//                    Vertice vertice = tablero[i][j];
//                    Node node = graph.addNode(vertice.toString());
//                    node.setAttribute("ui.label", vertice.getLetra());
//                }
//            }
//
//            // Añadir aristas al grafo
//            for (int i = 0; i < TAMANIO * TAMANIO; i++) {
//                for (int j = i + 1; j < TAMANIO * TAMANIO; j++) {
//                    if (adyacencia[i][j]) {
//                        Vertice v1 = tablero[i / TAMANIO][i % TAMANIO];
//                        Vertice v2 = tablero[j / TAMANIO][j % TAMANIO];
//                        graph.addEdge(v1.toString() + "-" + v2.toString(), v1.toString(), v2.toString());
//                    }
//                }
//            }
//
//            // Configuración visual del grafo
//            graph.setAttribute("ui.stylesheet", "node { fill-color: red; } node.marked { fill-color: green; }");
//            graph.display();
//        }

}
