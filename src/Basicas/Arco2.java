/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author byescalante
 */
public class Arco2 {
    private float x,y,largo,alto;
    private float startAngle = 0;
    private float angleEnd = 325;
    private int type = Arc2D.PIE;
    private GeneralPath path;
    private boolean calcularVar = true;
    private Arc2D arc;
    /**
     * 
     * @param x Variable flotante que determina el punto de inicio
     * @param y Variable flotante que determina el punto de inicio
     * @param largo Variable flotante que determina el largo del arc2D
     * @param alto Variable flotante que determina el alto del arc2D
     */
    public Arco2(float x, float y, float largo, float alto) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
    }
    /**
     * 
     */
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        arc = new Arc2D.Float(this.x, this.y, this.largo, this.alto, this.startAngle, this.angleEnd, type);
        path = new GeneralPath(arc);
    }
    /**
     * 
     * @param g Graphcis sobre el cual se pinta.
     * @param draw Determina si se pintara el contorno.
     * @param fill Determina si se pinta con relleno.
     */
    public void paint(Graphics2D g,boolean draw,boolean fill){
        if (calcularVar) {
             calcular();
             calcularVar = false;
         }
         if (draw && !fill) {
             g.draw(path);
         }else if(fill && !draw){
             g.fill(path);
         }else if(draw && fill){
             g.draw(path);
             g.fill(path);
         }
     }
    /**
     * Mover Izquierda
     */
     public void moveLeft(){
         AffineTransform t = new AffineTransform();
         t.translate(-5, 0);
         path.transform(t);
     }
     /**
      * Muever derecha.
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
         t.translate(0, 5);
         path.transform(t);
     }
     /**
      * Rota hacia el lado Izquierdo.
      */
     public void RatationLeft(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(-8), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     /**
      * Rota hacia el lado Derecho.
      */
     public void RatationRight(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(8), path.getBounds().getCenterX(), path.getBounds().getCenterY());
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
     /**
      * 
      * @return 
      */
    public float getAngleEnd() {
        return angleEnd;
    }
    /**
     * 
     * @param angleEnd 
     */
    public void setAngleEnd(float angleEnd) {
        this.angleEnd = angleEnd;
        calcularVar = true;
    }
    /**
     * 
     * @return 
     */
    public int getType() {
        return type;
    }
    /**
     * 
     * @param type 
     */
    public void setType(int type) {
        switch (type) {
            case 0:
                this.type = Arc2D.PIE;
                break;
            case 1:
                this.type = Arc2D.CHORD;
                break;
            case 2:
                this.type = Arc2D.OPEN;
                break;
           
        }
    }
     
     
    
}
