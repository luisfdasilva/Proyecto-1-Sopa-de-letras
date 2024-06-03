/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author eliocolmenares
 */
public class Grafo {
    private int numVerts;
    private int MaxVerts;
    private Vertice [] verts;
    private int [][] matAd;

    public Grafo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    public int getNumVerts() {
        return numVerts;
    }

    public void setNumVerts(int numVerts) {
        this.numVerts = numVerts;
    }

    public int getMaxVerts() {
        return MaxVerts;
    }

    public void setMaxVerts(int MaxVerts) {
        this.MaxVerts = MaxVerts;
    }

    public Vertice[] getVerts() {
        return verts;
    }

    public void setVerts(Vertice[] verts) {
        this.verts = verts;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
    
    public Grafo(int mx){
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; i < mx; i++) {
                matAd[i][j] = 0;
            }
        }
        numVerts = 0;
    }
    
    public void nuevoVertice(Vertice nom) {
            Vertice v = new Vertice(nom.getLetra());
            v.setNumVertice(numVerts);
            verts[numVerts++] = v;
            System.out.println("El vertil vertice ha sido agregado exitosamente.");
    }

    public int numVertice(Vertice vs) {
        Vertice v = new Vertice(vs.getLetra(), vs.getNumVertice());
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].getLetra().equals(v.getLetra());
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }
    
    public Vertice vertice(int posicion){
        if(posicion <= this.getNumVerts()){
            Vertice v = this.getVerts()[posicion];
            return v;
        }
        return null;
    }
    
    public String nombreVertice(Vertice vs) {
        //Vertice v = new Vertice(vs.getLetra(), vs.getNumVertice());
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].getLetra().equals(vs.getLetra());
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVerts) ? vs.getLetra(): null;
    }
    
    public int nuevoArco(Vertice a, Vertice b, int peso){
        int va,vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va  < 0 || vb < 0) {
            return -1;
        }
        matAd[va][vb] = peso;
        matAd[vb][va] = peso;
        return peso;
    }
    
    public boolean adyacente(Vertice a, Vertice b) throws Exception {
        int va,vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
        return matAd[va][vb] != 0;
    }
      
    //Metodo para obtener los vertices que no han sido visitado
    public int VerticesNoVisitados(int vert){
        
        for (int j = 0; j < getNumVerts(); j++) {
            if(matAd[vert][j]!=0 && !verts[j].isFueVisitado()){
                return j;
            }  
        }
        return -1;
    }
    // Implementación de DFS para buscar una palabra en el grafo
    public boolean DFS(String word) {
        boolean[] visited = new boolean[numVerts];
        MyStack stack = new MyStack();

        for (int i = 0; i < numVerts; i++) {
            if (verts[i].getLetra().equals(word)) {
                return true;
            }
            if (!visited[i]) {
                stack.apilar(verts[i]);
                while (!stack.isEmpty()) {
                    Vertice v = (Vertice) stack.desapilar();
                    int vIndex = numVertice(v);
                    if (!visited[vIndex]) {
                        visited[vIndex] = true;
                        if (v.getLetra().equals(word)) {
                            return true;
                        }
                        for (int j = 0; j < numVerts; j++) {
                            if (matAd[vIndex][j] != 0 && !visited[j]) {
                                stack.apilar(verts[j]);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // Implementación de BFS para buscar una palabra en el grafo
    public boolean BFS(String word) {
        boolean[] visited = new boolean[numVerts];
        MyQueue queue = new MyQueue();

        for (int i = 0; i < numVerts; i++) {
            if (verts[i].getLetra().equals(word)) {
                return true;
            }
            if (!visited[i]) {
                queue.encolar(verts[i]);
                while (!queue.isEmpty()) {
                    Vertice v = (Vertice) queue.desencolar();
                    int vIndex = numVertice(v);
                    if (!visited[vIndex]) {
                        visited[vIndex] = true;
                        if (v.getLetra().equals(word)) {
                            return true;
                        }
                        for (int j = 0; j < numVerts; j++) {
                            if (matAd[vIndex][j] != 0 && !visited[j]) {
                                queue.encolar(verts[j]);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
