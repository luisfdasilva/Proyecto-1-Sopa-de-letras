/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Grafo;
import EDD.ListaSimple;
import EDD.Nodo;
import EDD.Vertice;


/**
 *
 * @author eliocolmenares
 */
public class FunctionTxt {

    public void Guardar_Dic(ListaSimple lista_palabras, String[] arreglo) {
        String dic = arreglo[0];
        
        String dic_n = dic.replace("\r", "");
        
        String[] palabras = dic_n.split("\n");
        
        for (int i = 1; i < palabras.length; i++) {
            
            lista_palabras.InsertarFinal(palabras[i]);
        }
        
    }

    public void Guardarletra_lista(ListaSimple lista1, ListaSimple lista2, ListaSimple lista3, ListaSimple lista4, String[] arreglo, Grafo grafo) {
        String tab = arreglo[1];
        String tab_b = tab.replace("\r", "");
        String[] tab_n = tab_b.split("\n");
        String letras_n = tab_n[2];
        String[] arr_letras = letras_n.split(",");

        for (int i = 0; i < arr_letras.length; i++) {
            if (i >= 0 && i < 4) {
                lista1.InsertarFinal(arr_letras[i]);
            } else if (i >= 4 && i < 8) {
                lista2.InsertarFinal(arr_letras[i]);
            } else if (i >= 8 && i < 12) {
                lista3.InsertarFinal(arr_letras[i]);
            } else {
                lista4.InsertarFinal(arr_letras[i]);
            }
        }
        
        for (int i = 0; i < arr_letras.length; i++) {
            Vertice vertice = new Vertice(arr_letras[i]);
            grafo.nuevoVertice(vertice);
        }
        
        
        //System.out.println(grafo.vertice(0).getLetra());
        
    }
    //Busca dos vertices y crea arista horizontal
    public void CrearArista_Hztl(ListaSimple lista, Grafo tablero){
        for(int i = 0; i<4 ; i++) {
            String letra1=(String)lista.getValor(i);
            String letra2=(String)lista.getValor(i+1); 
            Vertice v1=new Vertice(letra1);
            Vertice v2=new Vertice(letra2);
            tablero.nuevoArco(v1, v2, 1);
            
        }
    }
    //Busca dos vertices y crea arista vertical
    public void CrearArista_Vertical(ListaSimple lista1,ListaSimple lista2, Grafo tablero){
        for (int i = 0; i < 4; i++) {
           String letra1=(String)lista1.getValor(i);
           String letra2=(String)lista2.getValor(i); 
           Vertice v1=new Vertice(letra1);
           Vertice v2=new Vertice(letra2);
           tablero.nuevoArco(v1, v2, 1);
          
        }
        
    }
    
    public void CrearArista_DiagonalD(ListaSimple lista1,ListaSimple lista2, Grafo tablero){
        for (int i = 0; i < 4; i++) {
            
           String letra1=(String)lista1.getValor(i);
           String letra2=(String)lista2.getValor(i+1); 
           Vertice v1=new Vertice(letra1);
           Vertice v2=new Vertice(letra2);
           tablero.nuevoArco(v1, v2, 1); 
        }
    }
    
    public void CrearArista_DiagonalI(ListaSimple lista1,ListaSimple lista2, Grafo tablero){
        for (int i = 3; i>=0 ; i--) {
           String letra1=(String)lista1.getValor(i);
           String letra2=(String)lista2.getValor(i-1); 
           Vertice v1=new Vertice(letra1);
           Vertice v2=new Vertice(letra2); 
           tablero.nuevoArco(v1, v2, 1); 
        }
    }
   

    public void leer(String txt, ListaSimple lista, Grafo grafo) {
        String[] arreglo_arch = txt.split("/dic");
        ListaSimple lista1 = new ListaSimple();
        ListaSimple lista2 = new ListaSimple();
        ListaSimple lista3 = new ListaSimple();
        ListaSimple lista4 = new ListaSimple();
        
        Guardar_Dic(lista, arreglo_arch);
        Guardarletra_lista(lista1, lista2, lista3, lista4, arreglo_arch, grafo);

    }
        // Enumerador para definir los métodos de búsqueda disponibles
    public enum SearchMethod {
        DFS, // Búsqueda en profundidad
        BFS  // Búsqueda en amplitud
    }

     // Método para buscar una palabra en el grafo usando el método de búsqueda especificado
    public boolean buscarPalabra(String palabra, SearchMethod metodo, Grafo grafo) {
        switch (metodo) {
            case DFS:
                return grafo.DFS(palabra);
            case BFS:
                return grafo.BFS(palabra);
            default:
                throw new IllegalArgumentException("Método de búsqueda no soportado");
        }
    }
}
