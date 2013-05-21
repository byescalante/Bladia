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
import Basicas.Arco2;
import Basicas.Elipse2D;
import Basicas.Linea2D;
import Basicas.RoundRectangle2;
import Basicas.Square;
import Basicas.Triangle;
import java.awt.AlphaComposite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Amairani
 */
public class CustomCanvas extends Canvas {
    /**
     * Pinta el borde del poligono si la variable es verdadera(true).
     */
    private boolean draw = true;
    /**
     * Pinta el relleno del poligono si la variable es verdadera(true).
     */ 
    private boolean fill = false;
    /**
     * Pinta el pligono con un color si la variable es verdadera(true).
     */
    private boolean isColor = true;
    /**
     * Pinta el poligono con un gradiente si la variable es verdadera(true).
     */
    private boolean isGradient = false;
     /**
      * Determina el poligono que se desea dibujar.
      */
    private int polygonPaint = -1;
    /**
     * Define un stroke por default.
     */
    private Stroke st = Strocks.simple;
    /**
     * Indica el tipo de strok a pintar.
     */
    private int asigStrock = 0;
    /**
     * Crea un objeto de tipo grandient.
     */
    private GradientPaint gradient;
    /**
     * Define el primer color del gradient.
     */
    private Color one = Color.BLUE;
    /**
     * Define el segundo color del gradient.
     */
    private Color two = Color.GREEN;
    /**
     * Color por default.
     */
    private Color c = Color.BLACK;
    /**
     * Composit por defualt.
     */
    private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    /**
     * Intancias del paquete Basicas.
     */
    private Arco2 arc = new Arco2(-4, 4 , 8, 8);
    private Elipse2D elipse = new Elipse2D(-3, 3, 6, 6);
    private QuadCurv2 curv = new QuadCurv2(-4, 4, 4, -4);
    private RoundRectangle2 rectangle = new RoundRectangle2(-4, 6, 8, 12, 50, 50);
    private Square cu = new Square(-4, 4, 8, 8);
    private Triangle triangle = new Triangle(0, 4, 3, -3, -3, -3);
    private Linea2D line = new Linea2D(-4, 0, 4, 0);
    
    /**
     * 
     * @param rwidth Es el ancho con el que trabaj el canvas.
     * @param rheight Es el largo con el trabaj el canvas.
     */
    public CustomCanvas(float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        setBackground(Color.WHITE);
        
    }
    public CustomCanvas() {
        Abstract.VarCustomCanvas.rwidth = 20;
        Abstract.VarCustomCanvas.rheight = 20;
        setBackground(Color.WHITE);
        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (polygonPaint==1) {
                    curv.setPoint(e.getX(), e.getY());
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
    /**
     * 
     * @param x Variable flotante con la trabaj el AlphaComposite.
     */
    public void setComposite(float x) {
        composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, x);
        repaint();
    }
    /**
     * 
     * @return Retorna el valor del poligono a Pintar.
     */
    public int getPolygonPaint() {
        return polygonPaint;
    }
    /**
     * 
     * @param polygonPaint Envia el valor del poligo a pintar.
     */
    public void setPolygonPaint(int polygonPaint) {
        this.polygonPaint = polygonPaint;
        repaint();
    }

    /**
     * 
     * @param g Graphics que actualiza el pintado del canvas.
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    /**
     * Metodo mover a la Inzquierda.
     */
    public void moveleft(){
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
    }
    /**
     * Metodo mover a la derecha.
     */
    public void moveRight(){
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
    }
    /**
     * Metodo mover arriba.
     */
    public void moveUp(){
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
    }
    /**
     * Metodo mover abajo.
     */
    public void moveDown(){
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
    }
    /**
     * Metodo rotar a la Izquierda.
     */
    public void rotationLeft(){
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
    }
    /**
     * Metodo rotar a la Derecha.
     */
    public void rotationRight(){
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
    }
    /**
     * Metodo escalar en Incremento.
     */
    public void scaleUp(){
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
    }
    /**
     * Metodo escalar en Decremento.
     */
    public void scaleDown(){
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
    /**
     * 
     * @param n Variable que determina el tipo de Strock.
     * 
     */
    public void setStroke(int n){
        asigStrock = n;
        repaint();
    }
    /**
     * 
     * @param draw Variable booleana que determina el pintado del contorno.
     */
    public void setDraw(boolean draw) {
        this.draw = draw;
        repaint();
    }
    /**
     * 
     * @param fill Variable booleana que determina el pintado del relleno.
     */
    public void setFill(boolean fill) {
        this.fill = fill;
         repaint();
    }
    /**
     * 
     * @param isColor Variable booleana que determina si se pintara.
     */
    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
         repaint();
    }
    /**
     * 
     * @param isGradient Variable booleana que determina si se pintara un gradiente.
     */
    public void setIsGradient(boolean isGradient) {
        this.isGradient = isGradient;
         repaint();
    }
    /**
     * 
     * @param one Primer color del gradiente.
     */
    public void setOne(Color one) {
        this.one = one;
         repaint();
    }
    /**
     * 
     * @param two Segundo color del gradiente.
     */
    public void setTwo(Color two) {
        this.two = two;
         repaint();
    }
    /**
     * 
     * @param c Variable asiganada para el color por default.
     */
    public void setC(Color c) {
        this.c = c;
         repaint();
    }
    
    
    
}
