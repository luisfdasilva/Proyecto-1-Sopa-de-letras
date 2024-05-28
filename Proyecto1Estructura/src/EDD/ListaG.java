/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Grafo.Palabra;
/**
 *
 * @author luis
 */
public class ListaG {
    private NodoG head;
    private Integer Length;

    public ListaG(NodoG head, Integer Length) {
        this.head = null;
        this.Length = 0;
    }

    public NodoG getHead() {
        return head;
    }

    public void setHead(NodoG head) {
        this.head = head;
    }

    public Integer getLength() {
        return Length;
    }

    public void setLength(Integer newLength) {
        this.Length = newLength;
    }
    public void insertBegin(Palabra palabra, Nodo head, Lista adyacentes) {
        NodoG nodoG =new NodoG(palabra, head, adyacentes);
        if (isEmpty()){
        setHead(nodoG);
        }
        else{
        nodoG.setNext(getHead());
        setHead(nodoG);
        }
        this.setLength(this.getLength()+1);
    }

    public void insertFinal(Palabra palabra, Nodo head, Lista adyacentes) {
        NodoG nodoG =new NodoG(palabra, head, adyacentes);
        if (isEmpty()){
            setHead(nodoG);
        }
        else{
            NodoG pointer=getHead();
            while (pointer.getNext()!=null){
                pointer=pointer.getNext();
            }
            pointer.setNext(nodoG);
        }
        this.setLength(this.getLength()+1);
    }

    
    public void insertAtIndex(Palabra palabra, int index, Nodo head, Lista adyacentes) {
        NodoG nodoG =new NodoG(palabra, head, adyacentes);
        if (isEmpty() || index==0){
        insertBegin(palabra, head, adyacentes);
        }
        else {
            if (index<this.getLength()){
                NodoG pointer=getHead();
                int cont=0;
                while (cont<index-1){
                    pointer=pointer.getNext();
                    cont++;
                }
                nodoG.setNext(pointer.getNext());
                pointer.setNext(nodoG);
                this.setLength(this.getLength()+1);
            } 
            else if (index==this.getLength()){
                insertFinal(palabra, head, adyacentes);
            } 
            else {
                System.out.println("Index not valid");
            }
        }
    }

    
    public NodoG deleteBegin() {
        if (isEmpty()){
            System.out.println("La lista ya esta vacia");
            return null;
        }
        else{
            NodoG temp=getHead();
            setHead(temp.getNext());
            temp.setNext(null);
            this.setLength(this.getLength()-1);
            return temp;
        }
    }

   
    
    public NodoG deleteFinal() {
        if (isEmpty()){
            System.out.println("La lista ya esta vacia");
            return null;
        }
        else{
            NodoG pointer=getHead();
            while(pointer.getNext().getNext()!=null){
                pointer=pointer.getNext();
            }
            NodoG temp=pointer.getNext();
            pointer.setNext(null);
            this.setLength(this.getLength()-1);
            return temp;
        }
    }

    
    public NodoG deleteAtIndex(int index) {
        if (isEmpty()){
            System.out.println("La lista ya esta vacia");
            return null;
        }
        else{
            if (index==0){
                return deleteBegin();
            }
            else{
                if (index<getLength()){
                    NodoG pointer=getHead();
                    int cont=0;
                    while(cont<index-1){
                        pointer=pointer.getNext();
                        cont++;
                    }
                    NodoG temp=pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.setNext(null);
                    this.setLength(this.getLength()-1);
                    return temp;    
                }
                else{
                    if (index==getLength()-1){
                        return deleteFinal();
                    } 
                    else{
                        System.out.println("Index not valid");
                        return null;
                    }
                    
                }
            }
        }
    }

    public boolean isEmpty() {
            return getHead()==null;    
    }
    
    public void print() {
        NodoG pointer=getHead();
        while (pointer!=null){
            System.out.println(" ["+pointer.getPalabra()+"] " );
            pointer=pointer.getNext();
        }
    }
    
    
}
