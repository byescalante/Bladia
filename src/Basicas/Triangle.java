/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;

import java.awt.geom.GeneralPath;
import static Abstract.VarCustomCanvas.convertFisicX;
import static Abstract.VarCustomCanvas.convertFisicY;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
/**
 *
 * @author Amairani
 */
public class Triangle {
     private float x1,x2,x3,y1,y2,y3;
 
    GeneralPath path;
    boolean calcularvarr = true;
    Triangle  tria;
     public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }
    public  void calcularvar(){
        this.x1 = convertFisicX(x1);
        this.y1 = convertFisicY(y1);
        this.x2 = convertFisicX(x2);
        this.y2 = convertFisicY(y2);
        this.x3 = convertFisicX(x3);
        this.y3 = convertFisicY(y3);
        path = new GeneralPath();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.closePath();
    }
     public  void paint(Graphics2D g2, boolean draw, boolean fill ){
         if (calcularvarr) {
             calcularvar();
             calcularvarr = false;
         }
        if (draw && !fill) {
          g2.draw(path);
           
        }else if(fill && !draw){
            g2.fill(path);
        }else if(draw && fill){
            g2.draw(path);
            g2.fill(path);
        }
    }
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
