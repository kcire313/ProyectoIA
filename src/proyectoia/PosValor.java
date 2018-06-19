/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

/**
 *
 * @author Juan Arzate
 */
public class PosValor {
    private int posicion;
    private float valor;

    public PosValor(int posicion, float valor) {
        this.posicion = posicion;
        this.valor = valor;
    }   

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
