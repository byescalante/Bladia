/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bases;

/**
 *
 * @author byescalante
 */
public class Punto {
    private float x,y;
    /**
     * 
     * @param x es una variable flotante.
     * @param y es una variable flotante.
     */
    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
    /**
     * 
     * @return Devuelve una variable x.
     */
    public float getX() {
        return x;
    }
    /**
     * 
     * @param x Envia una variable x.
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * 
     * @return Devuelve una variable xy.
     */
    public float getY() {
        return y;
    }
    /**
     * 
     * @param y Devuelve una variable y.
     */
    public void setY(float y) {
        this.y = y;
    }
    /**
     * 
     * @return Devuelve el valor en fisico de la variable Y.
     */
    public int getXFisic(){
        return Abstract.VarCustomCanvas.convertFisicX(x);
    }
    /**
     * 
     * @return Devuelve el valor en fisico de la variable y.
     */
    public int getYFisic(){
        return Abstract.VarCustomCanvas.convertFisicY(y);
    }
}
