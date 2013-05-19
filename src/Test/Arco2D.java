/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import static Abstract.VarCustomCanvas.*;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

/**
 *
 * @author Angel
 */
public class Arco2D {
    
    private float x1,y1,x2,y2,puntoInicial,puntofinal;
    private GeneralPath path;
    private Arc2D arco;

    public Arco2D(float x1, float y1, float x2, float y2, float puntoInicial, float puntofinal) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.puntoInicial = puntoInicial;
        this.puntofinal = puntofinal;
    }
    public void calcular(){
        this.x1 =convertFisicX(x1);
        this.y1 = convertFisicY(y1);
        this.x2 = convertFisicX(x2);
        this.y2 = convertFisicY(y2);
        this.puntoInicial = convertFisicX(puntoInicial);
        this.puntofinal = convertFisicY(puntofinal);
        arco = new Arc2D.Float(x1, y1, x2, y2, puntoInicial, puntofinal, Arc2D.OPEN);
        path = new GeneralPath(arco);
    }
    
    public void paint(Graphics2D g){
        
     g.setStroke(new BasicStroke(3.0f));
     calcular();
     g.draw(path);
    }
    
    
}
