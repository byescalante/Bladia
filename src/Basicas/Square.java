    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;
import java.awt.Graphics2D;
import static Abstract.VarCustomCanvas.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author byescalante
 */
public class Square {
    /**
     * Variables con las se va a crear el cuadrado2D.
     */
    private float x,y,largo,alto;
    private Rectangle2D rec;
    boolean calcularVar= true;
    GeneralPath path;
    /**
     * 
     * @param x Es el valor real del punto de inicio.
     * @param y Es el valor real del punto de inicio.
     * @param largo Es el tamaño que tendra apartir del de las coordenadas de inicio.
     * @param alto Es la distancia que tendra hacia abajo aprtir de las cordenadas de inicio.
     */
    public Square(float x, float y, float largo, float alto) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
      
    }
    /**
     * Metodo donde se calculan las variables del cuadrado.
     */
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        rec = new Rectangle2D.Float(this.x, this.y, this.largo, this.alto);
        path = new GeneralPath(rec);
    }
    /**
     * 
     * @param g Es grafics sobre el cual se va pintar.
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
         t.translate(-2, 0);
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
         t.translate(0, 2);
         path.transform(t);
     }
     /**
      * Rota hacia el lado Izquierdo.
      */
     public void RatationLeft(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(-3), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     /**
      * Rota hacia el lado Derecho.
      */
     public void RatationRight(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(3), path.getBounds().getCenterX(), path.getBounds().getCenterY());
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