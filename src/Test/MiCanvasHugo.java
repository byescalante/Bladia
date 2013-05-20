/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Abstract.Strocks;
import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import static Abstract.VarCustomCanvas.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author hugo
 */
public class MiCanvasHugo extends Canvas {
    //====== Pinta el borde del poligono si la variable es verdadera(true).
    private boolean draw = true;
    //====== pinta el relleno del poligono si la variable es verdadera(true). 
    private boolean fill = false;
    //====== pinta el pligono con un color si la variable es verdadera(true).
    private boolean isColor = true;
     //====== pinta el poligono con un gradiente si la variable es verdadera(true).
    private boolean isGradient = false;
     //====== determina el poligono que se desea dibujar.
    private int polygonPaint = 0;
    //====== define un stroke por default.
    private Stroke st = Strocks.simple;
    //====== indica el tipo de strok a pintar.
    private int asigStrock = 0;
    //====== crea un objeto de tipo grandient.
    private GradientPaint gradient;
    //====== define el primer color del gradient.
    private Color one = Color.BLUE;
    //====== define el segundo color del gradient.
    private Color two = Color.GREEN;
    //====== color por default.
    private Color c = Color.red;
    //====== composit por defualt.
    private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    
    private Roundrectangle2D c1 = new Roundrectangle2D(-4, 4, 8, 8, 1, 1);

    public MiCanvasHugo(float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        iniciarVAr(this);
        BufferedImage image = new BufferedImage(maxX,maxY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        paintCuadricula(g2);
        
        asignarV(g2);
       c1.paint(g2, draw, fill);
        
        
        g.drawImage(image, 0, 0, this);
    }
    
    public void asignarV(Graphics2D g2){
        if (isColor) {
            g2.setColor(c);
        }else if(isGradient){
            gradient = new GradientPaint(left, top, one, right, botton, two);
            g2.setPaint(gradient);
        }
        switch (asigStrock) {
            case 0:
                g2.setStroke(Strocks.simple);
                break;
            case 1:
                g2.setStroke(Strocks.medio);
                break;
            case 2:
                g2.setStroke(Strocks.completo);
                break;
        }
        g2.setComposite(composite);
        
    }

    @Override
    public void update(Graphics g) {
                paint(g);
    }
    
    
}
