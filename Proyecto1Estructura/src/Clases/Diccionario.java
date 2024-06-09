/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 * * @author eliocolmenares
 */
public class Diccionario {
   private ListaSimple palabras;
    
     public Diccionario() {
         this.palabras = new ListaSimple();
    }

    public ListaSimple getPalabras() {
        return palabras;
    }

    public void setPalabras(ListaSimple palabras) {
        this.palabras = palabras;
    }
    
    public void agregarPalabra(String palabra){
        this.palabras.InsertarFinal(palabra);
    }
    
    public boolean contiene(String palabra){
        return this.palabras.buscar(palabra);
    }
    
    public void mostrarPalabras(){
        this.palabras.mostrar();
    }
      
}
