/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principales;


import Test.*;
import Basicas.QuadCurv2;
import Abstract.Strocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static Abstract.VarCustomCanvas.*;
import Basicas.Arco2;
import Basicas.Elipse2D;
import Basicas.Linea2D;
import Basicas.RoundRectangle2;
import Basicas.Square;
import Basicas.Triangle;
import java.awt.AlphaComposite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Amairani
 */
public class CustomCanvasbyescalante extends Canvas {
    //====== Pinta el borde del poligono si la variable es verdadera(true).
    private boolean draw = true;
    //====== pinta el relleno del poligono si la variable es verdadera(true). 
    private boolean fill = false;
    //====== pinta el pligono con un color si la variable es verdadera(true).
    private boolean isColor = true;
     //====== pinta el poligono con un gradiente si la variable es verdadera(true).
    private boolean isGradient = false;
     //====== determina el poligono que se desea dibujar.
    private int polygonPaint = 4;
    //====== define un stroke por default.
    private Stroke st = Strocks.simple;
    //====== iIndica el tipo de strok a pintar.
    private int asigStrock = 2;
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
    
    private Arco2 arc = new Arco2(-2, 2 , 4, 4);
    private Elipse2D elipse = new Elipse2D(-2, 2, 4, 4);
    private QuadCurv2 curv = new QuadCurv2(-3, 3, 3, 3);
    private RoundRectangle2 rectangle = new RoundRectangle2(-2, 2, 4, 8, 50, 50);
    private Square cu = new Square(-2, 2, 4, 4);
    private Triangle triangle = new Triangle(0, 4, 3, 0, -3, 0);
    private Linea2D line = new Linea2D(-2, 0, 2, 0);
    
    
    
    /**
     * 
     * @param rwidth
     * @param rheight 
     */
    public CustomCanvasbyescalante(float rwidth, float rheight) {
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
                    switch (polygonPaint) {
                        case 0:
                            line.moveLeft();
                            repaint();
                            break;
                        case 1:
                            curv.moveLeft();
                            repaint();
                            break;
                        case 2:
                            triangle.moveLeft();
                            repaint();
                            break;
                        case 3:
                            rectangle.moveLeft();
                            repaint();
                            break;
                        case 4:
                            cu.moveLeft();
                            repaint();
                            break;
                        case 5:
                            elipse.moveLeft();
                            repaint();
                            break;
                        case 6:
                            arc.moveLeft();
                            repaint();
                            break;
                        
                    }
                   
                    repaint();
                /**
                 * Mover hacia la Derecha
                 */    
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                   switch (polygonPaint) {
                        case 0:
                            line.moveRight();
                            repaint();
                            break;
                        case 1:
                            curv.moveRight();
                            repaint();
                            break;
                        case 2:
                            triangle.moveRight();
                            repaint();
                            break;
                        case 3:
                            rectangle.moveRight();
                            repaint();
                            break;
                        case 4:
                            cu.moveRight();
                            repaint();
                            break;
                        case 5:
                            elipse.moveRight();
                            repaint();
                            break;
                        case 6:
                            arc.moveRight();
                            repaint();
                            break;
                   }
                    repaint();
                /**
                 * Mover hacia Arriba
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_UP){
                    switch (polygonPaint) {
                        case 0:
                            line.moveUp();
                            repaint();
                            break;
                        case 1:
                            curv.moveUp();
                            repaint();
                            break;
                        case 2:
                            triangle.moveUp();
                            repaint();
                            break;
                        case 3:
                            rectangle.moveUp();
                            repaint();
                            break;
                        case 4:
                            cu.moveUp();
                            repaint();
                            break;
                        case 5:
                            elipse.moveUp();
                            repaint();
                            break;
                        case 6:
                            arc.moveUp();
                            repaint();
                            break;
                    }
                    repaint();
                /**
                 * Mover hacia Abajo
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    switch (polygonPaint) {
                        case 0:
                            line.moveDwon();
                            repaint();
                            break;
                        case 1:
                            curv.moveDwon();
                            repaint();
                            break;
                        case 2:
                            triangle.moveDwon();
                            repaint();
                            break;
                        case 3:
                            rectangle.moveDwon();
                            repaint();
                            break;
                        case 4:
                            cu.moveDwon();
                            repaint();
                            break;
                        case 5:
                            elipse.moveDwon();
                            repaint();
                            break;
                        case 6:
                            arc.moveDwon();
                            repaint();
                            break;
                    }
                    repaint();
                /**
                 * Rotar a la Izquierda
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_1){
                    switch (polygonPaint) {
                        case 0:
                            line.RatationLeft();
                            repaint();
                            break;
                        case 01:
                            curv.RatationLeft();
                            repaint();
                            break;
                        case 2:
                            triangle.RatationLeft();
                            repaint();
                            break;
                        case 3:
                            rectangle.RatationLeft();
                            repaint();
                            break;
                        case 4:
                            cu.RatationLeft();
                            repaint();
                            break;
                        case 5:
                            elipse.RatationLeft();
                            repaint();
                            break;
                        case 6:
                            arc.RatationLeft();
                            repaint();
                            break;
                        
                    }
                    repaint();
                /**
                 * Rotar a la Derecha
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_2){
                    switch (polygonPaint) {
                        case 0:
                            line.RatationRight();
                            repaint();
                            break;
                        case 01:
                            curv.RatationRight();
                            repaint();
                            break;
                        case 2:
                            triangle.RatationRight();
                            repaint();
                            break;
                        case 3:
                            rectangle.RatationRight();
                            repaint();
                            break;
                        case 4:
                            cu.RatationRight();
                            repaint();
                            break;
                        case 5:
                            elipse.RatationRight();
                            repaint();
                            break;
                        case 6:
                            arc.RatationRight();
                            repaint();
                            break;
                        
                    }
                    repaint();
                /**
                 * Scalar en Incremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_3){
                    switch (polygonPaint) {
                        case 0:
                            line.ScaleUp();
                            repaint();
                            break;
                        case 1:
                            curv.ScaleUp();
                            repaint();
                            break;
                        case 2:
                            triangle.ScaleUp();
                            repaint();
                            break;
                        case 3:
                            rectangle.ScaleUp();
                            repaint();
                            break;
                        case 4:
                            cu.ScaleUp();
                            repaint();
                            break;
                        case 5:
                            elipse.ScaleUp();
                            repaint();
                            break;
                        case 6:
                            arc.ScaleUp();
                            repaint();
                            break;
                    }
                    repaint();
                /**
                 * Escalar en Decremento
                 */
                }else if(e.getKeyCode() == KeyEvent.VK_4){
                    switch (polygonPaint) {
                        case 0:
                            line.ScaleDown();
                            repaint();
                            break;
                        case 1:
                            curv.ScaleDown();
                            repaint();
                            break;
                        case 2:
                            triangle.ScaleDown();
                            repaint();
                            break;
                        case 3:
                            rectangle.ScaleDown();
                            repaint();
                            break;
                        case 4:
                            cu.ScaleDown();
                            repaint();
                            break;
                        case 5:
                            elipse.ScaleDown();
                            repaint();
                            break;
                        case 6:
                            arc.ScaleDown();
                            repaint();
                            break;
                    }
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
        switch (polygonPaint) {
            case 0:
                line.paint(g2, draw);
                break;
            case 1:
                curv.paint(g2, draw);
                break;
            case 2:
                triangle.paint(g2, draw, fill);
                break;
            case 3:
                rectangle.paint(g2, draw, fill);
                break;
            case 4:
                cu.paint(g2, draw, fill);
                break;
            case 5:
                elipse.paint(g2, draw, fill);
                break;
            case 6:
                arc.paint(g2, draw, fill);
                break;
           
        }
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
