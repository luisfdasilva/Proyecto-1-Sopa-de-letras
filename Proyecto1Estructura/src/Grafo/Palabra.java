/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

/**
 *
 * @author luis
 */
public class Palabra {
    private static int contadorId=0
            ;
    private int id;
    private String texto;
    private String[] posiciones;
    
public enum Direccion{
    HORIZONTAL,
    VERTICAL,
    DIAGONAL
}

    public Palabra(int id, String texto, String[] posiciones, Direccion direccion) {
        this.id = id;
        this.texto = texto;
        this.posiciones = posiciones;
    }


    
}
