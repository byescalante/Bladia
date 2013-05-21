/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

import java.awt.BasicStroke;
import java.awt.Stroke;

/**
 *
 * @author escalante
 */
public abstract class Strocks {
    /**
     * Variables con las que trabajan los strocks.
     */
    public static float anchoDefault = 3.0F; // ancho por default del strok.
    public static float delimiter = 4.0F; // determina el tamaño y estilo  de los Join.
    public static float indicatorLine=0; //indica que el strock se inciara con una linea.
    public static float indicatorSpace=1; // indica el tamaño del espacio.
    public static float[] array = {10.0F,4.0F,8.0F,6.0F}; // array con el trabaja el strock completo.
    /**
     * Declaro los tipos de strocks.
     */
    public static Stroke simple = new BasicStroke(anchoDefault);//=0
    public static Stroke medio = new BasicStroke(anchoDefault, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);//=1
    public static Stroke completo = new BasicStroke(anchoDefault, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, delimiter, array, indicatorLine);//=2
    
}
