/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * * @author luisfdasilva
 */
public class MyQueue {
    private Nodo front;
    private Nodo back;

    public MyQueue() {
        this.front = null;
        this.back = null;
    }
    // Método encolar añade un nuevo elemento al final de la cola
    public void encolar(Object dato) {
        Nodo nuevo = new Nodo(dato); // Crear un nuevo nodo
        if (back != null) {
            back.setPnext(nuevo); // Enlazar el nuevo nodo al final anterior
        }
        back = nuevo; // Actualizar el final a ser el nuevo nodo
        if (front == null) {
            front = nuevo; // Si la cola estaba vacía, actualizar el frente a ser el nuevo nodo
        }
    }

    // Método desencolar elimina y retorna el elemento en el frente de la cola
    public Object desencolar() {
        if (front == null) return null; // Si la cola está vacía, retornar null
        Object dato = front.getDato(); // Obtener el dato del nodo en el frente
        front = front.getPnext(); // Mover el frente al siguiente nodo
        if (front == null) {
            back = null; // Si la cola se vuelve vacía, actualizar el final a null
        }
        return dato; // Retornar el dato del nodo eliminado
    }

    // Método isEmpty verifica si la cola está vacía
    public boolean isEmpty() {
        return front == null; // La cola está vacía si el frente es null
    }
}
