/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principales;


import Basicas.QuadCurv2;
import Abstract.Strocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static Abstract.VarCustomCanvas.*;
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
public class CustomCanvas extends Canvas {
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
    //====== iIndica el tipo de strok a pintar.
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
    //private Square cu = new Square(-2, 2, 4, 4);
    //private Elipse2D eli = new Elipse2D(-2, 2, 4, 4);
    //private Line2DPruebaByEscalante line = new Line2DPruebaByEscalante(-2, 0, 2, 0);
    //private RounRectanglePruebaByEscalante rect = new RounRectanglePruebaByEscalante(-2, 2, 4, 8, 50, 50);
    //private Triangle2DPruebaByEscalante triangle = new Triangle2DPruebaByEscalante(0, 4, 3, 0, -3, 0);
    //private Arco2 arc = new Arco2(-2, 2 , 4, 4);
    private QuadCurv2 curve = new QuadCurv2(-3, 3, 3, 3);
    /**
     * 
     * @param rwidth
     * @param rheight 
     */
    public CustomCanvas(float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
            
            /**
             * Devuelve un vento del teclado.
             */
            @Override
            public void keyPressed(KeyEvent e) { 
                /**
                 * Mover a la Izquierda
                 */
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    curve.moveLeft();
                    repaint();
                /**
                 * Mover hacia la Derecha
                 */    
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    curve.moveRight();
                    repaint();
                /**
                 * Mover hacia Arriba
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    curve.moveUp();
                    repaint();
                /**
                 * Mover hacia Abajo
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    curve.moveDwon();
                    repaint();
                /**
                 * Rotar a la Izquierda
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_1){
                    curve.RatationLeft();
                    repaint();
                /**
                 * Rotar a la Derecha
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_2){
                    curve.RatationRight();
                    repaint();
                /**
                 * Scalar en Incremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_3){
                    curve.ScaleUp();
                    repaint();
                /**
                 * Escalar en Decremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_4){
                    curve.ScaleDown();
                    repaint();
                }
                
            }
            
        });
    }
    /**
     * 
     * @param g Grafics principal sobre el que se pinta.
     */
   
    @Override
    public void paint(Graphics g){
        iniciarVAr(this);
        BufferedImage image = new BufferedImage(maxX,maxY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        paintCuadricula(g2);
        asignarV(g2);
        curve.paint(g2, draw);
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
