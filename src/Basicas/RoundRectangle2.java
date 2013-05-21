/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;

import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author byescalante
 */
public class RoundRectangle2 {
    /**
     * Variables de alcanse con las que se va a crear el RoundRect2D.
     */
    private float x,y,largo,alto,curveWidth,longCurve;
    private  RoundRectangle2D rectangle;
    private boolean calcularVar= true;
    private GeneralPath path;
    /**
     * 
     * @param x Variabel flotante que formara parte del punto de inicio.
     * @param y Variabel flotante que formara parte del punto de inicio.
     * @param largo Es el tamaño que tendra apartir del de las coordenadas de inicio.
     * @param alto Es la distancia que tendra hacia abajo aprtir de las cordenadas de inicio.
     * @param curveWidth Variable flotante que determinara la dimension de la curva sobre el width. 
     * @param longCurve Variable flotante que determinara la dimension de la curva sobre el Height.
     */
    public RoundRectangle2(float x, float y, float largo, float alto, float curveWidth, float longCurve) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
        this.curveWidth = curveWidth;
        this.longCurve = longCurve;
    }
    /**
     * Se inicializan las variables del RoundRect.
     */
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        this.curveWidth = 50;
        this.longCurve = 50;
        rectangle = new RoundRectangle2D.Float(this.x, this.y, this.largo, this.alto,this.curveWidth , this.longCurve);
        path = new GeneralPath(rectangle);
    }
    /**
     * 
     * @param g Es el graphics sobre el cual se va a pintar.
     * @param draw Variable booleana que determina si se va a pintar el contorno.
     * @param fill Variable booleana que determina si se va a pintar con relleno.
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
    
}
