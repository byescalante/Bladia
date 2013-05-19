/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.geom.GeneralPath;
//import  static Abstract.VarCCanvas.*;
import java.awt.Graphics2D;
/**
 *
 * @author Amairani
 */
public class Triangle {
     private float x1,x2,x3,y1,y2,y3;
 
    GeneralPath path;
    boolean calcularvarr = true;
    Triangle  tria;
     public Triangle(float x1, float x2, float x3, float y1, float y2, float y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }
    public  void calcularvar(){
        
      
        tria.path.moveTo(x1, y1);
        tria.path.lineTo(x2, y2);
        tria.path.lineTo(x3, y3);
        tria.path.closePath();
         path = new GeneralPath(path);
        
        
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
    
}
