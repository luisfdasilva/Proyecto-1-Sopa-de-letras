/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.Grafo;
import Functions.BusquedaBFS;
import Functions.BusquedaDFS;

/**
 * * @author eliocolmenares
 */
public class SopaDeLetras {
    private Grafo grafo;
    private Diccionario diccionario;
    private BusquedaDFS busquedaDFS;
    private BusquedaBFS busquedaBFS;

    public SopaDeLetras(char[][] letras, Diccionario diccionario) {
        this.grafo = new Grafo(letras);
        this.diccionario = diccionario;
        this.busquedaDFS = new BusquedaDFS(grafo);
        this.busquedaBFS = new BusquedaBFS(grafo);
    }

    public SopaDeLetras() {
        this.grafo = null;
        this.diccionario = null;
        this.busquedaDFS = null;
        this.busquedaBFS = null;
    }
    
        public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public Diccionario getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Diccionario diccionario) {
        this.diccionario = diccionario;
    }

    public void inicializar(char[][] letras, Diccionario diccionario) {
        this.grafo = new Grafo(letras);
        this.diccionario = diccionario;
        this.busquedaDFS = new BusquedaDFS(grafo);
        this.busquedaBFS = new BusquedaBFS(grafo);
    }

    public String buscarPalabras(String metodo) {
        if (grafo == null || diccionario == null) {
            //System.err.println("Grafo o Diccionario no inicializado");
            return null;
        }

        long inicio = System.currentTimeMillis();
        
        String palabrasEncontradas = "";
        String palabrasNoEncontradas = "";

        for (int i = 0; i < diccionario.getPalabras().getSize(); i++) {
            String palabra = (String) diccionario.getPalabras().getValor(i);
            if (palabra.length() < 3) {
                continue;
            }
            boolean encontrada;
            if (metodo.equalsIgnoreCase("DFS")) {
                encontrada = busquedaDFS.buscar(palabra);
            } else {
                encontrada = busquedaBFS.buscar(palabra);
            }
            if (encontrada) {
                palabrasEncontradas += "Palabra encontrada: " + palabra + "\n";
            } else {
                palabrasNoEncontradas += "Palabra no encontrada: " + palabra + "\n";
            }
        }
        long fin = System.currentTimeMillis();
        
        String resultado = palabrasEncontradas + palabrasNoEncontradas + "Tiempo total: " + (fin - inicio) + " ms";
        return resultado;
    }
    
    public String buscarPalabra(String palabra){
         if (grafo == null) {
            //System.err.println("Grafo o Diccionario no inicializado");
            return null;
        }

        String expresion = "";
        long inicio = System.currentTimeMillis();
        
        boolean encontrada;
        encontrada = busquedaBFS.buscar(palabra);
            if (encontrada) {
                expresion += "Palabra encontrada: " + palabra + "\n";
            } else {
                expresion += "Palabra no encontrada: " + palabra + "\n";
            }
        long fin = System.currentTimeMillis();
        
        String resultado = expresion + "Tiempo total: " + (fin - inicio) + " ms";
        return resultado;
    }
}


