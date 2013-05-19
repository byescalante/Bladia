/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author escalante
 */
public class Elipse2D{
    private float x,y,largo,alto;
    private Ellipse2D elipse;
    private GeneralPath path;
    private boolean calcular = true;

    public Elipse2D(float x, float y, float largo, float alto) {
        this.x = x;
        this.y = y;
        this.largo = largo;
        this.alto = alto;
    }
    
    public void calcular(){
        this.x = convertFisicX(x);
        this.y = convertFisicY(y);
        this.largo = convertFisicX(largo)-convertFisicX(0);
        this.alto = convertFisicY(0)-convertFisicY(alto);
        elipse = new Ellipse2D.Float(this.x, this.y, this.largo, this.alto);
        path = new GeneralPath(elipse);
    }
    
    public void paint(Graphics2D g,boolean draw,boolean fill){
        
         if (draw && !fill) {
             g.draw(path);
             
         }else if(fill && !draw){
             g.fill(path);
         }else if(draw && fill){
             g.draw(path);
             g.fill(path);
         }
     }
    
    

   
}
