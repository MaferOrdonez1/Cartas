/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegosieteymedio;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
/**
 *
 * @author mafer
 */
public class Mazo {
    private String nombre;
    private LinkedList<Carta> mazo:
    
    public static final char[] palos = {Carta.PICA, Carta.TREBOL, Carta.CORAZON, Carta.DIAMANTE};
    private static final char[] simbolos = {'A',1,2,3,4,5,6,7,8,9,'J','Q','K'};
    
    //private static final float[] valores={1,2,3,4,5,6,7,0.5f,0.5f,0.5f};
    
    
    Mazo(String nombre){
        this.nombre = nombre;
        this.mazo = new LinkedList<Carta>;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
   
    public void crearBaja(float[] valores) {
        int p,s,orden;
        Carta nuevaCarta;
        
        orden=0;
        for(p=0;p<palos.length;p++){
            for(s=0;s<palos.length;s++){
                nuevaCarta = new Carta(simbolos[s],palos[p]);
                orden++;
                this.mazo.add(nuevaCarta);
            }
        }
    }
    public String mostrar(){
        String txtBaraja = "";
        String aux = "";
        int contador = 0;
        
        if(!hayCartas()){
            txtBaraja = new String(this.nombre+"Sin cartas\n");  
        }else{     
            for(Carta c: this.mazo){
               aux = c.toString();
               txtBaraja = txtBaraja.concat((String)aux);
            }
            
        }
        return txtBaraja;
    }
             
    public void barajar(){
        Collections.shuffle(this.mazo);
    }    
    
    public int cuantasCartas(){
        return this.mazo.size();
    }
    
    public boolean hayCartas(){
        return !(this.mazo.isEmpty());
    }
    
    public void vaciar(){
        this.mazo.clear();
    }
    
    public void insertarCarta(Carta nueva){
        this.mazo.add(nueva);
    }
    
    public void ordenar(){
        Collections.sort(this.mazo);
    }
    
    public void agrupar(){
        Collections.sort(this.mazo, new AgruparCartasSimbolo);
    }
    
    public float sumarPuntos(){
        Carta c;
        float suma = 0f;
        Iterator<Carta> it = this.mazo.iterator();
        
        while(it.hasNext())
        {
            c = it.next(); //Mientras que haya un seguiente
            suma += c.obtenerValor(); //Escogemos el siguiente elemento
        }
        return suma;
    }
}
