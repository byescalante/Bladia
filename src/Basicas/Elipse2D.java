/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
/**
 *
 * @author escalante
 */
public class Elipse2D{
    /**
     * Variables de alcanse para crear el Ellipse2D.
     */
    private float x,y,largo,alto;
    private Ellipse2D elipse;
    private GeneralPath path;
    private boolean calcularVar = true;
    /**
     * 
     * @param x variable flotante que formara parte del punto de inicio.
     * @param y variable flotante que formara parte del punto de inicio.
     * @param largo variable flotante que determinara el largo del Ellipse2D.
     * @param alto variable flotante que determinara el largo del Ellipse2D.
     */
    public Elipse2D(float x, float y, float largo, float alto) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
    }
    /**
     *  Se inicializan las variables del Ellipse2D.
     */
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        elipse = new Ellipse2D.Float(this.x, this.y, this.largo, this.alto);
        path = new GeneralPath(elipse);
    }
    /**
     * 
     * @param g Es el grafics sobre el cual se va a pintar.
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
