/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Grafo;
import EDD.ListaSimple;
import EDD.MyStack;
import EDD.Vertice;
import java.util.HashSet;
import java.util.Set;

/**
 * * @author eliocolmenares
 */
public class BusquedaDFS {
     private Grafo grafo;
    private Set<Vertice> visitados;

    public BusquedaDFS(Grafo grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }

    public boolean buscar(String palabra) {
        if (palabra.length() < 3) {
            return false;
        }
        char primeraLetra = palabra.charAt(0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grafo.getNodo(i, j).getLetra() == primeraLetra) {
                    if (dfsIterativo(grafo.getNodo(i, j), palabra)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfsIterativo(Vertice nodo, String palabra) {
        MyStack pila = new MyStack();
        MyStack indices = new MyStack();
        pila.apilar(nodo);
        indices.apilar(0);
        int indice = 0;

        while (!pila.isEmpty()) {
            Vertice actual = (Vertice) pila.desapilar();
            int indiceActual = (int) indices.desapilar();

            if (indiceActual == palabra.length()) {
                return true;
            }

            if (actual == null || actual.getLetra() != palabra.charAt(indiceActual)) {
                if (!pila.isEmpty() && !indices.isEmpty()) {
                    indices.apilar((int) indices.desapilar() + 1);
                }
                continue;
            }

            visitados.add(actual);

            boolean adyacenteEncontrado = false;
            ListaSimple adyacentes = grafo.obtenerAdyacentes(actual);
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Vertice adyacente = (Vertice) adyacentes.getValor(i);
                if (!visitados.contains(adyacente)) {
                    pila.apilar(adyacente);
                    indices.apilar(indiceActual + 1);
                    adyacenteEncontrado = true;
                    break;
                }
            }

            if (!adyacenteEncontrado) {
                visitados.remove(actual);
                if (!indices.isEmpty()) {
                    indices.apilar((int) indices.desapilar() + 1);
                }
            }
        }
        return false;
    }
}
