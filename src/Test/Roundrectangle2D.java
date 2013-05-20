/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;



import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import static Abstract.VarCustomCanvas.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author hugo
 */
public class Roundrectangle2D {
    private float x, y, largo, alto, oval1, oval2;
   private RoundRectangle2D rr;
   private GeneralPath path; 
   private boolean calcularVar = true;

    public Roundrectangle2D(float x, float y, float largo, float alto, float oval1,float oval2) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
        this.oval1 = oval1;
        this.oval2 = oval2;
    } 
    public void Calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        this.oval1 = convertFisicX(oval1);
        this.oval2 = convertFisicY(oval2);
        rr = new RoundRectangle2D.Float(x, y, largo, alto, oval1, oval2);
        path = new GeneralPath(rr);
    }
    
    public void paint(Graphics2D g, boolean draw,boolean fill){
       if (calcularVar) {
             Calcular();
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
    
    
   //mover derecha
   public void rightMove(){
       AffineTransform t = new AffineTransform();
         t.translate(2, 0);
         path.transform(t);
   }
   //mover izquierda
   public void moveLeft(){
       AffineTransform t = new AffineTransform();
         t.translate(-2, 0);
         path.transform(t);
   }
   //mover arriba
   public void moveUp(){
       AffineTransform t = new AffineTransform();
         t.translate(0, -2);
         path.transform(t);
   }
   //mover abajo
   public void moveDown(){
       AffineTransform t = new AffineTransform();
         t.translate(0, 2);
         path.transform(t);
   }
   //rotar derecha
   public void rotatRight(){
       AffineTransform t = new AffineTransform();
       t.rotate(Math.toRadians(2), path.getBounds().getCenterX(), path.getBounds().getCenterY());
       path.transform(t);
   }
   //rotar izquierda
   public void rotateLeft(){
       AffineTransform t = new AffineTransform();
       t.rotate(Math.toRadians(-2), path.getBounds().getCenterX(), path.getBounds().getCenterY());
       path.transform(t);
   }
   //escalar arriba
   public void scalingUp(){
       AffineTransform t = new AffineTransform();
       t.scale(1.1, 1.1);
       path.transform(t);
   }
   //escalar abajo (alineandose)
   public void scalingDown(){
       AffineTransform t = new AffineTransform();
       t.scale(0.9, 0.9);
       path.transform(t);
   }
}
