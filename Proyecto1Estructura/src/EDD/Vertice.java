/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author eliocolmenares
 */
public class Vertice {
     private String letra;
    private int numVertice;
    private boolean fueVisitado;

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public boolean isFueVisitado() {
        return fueVisitado;
    }

    public void setFueVisitado(boolean fueVisitado) {
        this.fueVisitado = fueVisitado;
    }

    public Vertice(String letra, int numVertice) {
        this.letra = letra;
        this.numVertice = numVertice;
        this.fueVisitado = false;
    }
    
    public Vertice(String letra) {
        this.letra = letra;
        this.numVertice = -1;
        this.fueVisitado = false;
    }

}
