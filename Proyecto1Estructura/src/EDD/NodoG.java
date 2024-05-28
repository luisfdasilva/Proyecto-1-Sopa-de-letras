/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Grafo.Palabra;
import EDD.Lista;
/**
 *
 * @author luis
 */
public class NodoG {
    private Palabra palabra;
    private NodoG next;
    private Lista adyacentes;
    private Integer numeroComponente; 

    public NodoG(Palabra palabra, Nodo head, Lista adyacentes) {
        this.palabra = palabra;
        this.next = null;
        this.adyacentes = new Lista(head);
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public NodoG getNext() {
        return next;
    }

    public void setNext(NodoG next) {
        this.next = next;
    }

    public Lista getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }

    public Integer getNumeroComponente() {
        return numeroComponente;
    }

    public void setNumeroComponente(Integer numeroComponente) {
        this.numeroComponente = numeroComponente;
    }
    //imprime los atributos del nodo
    public void print(){
        System.out.println("-----------------------------------");
        System.out.println("Id: ");
        System.out.println("Numero: ");
        System.out.print("Relaciones: ");
        Nodo pointer=this.getAdyacentes().getHead();
        while (pointer!=null){
            System.out.print("["+pointer.getElement()+"]");
            pointer=pointer.getNext(); 
        }
        System.out.println(" ");
        System.out.println("-----------------------------------");
    }
    
}
