// NoahTheCorgi

package goevolution;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.Raster;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class GoPanel extends JPanel implements MouseListener {

    protected int x; // mouse location x axis
    protected int y; // mouse location y axis
    // (0, 0) is the left top corner, and increases right and downwards,,,

    public GoEvolution goevolution;

    public GoPanel() {
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited at: " + e.getX() + ", " + e.getY());  
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
