/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.swing.JFrame;

/**
 *
 * @author hugo
 */
public class VentanaHugo extends JFrame{
    
    public static void main(String[] args) {
        new VentanaHugo().setVisible(true);
    }
    
    public VentanaHugo() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(this);
        
        add(new MiCanvasHugo(10.0F, 10.0F));
    }
}
