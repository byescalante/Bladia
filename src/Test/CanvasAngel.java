/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import Abstract.Strocks;
import static Abstract.VarCustomCanvas.botton;
import static Abstract.VarCustomCanvas.iniciarVAr;
import static Abstract.VarCustomCanvas.left;
import static Abstract.VarCustomCanvas.maxX;
import static Abstract.VarCustomCanvas.maxY;
import static Abstract.VarCustomCanvas.paintCuadricula;
import static Abstract.VarCustomCanvas.right;
import static Abstract.VarCustomCanvas.rwidth;
import static Abstract.VarCustomCanvas.top;
import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Amairani
 */
public class CanvasAngel extends Canvas {
   
    private boolean draw = true;
    private boolean fill = false;
    private boolean isColor = true;
    private boolean isGradient = false;
    private int polygonPaint = 0;
    private Stroke st = Strocks.simple;
    private int asigStrock = 0;
    private GradientPaint gradient;
    private Color one = Color.BLUE;
    private Color two = Color.GREEN;
    private Color c = Color.BLACK;
    private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    private Hexagono hexag = new Hexagono(1, 2, -1, 2, -2, 0, -1, -2, 1, -2, 2, 0);
    
    
    public CanvasAngel(float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
    
           @Override
            public void keyPressed(KeyEvent e) { 
           
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    hexag.moveLeft();
                    repaint();
                   }
                    else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    hexag.moveRight();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_UP){
                    hexag.moveUp();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    hexag.moveDwon();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_1){
                    hexag.RotacionLeft();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2){
                    hexag.RatacionRight();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3){
                    hexag.ScaleUp();
                    repaint();
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4){
                    hexag.ScaleDown();
                    repaint();
                    }
            }
            
        });
    }
    
    @Override
    public void paint(Graphics g){
        iniciarVAr(this);
        BufferedImage image = new BufferedImage(maxX,maxY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        paintCuadricula(g2);
        asignarV(g2);
        hexag.paint(g2, draw, fill);
        g.drawImage(image, 0, 0, this);
    }
    
    public void asignarV(Graphics2D g2){
        if (isColor) {
            g2.setColor(c);
        }
        else if(isGradient){
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
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
