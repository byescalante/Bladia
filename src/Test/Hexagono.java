/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.geom.GeneralPath;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
/**
 *
 * @author Angel
 */
public class Hexagono {

    private float x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
    GeneralPath path;
    boolean calcularVar = true;
    Hexagono hexa;

    public Hexagono(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, float x5, float y5, float x6, float y6) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        this.x5 = x5;
        this.y5 = y5;
        this.x6 = x6;
        this.y6 = y6;
        
    }
    
    public void calcularvaria(){
        this.x1 = convertFisicX(x1);
        this.y1 = convertFisicY(y1);
        this.x2 = convertFisicX(x2);
        this.y2 = convertFisicY(y2);
        this.x3 = convertFisicX(x3);
        this.y3 = convertFisicY(y3);
        this.x4 = convertFisicX(x4);
        this.y4 = convertFisicY(y4);
        this.x5 = convertFisicX(x5);
        this.y5 = convertFisicY(y5);
        this.x6 = convertFisicX(x6);
        this.y6 = convertFisicY(y6);
        
        path = new GeneralPath();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x4, y4);
        path.lineTo(x5, y5);
        path.lineTo(x6, y6);
        path.closePath();
    }
    
         public  void paint(Graphics2D g2, boolean draw, boolean fill ){
         if (calcularVar) {
             calcularvaria();
             calcularVar = false;
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
     //mueve hacia el lado derecha.
      
     public void moveRight(){
         AffineTransform t = new AffineTransform();
         t.translate(5, 0);
         path.transform(t);
     }
     // mover hacia abajo.
      
     public void moveUp(){
         AffineTransform t = new AffineTransform();
         t.translate(0, -5);
         path.transform(t);
     }
     //mover hacia arriba
      
     public void moveDwon(){
         AffineTransform t = new AffineTransform();
         t.translate(0, 3);
         path.transform(t);
     }
     //rota hacia la Izquierdo.
      
     public void RotacionLeft(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(-4), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     //rota hacia el lado Derecho.
      
     public void RatacionRight(){
         AffineTransform t = new AffineTransform();
         t.rotate(Math.toRadians(4), path.getBounds().getCenterX(), path.getBounds().getCenterY());
         path.transform(t);
     }
     //Incremento.
      
     public void ScaleUp(){
        AffineTransform t = new AffineTransform();
        t.scale(1.1, 1.1);
        path.transform(t);
     }
     //decremento.
      
     public void ScaleDown(){
        AffineTransform t = new AffineTransform();
        t.scale(0.9, 0.9);
        path.transform(t); 
     }
}
