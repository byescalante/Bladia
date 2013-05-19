/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Angel
 */
public class GuiAngel extends JFrame{

    public static void main(String[] args) {
        new GuiAngel();
    }
    
    public GuiAngel() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(this);
        add("Center", new CanvasAngel(20.0f, 20.0f));
        setVisible(true);
    }
 
    
    
    
}
