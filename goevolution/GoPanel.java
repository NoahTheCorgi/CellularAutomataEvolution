// NoahTheCorgi

package goevolution;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.Raster;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.lang.Math;

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
        int size = goevolution.n;
        int locationX;
        int incrementSize = (int) (getWidth()/(size - 1));
        int pixelRemainder = e.getX() % incrementSize;
        int pixelMainAmount = (int) ((e.getX() - pixelRemainder)/incrementSize);
        locationX = (int) (pixelMainAmount + Math.round(pixelRemainder/incrementSize));
        int locationY;
        incrementSize = (int) (getHeight()/(size - 1));
        pixelRemainder = e.getY() % incrementSize;
        pixelMainAmount = (int) ((e.getY() - pixelRemainder)/incrementSize);
        locationY = (int) (pixelMainAmount + Math.round(pixelRemainder/incrementSize));
        goevolution.updateBoard(locationX, locationY);
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
        // set background color ...
        graphics.setColor(new Color(0, 0, 0));
        int size = goevolution.n;
        for (int i=0; i<size; i++) {
            graphics.drawLine(i * getWidth()/(size - 1), 0, i * getWidth()/(size - 1), getHeight());
        }
        for (int i=0; i<size; i++) {
            graphics.drawLine(0, i * getHeight()/(size - 1), getWidth(), i * getHeight()/(size - 1));
        }
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                Integer locationValue = goevolution.board.get(i).get(j);
                if (locationValue == 1) {
                    // draw a circle at location x , y, width, height::
                    graphics.setColor(new Color(0, 0, 0));
                    graphics.fillOval((int) (i * getWidth()/(size - 1)), (int) (i * getHeight()/(size - 1)), 
                            (int) (getWidth()/(size - 1)), (int) (getHeight()/(size - 1)));
                }
                else if (locationValue == -1) {
                    graphics.setColor(new Color(0, 0, 0));
                    graphics.fillOval((int) (i * getWidth()/(size - 1)), (int) (i * getHeight()/(size - 1)), 
                            (int) (getWidth()/(size - 1)), (int) (getHeight()/(size - 1)));
                }
            }
        }
    }
}
