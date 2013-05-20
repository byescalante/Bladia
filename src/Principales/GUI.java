/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principales;

import javax.swing.JFrame;
/**
 *
 * @author byescalante
 */
public class GUI extends JFrame{
    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(this);
        
    }
}