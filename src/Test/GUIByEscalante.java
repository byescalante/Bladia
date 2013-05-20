/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import javax.swing.JFrame;

/**
 *
 * @author byescalante
 */
public class GUIByEscalante extends JFrame{
    public static void main(String[] args) {
        new GUIByEscalante().setVisible(true);
    }

    public GUIByEscalante() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(this);
        add("Center", new CustomCanvasbyescalante(18.0F, 18.0F));
    }
    
    
}
