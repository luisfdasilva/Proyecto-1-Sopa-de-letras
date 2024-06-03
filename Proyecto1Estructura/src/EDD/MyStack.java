/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author luis
 */
public class MyStack {
    private Nodo top;

    public MyStack() {
        this.top = null;
    }
        // Método apilar añade un nuevo elemento a la cima de la pila
    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato); // Crear un nuevo nodo
        if (top != null) {
            nuevo.setPnext(top); // Enlazar el nuevo nodo a la cima anterior
        }
        top = nuevo; // Actualizar la cima a ser el nuevo nodo
    }

    // Método desapilar elimina y retorna el elemento en la cima de la pila
    public Object desapilar() {
        if (top == null) return null; // Si la pila está vacía, retornar null
        Object dato = top.getDato(); // Obtener el dato del nodo en la cima
        top = top.getPnext(); // Mover la cima al siguiente nodo
        return dato; // Retornar el dato del nodo eliminado
    }

    // Método isEmpty verifica si la pila está vacía
    public boolean isEmpty() {
        return top == null; // La pila está vacía si la cima es null
    }

}
