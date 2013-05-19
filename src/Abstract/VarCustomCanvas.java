/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author byescalante
 */
public abstract class VarCustomCanvas {
    /**
     * Variables principales con las que trabaja el canvas origial
     */ 
    public static  int centerx,centery,left,right,top,botton,xmiddle,ymiddel,maxX,maxY;
    public static  float rwidth,rheight,pixelSize;
    /**
     * 
     * @param Recibe un canvas como parametro. 
     */
    public static void iniciarVAr(Canvas c){
        Dimension d = c.getSize(); 
        maxX = d.width-1;
        maxY = d.height-1;
        centerx = maxX/2;
        centery = maxY/2;
        pixelSize = Math.max(rwidth/maxX, rheight/maxY);
        left =  convertFisicX(-rwidth/2);
        right = convertFisicX(rwidth/2);
        top = convertFisicY(rheight/2);
        botton = convertFisicY(-rheight/2);
        xmiddle = convertFisicX(0);
        ymiddel = convertFisicY(0);
    }
    /**
     * 
     * @param g Graphics donde se va a pintar.
     */
     public static void paintCuadricula(Graphics2D g){
        left =  convertFisicX(-rwidth/2);
        right = convertFisicX(rwidth/2);
        top = convertFisicY(rheight/2);
        botton = convertFisicY(-rheight/2);
        xmiddle = convertFisicX(0);
        ymiddel = convertFisicY(0);
        g.setColor(Color.white);
        g.fill(new Rectangle2D.Float(0, 0, maxX, maxY));
        g.setColor(Color.black);
        /**
         * pinta las linas orizontales.
         */
        g.setColor(Color.GRAY);
        for (int i = Math.round(-rwidth/2); i < Math.round(rwidth/2); i++) {
            g.drawLine(convertFisicX(i), top, convertFisicX(i), botton);
            g.drawString(Integer.toString(i), convertFisicX(i), ymiddel);
        }
        /**
         * pinta las linas Verticales.
         */
        g.setColor(Color.GRAY);
        for (int i = Math.round(-rheight/2); i < Math.round(rheight/2); i++) {
            g.drawLine(left, convertFisicY(i), right, convertFisicY(i));
            g.drawString(Integer.toString(i),xmiddle,convertFisicY(i));
        }
        /**
         * Pinta Cuadro Principal.
         */
        g.setColor(Color.blue);
        g.drawLine(left, top, right, top);
        g.drawLine(right, top, right, botton);
        g.drawLine(right, botton, left, botton);
        g.drawLine(left, botton, left, top);
        /**
         * Pinta la Cruz de la cuadricula.
         */
        g.drawLine(xmiddle, top, xmiddle, botton);
        g.drawLine(left, ymiddel, right,ymiddel );
    }
     /**
      * 
      * @param x Es una variable flotante.
      * @return Retorna el valor caluclado en el metodo.
      */
    public static int convertFisicX(float x){
        return Math.round(centerx+x/pixelSize) ;
    }
    /**
     * 
     * @param Y Es una variable flotante.
     * @return Retorna el valor caluclado en el metodo.
     */
    public static int convertFisicY(float y){
        return Math.round(centery-y/pixelSize);
    }
    /**
     * 
     * @param x Es una variable entera.
     * @return Retorna el valor caluclado en el metodo.
     */
    public static float convertRealX(int x){
        return (x-centerx)*pixelSize;
    }
    /**
     * 
     * @param y Es un avariable entera.
     * @return Retorna el valor caluclado en el metodo.
     */
    public static float convertRealY(int y){
        return (centery-y)*pixelSize;
    }
    
}
