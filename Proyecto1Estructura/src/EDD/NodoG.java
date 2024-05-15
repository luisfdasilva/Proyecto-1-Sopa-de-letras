/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Grafo.Palabra;
import EDD.ListaG;
/**
 *
 * @author luis
 */
public class NodoG {
    private Palabra palabra;
    private NodoG next;
    private ListaG adyacentes;
    private Integer numeroComponente; 

    public NodoG(Palabra palabra, NodoG next, ListaG adyacentes) {
        this.palabra = palabra;
        this.next = null;
        this.adyacentes = new ListaG();
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

    public ListaG getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ListaG adyacentes) {
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
        System.out.println("Id: "+getPalabra().getId());
        System.out.println("Numero: "+getPalabra().getNumero());
        System.out.print("Relaciones: ");
        NodoG pointer=getAdyacentes().getHead();
        while (pointer!=null){
            System.out.print("["+pointer.getPalabra().getId()+"]");
            pointer=pointer.getNext(); 
        }
        System.out.println(" ");
        System.out.println("-----------------------------------");
    }
    
}
