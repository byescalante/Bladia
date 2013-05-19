/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Principales.CustomCanvas;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Amairani
 */
public class GuiGuada  extends JFrame{
    public static void main(String[] args) {
        
    }

    public GuiGuada()  {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(this);
        add("Center", new CanvasGuadalupe(18.0F, 18.0F));
    }
    
}
