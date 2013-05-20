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
    
   
    //private Square cu = new Square(-2, 2, 4, 4);
    public CanvasGuadalupe( float rwidth, float rheight) {
        Abstract.VarCustomCanvas.rwidth = rwidth;
        Abstract.VarCustomCanvas.rheight = rheight;
        setBackground(Color.WHITE);
       
    
        
    }
    
}
   
      
       

