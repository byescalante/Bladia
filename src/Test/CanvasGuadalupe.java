/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import Abstract.Strocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static Abstract.VarCustomCanvas.*;
import Basicas.Square;
import java.awt.AlphaComposite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

/**
 *
 * @author Amairani
 */
public class CanvasGuadalupe extends Canvas {
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
    private Color c = Color.BLACK;
    //====== composit por defualt.
    private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    Pentagono pen = new Pentagono(1,4,2,1,6,1,7,4,4,6);
    
   
    //private Square cu = new Square(-2, 2, 4, 4);
    public CanvasGuadalupe( float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    pen.moveLeft();
                    repaint();
                    
                }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    pen.moveRight();
                    repaint();
                }else if(e.getKeyCode()==KeyEvent.VK_UP){
                    pen.moveUp();
                    repaint();
                }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    pen.moveDwon();
                repaint();
                    
                    
                }else if(e.getKeyCode() == KeyEvent.VK_1){
                    pen.RatationLeft();
                    repaint();
                /**
                 * Rotar a la Derecha
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_2){
                    pen.RatationRight();
                    repaint();
                /**
                 * Scalar en Incremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_3){
                    pen.ScaleUp();
                    repaint();
                /**
                 * Escalar en Decremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_4){
                    pen.ScaleDown();
                    repaint();
                }
                    
            }
            
             });
       
        }

    @Override
    public void paint(Graphics g) {
        iniciarVAr(this);
        BufferedImage image = new BufferedImage(maxX,maxY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        paintCuadricula(g2);
        asignarV(g2);
        pen.paint(g2, draw, fill);
        g.drawImage(image, 0, 0, this);
    }
    /**
     * 
     * @param g2  un graphics donde se va a pintar.
     */
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

    public void setComposite(float x) {
        composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, x);
    }
    
    /**
     * 
     * @param g Graphics que actualiza el pintado del canvas.
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }
       
    }
    
            
   
      
       

