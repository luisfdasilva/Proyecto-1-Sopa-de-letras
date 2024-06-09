/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Clases.SopaDeLetras;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 * * @author luisfdasilva
 */
public class GrafoGraphStream {
    private Graph graph;
    
    
    public GrafoGraphStream() {

        graph = new SingleGraph("Sopa de Letras");
        

    }


    public void addNode(String nodeId, String nodeLabel) {

        graph.addNode(nodeId);

        Node node = graph.getNode(nodeId);

        node.setAttribute("ui.label", nodeLabel);

}


    public void addEdge(String edgeId, String fromNodeId, String toNodeId) {

        graph.addEdge(edgeId, fromNodeId, toNodeId);

    }
    
    public void mostrarGrafo() {

        graph.display();

    }

    
    }
