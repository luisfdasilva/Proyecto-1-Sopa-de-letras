/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Grafo;
import EDD.ListaSimple;
import EDD.MyQueue;
import EDD.Vertice;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author eliocolmenares
 */
public class BusquedaBFS {
   private Grafo grafo;

    public BusquedaBFS(Grafo grafo) {
        this.grafo = grafo;
    }

    public boolean buscar(String palabra) {
        if (palabra.length() < 3) {
            return false;
        }
        char primeraLetra = palabra.charAt(0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grafo.getNodo(i, j).getLetra() == primeraLetra) {
                    if (bfs(grafo.getNodo(i, j), palabra)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(Vertice nodo, String palabra) {
        MyQueue cola = new MyQueue();
        Set<Vertice> visitados = new HashSet<>();
        cola.encolar(nodo);
        int indice = 0;

        while (!cola.isEmpty()) {
            Vertice actual = (Vertice) cola.desencolar();
            if (actual.getLetra() == palabra.charAt(indice)) {
                indice++;
                if (indice == palabra.length()) {
                    return true;
                }
                visitados.add(actual);
                ListaSimple adyacentes = grafo.obtenerAdyacentes(actual);
                for (int i = 0; i < adyacentes.getSize(); i++) {
                    Vertice adyacente = (Vertice) adyacentes.getValor(i);
                    if (!visitados.contains(adyacente)) {
                        cola.encolar(adyacente);
                    }
                }
            }
        }
        return false;
    } 
}
