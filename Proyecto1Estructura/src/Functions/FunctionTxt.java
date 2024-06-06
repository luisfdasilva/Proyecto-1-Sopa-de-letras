/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Clases.Diccionario;
import Clases.SopaDeLetras;
import EDD.Grafo;
import EDD.ListaSimple;
import EDD.Nodo;
import EDD.Vertice;


/**
 *
 * @author eliocolmenares
 */
public class FunctionTxt {

    private char[][] generarMatrizDesdeString(String entrada) {
        String[] caracteres = entrada.split(",");
        char[][] letras = new char[4][4];
        int indice = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                letras[i][j] = caracteres[indice].charAt(0);
                indice++;
            }
        }
        
        return letras;
    }
    
    public void leerTXT(String archivo, SopaDeLetras sopaDeLetras){
        String txt = archivo.replaceAll("\r", "");
        String[] partsTxt = txt.split("/dic");
        
        String dicSeparado = partsTxt[0];
        String letraSeparado = partsTxt[1];
        
        String[] dic = dicSeparado.split("\n");
        String[] letras = letraSeparado.split("\n");
        
        //Creo el diccionario
        Diccionario diccionario = new Diccionario();
        
        //Lleno el diccionario
        for (int i = 1; i < dic.length; i++) {
            diccionario.agregarPalabra(dic[i]);   
        }
        
        sopaDeLetras.inicializar(generarMatrizDesdeString(letras[2]), diccionario);
        
    }
    
}
