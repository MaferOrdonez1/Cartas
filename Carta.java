/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegosieteymedio;

import static java.lang.String.format;

/**
 *
 * @author mafer
 */
public class Carta {
    public static final char PICA = 0x2660;
    public static final char TREBOL = 0x2663;
    public static final char CORAZON = 0x2665;
    public static final char DIAMANTE = 0x2666;
    
    private final char ARR_IZQ = 0x250f;
    private final char ARR_DER = 0x2513;
    private final char ABJ_IZQ = 0x2517;
    private final char ABJ_DER = 0x251b;
    private final char ARR_ABJ = 0x2501;
    private final char IZQ_DER = 0x2503;
    
    private char palo;
    private char simbolo;
    private float valor;
    private int orden;

    public Carta(char palo, char simbolo, float valor, int orden) {
        this.palo = palo;
        this.simbolo = simbolo;
        this.valor = valor;
        this.orden = orden;
    }
    
    char obtenerPalo(){
        return this.palo;
    }    
    
    char obtenerSimbolo(){
        return this.simbolo;
    }
    
    float obtenerValor(){
        return this.valor;
    }
    
    int obtenerOrden(){
        return this.orden;
    }
    
    String mostrar(){
        String cadena = "";
        
        cadena = format("[ %c %c ]",this.simbolo,this.palo);
        
        return cadena;
    }

    @Override
    public String toString(){
        String cadena = "";
        String aux = "";
        int f,F=7,c,C=9;
        char[][] tabla;
        
        tabla = new char [F][C];
        
        //Se limpia la tabla    
        for(f=0;f<F;f++)
        {
            for(c=0;c<C;c++)
            {
                tabla[f][c] = ' ';
            }
        }
        //Se almacena el borde de la carta
        //primero las esquinas
        tabla[0][0]=ARR_IZQ;
        tabla[0][8]=ARR_DER;
        tabla[6][0]=ABJ_IZQ;
        
        //Arriba y abajo
        for(c=1;c<C-1;c++)
        {
            tabla[0][c]=ARR_ABJ;
            tabla[6][C]=ARR_ABJ;
        }
        
        //Laterales
        for(f=1;f<F-1;f++)
        {
            tabla[f][0]=IZQ_DER;
            tabla[f][8]=IZQ_DER;
        }
        
        tabla[1][1]=this.simbolo;
        tabla[5][7]=this.simbolo;
        
        //y la carta
        switch (this.simbolo) 
        {
            case 'A':
            case 'J':
            case 'Q':
            case 'K': tabla[3][4] = this.palo;
            break;
            case '2': tabla[2][4] = this.palo;
                      tabla[4][4] = this.palo;
            break;
            case '3': tabla[3][4] = this.palo;
                      tabla[2][4] = this.palo;
                      tabla[4][4] = this.palo;
            break;
            case '4': tabla[2][2] = this.palo;
                      tabla[2][6] = this.palo;
                      tabla[4][2] = this.palo;
                      tabla[4][6] = this.palo;
            break;
            case '5': tabla[3][4] = this.palo;
                      tabla[2][2] = this.palo;
                      tabla[2][6] = this.palo;
                      tabla[4][2] = this.palo;
                      tabla[4][6] = this.palo;
            break;
            case '6': tabla[2][2] = this.palo;
                      tabla[2][6] = this.palo;
                      tabla[4][2] = this.palo;
                      tabla[4][6] = this.palo;
                      tabla[3][2] = this.palo;
                      tabla[3][6] = this.palo;
            break;
            case '7': tabla[3][4] = this.palo;
                      tabla[2][2] = this.palo;
                      tabla[2][6] = this.palo;
                      tabla[4][2] = this.palo;
                      tabla[4][6] = this.palo;
                      tabla[3][2] = this.palo;
                      tabla[3][6] = this.palo;
            break;
            }
            
            //guardamos en la cadena
            for(f=0;f<F;f++)
            {
                for(c=0;c<C;c++)
                {
                aux=String.format("%c", tabla[f][c]);
                cadena=cadena.concat((String)aux);
                }
                cadena=cadena.concat("/n");
            }
        return cadena;
    }
}      

