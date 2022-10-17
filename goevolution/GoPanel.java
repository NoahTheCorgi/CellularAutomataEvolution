// NoahTheCorgi

package goevolution;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.Raster;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.lang.Math;
import java.util.ArrayList;

public class GoPanel extends JPanel implements MouseListener {

    protected int x; // mouse location x axis
    protected int y; // mouse location y axis
    // (0, 0) is the left top corner, and increases right and downwards,,,

    public GoEvolution goevolution;

    protected boolean justClicked = false;

    public Color currentColor = Color.black;

    public GoPanel() {
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("mouse pressed at: " + e.getX() + ", " + e.getY());
        int size = goevolution.n;
        int locationX;
        int incrementSize = (int) (getWidth()/(size));
        int pixelRemainder = e.getX() % incrementSize;
        int pixelMainAmount = (int) ((e.getX() - pixelRemainder)/incrementSize);
        locationX = (int) (pixelMainAmount + Math.round(pixelRemainder/incrementSize));
        int locationY;
        incrementSize = (int) (getHeight()/(size));
        pixelRemainder = e.getY() % incrementSize;
        pixelMainAmount = (int) ((e.getY() - pixelRemainder)/incrementSize);
        locationY = (int) (pixelMainAmount + Math.round(pixelRemainder/incrementSize));
        goevolution.updateBoard(locationX, locationY);
        justClicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouse released at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("mouse entered at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("mouse exited at: " + e.getX() + ", " + e.getY());  
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // set background color ...
        // graphics.setColor(new Color(0, 0, 0));
        int size = goevolution.n;
        for (int i=0; i<size; i++) {
            graphics.drawLine(i * getWidth()/(size) + (20), 20, i * getWidth()/(size) + (20), getHeight() - 20);
        }
        for (int i=0; i<size; i++) {
            graphics.drawLine(20, i * getHeight()/(size) + (20), getWidth() - 20, i * getHeight()/(size) + (20));
        }
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                // i is the row number corresponding to the vertical
                // j is the horizontal,, the column number...
                Integer locationValue = goevolution.board.get(i).get(j).get(0);
                if (locationValue != 0) {
                    ArrayList<Integer> aRock = goevolution.board.get(i).get(j);
                    System.out.println("aRock.get(2):: " + aRock.get(2));
                    graphics.setColor(new Color(aRock.get(1), aRock.get(2), aRock.get(3)));
                    graphics.fillOval((int) (i * Math.ceil(760 / (size))), (int) (j * Math.ceil(760 / (size))), 
                            (int) (760/(size)), (int) (760/(size)));
                }
            }
        }
    }
}
