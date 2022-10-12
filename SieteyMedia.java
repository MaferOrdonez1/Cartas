/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegosieteymedio;

/**
 *
 * @author mafer
 */
public class SieteyMedia {
    private int numJugadores;
    static final float [] valores = {1,2,3,4,5,6,7,0.5f,0.5f,0.5f};
    Mazo jugador[];
    boolean sigueJugando[];
    private int turno;
    private boolean juegoTerminado;
    Mazo baraja;
    public double puntos[]; 
    private boolean empate = true;
    
    public SieteyMedia(int numJugadores) {
        this.turno =0;
        this.juegoTerminado = false;
        this.numJugadores = numJugadores;
        jugador = new Mazo[numJugadores];
        sigueJugando = new boolean[numJugadores];
        
        baraja = new Mazo("Baraja");
        for(int j=0; j<numJugadores; j++){
            jugador[j] = new Mazo("Jugador"+j);
            sigueJugando[j] = true;
            puntos[j] = 0.0;
        
        }
        baraja.crearBaja(valores);
        baraja.barajar();
    }
    
    private void siguienteTurno(){
        for(int j= this.turno; j < this.numJugadores;){
            if(j == numJugadores -1){
                j=0;
            }else{
                j++;
            }
            if(this.sigueJugando[j]){
                turno = j;
                break;
            }
        }
    }
    
    private int obtenerTurno(){
        return this.turno;
    
    }
    
    public boolean fin(){
        return this.juegoTerminado;
    }
    
    public void juega(int j){
        Carta carta;
        float puntos;
        carta = this.baraja.extraerCarta();
        jugador[j].insertarCarta(carta);
        puntos = jugador[j].sumarPuntos();
        if(puntos>=7.5){
            this.sigueJugando[j] = false;
            comprobarFin();
        }
        if(puntos == 7.5){
            this.sigueJugando[j] = false;
            this.juegoTerminado = true;
        }
        if(!this.fin()){
            this.siguienteTurno();
        }
    
    }
    
    private void comprobarFin(){
        if(this.juegoTerminado == true){
            return;
        }
        for(int j =0; j<this.numJugadores;j++){
            if(sigueJugando[j]==true)
                return;
        }
        this.juegoTerminado = true;
        
    }
    
    
    public void sePlanta(int j){
        this.sigueJugando[j] = false;
        comprobarFin();
    }
    
    public double getPuntos(int j) {
        return jugador[j].sumarPuntos();
    }
    
    public String getCartas(int j){
        return jugador[j].toString();
    }
    
    public int ganador(){
        double puntos =0;
        int g=0;
        empate = false;
        
        for(int j =0; j<this.numJugadores; j++){
            if(this.jugador[j].sumarPuntos() == 7.5){
                return (j);
            }
            if(this.jugador[j].sumarPuntos()>7.5){
                continue;
            }else{
                if(j == 0){
                    g=0;
                    puntos = this.jugador[j].sumarPuntos();
                }else if (puntos < this.jugador[j].sumarPuntos()){
                    g=j;
                    puntos = this.jugador[j].sumarPuntos();
                    if(empate){
                        empate = false;
                    }
                }else if(puntos==this.jugador[j].sumarPuntos()){
                    empate = true;
                }        
            }
       }
        return g;
    }   
    
    public boolean hayEmpate(){
        double puntos =0;
        int g=0;
        empate = false;
        
        for(int j =0; j<this.numJugadores; j++){
            if(this.jugador[j].sumarPuntos() == 7.5){
                return false;
            }
            if(this.jugador[j].sumarPuntos()>7.5){
                continue;
            }else{
                if(j == 0){
                    g=0;
                    puntos = this.jugador[j].sumarPuntos();
                }else if (puntos < this.jugador[j].sumarPuntos()){
                    g=j;
                    puntos = this.jugador[j].sumarPuntos();
                    if(empate){
                        empate = false;
                    }
                }else if(puntos==this.jugador[j].sumarPuntos()){
                    empate = true;
                }        
            }
       }
       return empate;
    }  
    
    public String getNombre(int j){
        return jugador[j].obtenerNombre();
    }
}