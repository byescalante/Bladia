/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;

import java.awt.geom.GeneralPath;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author byescalante
 */
public class QuadCurv2 {
    /**
     * Variable de alcanse con ls que se va a crear el QuadCurve2D.
     */
    private float x1,y1,x3,y3;
    private float x2 = 0;
    private float y2 = 0;
    private boolean calcularVar = true;
    private QuadCurve2D curve;
    private GeneralPath path;
    private boolean vez = true;
    /**
     * 
     * @param x1 Variabel flotante que formara parte del punto de inicio.
     * @param y1 Variabel flotante que formara parte del punto de inicio.
     * @param x3 Variabel flotante que formara parte del punto de final.
     * @param y3 Variabel flotante que formara parte del punto de final.
     */
    public QuadCurv2(float x1, float y1,float x3, float y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x3 = x3;
        this.y3 = y3;
    }
    /**
     * Se inicializan las variables del QuadCurve.
     */
    public void calcular(){
        if (vez) {
            this.x1 = convertFisicX(x1);
            this.y1 = convertFisicY(y1);
            this.x3 = convertFisicX(x3);
            this.y3 = convertFisicY(y3);
            vez = false;
        }
        curve = new QuadCurve2D.Float(x1, y1, x2, y2, x3, y3);
        path = new GeneralPath(curve);
    }
    /**
     * 
     * @param g Es el graphics sobre el cual se va a pintar.
     * @param draw Variable booleana que determina si se va a pintar el contorno.
     */
    public void paint(Graphics2D g,boolean draw){
        if (calcularVar) {
             calcular();
             calcularVar = false;
         }
        
         if (draw) {
             g.draw(path);
         }
     }
    /**
     * Mover a la Izquierda.
     */
    public void moveLeft(){
         AffineTransform t = new AffineTransform();
         t.translate(-3, 0);
         path.transform(t);
     }
     /**
      * Muever la derecha.
      */
     public void moveRight(){
         AffineTransform t = new AffineTransform();
         t.translate(5, 0);
         path.transform(t);
     }
     /**
      * Mover hacia abajo.
      */
     public void moveUp(){
         AffineTransform t = new AffineTransform();
         t.translate(0, -5);
         path.transform(t);
     }
     /**
      *  Mover hacia arriba
      */
     public void moveDwon(){
         AffineTransform t = new AffineTransform();
         t.translate(0, 3);
         path.transform(t);
     }
     /**
      * Rota hacia el lado Izquierdo.
      */
     public void RatationLeft(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(-4), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     /**
      * Rota hacia el lado Derecho.
      */
     public void RatationRight(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(4), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     /**
      * Escala en Incremento.
      */
     public void ScaleUp(){
        AffineTransform t = new AffineTransform();
        t.scale(1.1, 1.1);
        path.transform(t);
     }
     /**
      * Escala en decremento.
      */
     public void ScaleDown(){
        AffineTransform t = new AffineTransform();
        t.scale(0.9, 0.9);
        path.transform(t); 
     }

    public void setPoint(float x2,float y2){
        this.x2 = x2;
        this.y2 = y2;
        calcularVar = true;
    }
     
     
    
}
