/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import static Abstract.VarCustomCanvas.maxX;
import static Abstract.VarCustomCanvas.maxY;
import static Abstract.VarCustomCanvas.paintCuadricula;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Amairani
 */
public class CanvasAngel extends Canvas {
    private int centerX,centerY,left, right,top,bottom,xmiddle,ymiddle;
    private float pixelSize,rHeight,rWidth;
   

    
  
    
    public CanvasAngel() {
     
        this.rHeight = 10.10F;
        this.rWidth = 10.10F;
        setBackground(Color.WHITE);
    }
    public CanvasAngel(float rWidth, float rHeight) {
        super();
        this.rHeight = rHeight;
        this.rWidth = rWidth;
        setBackground(Color.WHITE);
    }
    public void iniciarval(){
       Dimension d = getSize();
       int maxX = d.width-1;
       int maxY = d.height-1;
       centerX = maxX/2;
       centerY = maxY/2;
       pixelSize = Math.max(rWidth/maxX,rHeight/maxY);
    }

    @Override
    public void paint(Graphics g) {
        iniciarval();
        BufferedImage image = new BufferedImage(maxX,maxY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        pintarCuadro(g2);
        paintCuadricula(g2);
       
        g.drawImage(image, 0, 0, this);
    }
   
    public void pintarCuadro(Graphics g){
       left = toFisicoX(-rWidth/2);
       right = toFisicoX(rWidth/2);
       top = toFisicoY(rHeight/2);
       bottom = toFisicoY(-rHeight/2);
        System.out.println(rHeight);
       xmiddle = toFisicoX(0);
       ymiddle = toFisicoY(0);
       
       g.setColor(Color.LIGHT_GRAY);
        for (float i =-rWidth/2; i < rWidth/2; i+=0.1F) {
             g.drawLine(toFisicoX(i),top,toFisicoX(i),bottom);
            
        }
        g.setColor(Color.LIGHT_GRAY);
        for (float i = -rHeight/2; i < rHeight/2; i+=0.1F) {
            g.drawLine(left, toFisicoY(i), right, toFisicoY(i));
            
        }
       
       
        for (int i =  Math.round(-rWidth/2); i < Math.round(rWidth/2); i++) {
            g.drawLine(toFisicoX(i),top,toFisicoX(i),bottom);
            g.drawString(""+i, toFisicoX(i),ymiddle);
            g.setColor(Color.DARK_GRAY);
            
        }
        for (int i = Math.round(-rHeight/2); i < Math.round(rHeight/2); i++) {
            g.drawLine( left,toFisicoY(i), right,toFisicoY(i));
             g.drawString(""+i, xmiddle, toFisicoY(i));
            g.setColor(Color.DARK_GRAY);
           
            
        }
      g.setColor(Color.BLACK);
       g.drawLine(left, top, right,top);
       g.drawLine(right,top,right, bottom);
       g.drawLine(right,bottom,left, bottom);
       g.drawLine(left, bottom,left, top);
       
       g.setColor(Color.BLACK);
       g.drawLine( xmiddle,top,xmiddle,bottom);
       g.drawLine(left,ymiddle,right,ymiddle);
    }
   private int toFisicoX(float x){
       return Math.round(centerX+x/pixelSize);
   } 
   private int toFisicoY(float y){
       return Math.round(centerY-y/pixelSize);
   } 
   private float realX(int x){
       return (x-centerX)*pixelSize;
   }
   private  float realY (int y){
       return (centerY-y)*pixelSize;
   }
}
