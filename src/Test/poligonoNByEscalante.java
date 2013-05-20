/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import static Abstract.VarCustomCanvas.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author byescalante
 */
public class poligonoNByEscalante {
    private boolean calcularVar = true;
    private GeneralPath path;
    private float grados = (float) Math.toRadians(360);
    private int n;
    private ArrayList<Integer> list = new ArrayList<>();

    public poligonoNByEscalante(int n) {
        this.n = n;
    }
    
    public void calcular(){
       
    }
    
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
