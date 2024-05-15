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
    private Integer Lenght;

    public ListaG(NodoG head, Integer Lenght) {
        this.head = null;
        this.Lenght = 0;
    }

    public NodoG getHead() {
        return head;
    }

    public void setHead(NodoG head) {
        this.head = head;
    }

    public Integer getLenght() {
        return Lenght;
    }

    public void setLenght(Integer Lenght) {
        this.Lenght = Lenght;
    }
    public void insertBegin(Usuario usuario) {
        NodoG nodoG =new NodoG(usuario);
        if (isEmpty()){
        setHead(nodoG);
        }
        else{
        nodoG.setNext(getHead());
        setHead(nodoG);
        }
        length++;
    }

    public void insertFinal(Usuario usuario) {
        NodoG nodoG =new NodoG(usuario);
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
        length++;
    }

    
    public void insertAtIndex(Usuario usuario, int index) {
        NodoG nodoG =new NodoG(usuario);
        if (isEmpty() || index==0){
        insertBegin(usuario);
        }
        else {
            if (index<length){
                NodoG pointer=getHead();
                int cont=0;
                while (cont<index-1){
                    pointer=pointer.getNext();
                    cont++;
                }
                nodoG.setNext(pointer.getNext());
                pointer.setNext(nodoG);
                length++;
            } 
            else if (index==length){
                insertFinal(usuario);
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
            length--;
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
            length--;
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
                    length--;
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
            System.out.println(" ["+pointer.getPalabra().getId()+"] " );
            pointer=pointer.getNext();
        }
    }
    
    
}
