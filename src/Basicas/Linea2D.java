/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basicas;

import java.awt.geom.Line2D;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author byescalante
 */
public class Linea2D {
    private float x,y,x1,y1;
    private Line2D line;
    private boolean calcularVar = true;
    private GeneralPath path;

    public Linea2D(float x, float y, float x1, float y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.x1 = convertFisicX(x1);
        this.y1 = convertFisicY(y1);
        line = new Line2D.Float(x1, y1, x, y);
        path = new GeneralPath(line);
    }
    
    public void paint(Graphics2D g,boolean draw){
        if (calcularVar) {
             calcular();
             calcularVar = false;
         }
         if (draw) {
             g.draw(path);
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
