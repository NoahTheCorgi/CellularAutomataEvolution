// NoahTheCorgi

package evolution;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.ArrayList;

public class EvolutionPanel extends JPanel implements MouseListener {

    protected int x; // mouse location x axis
    protected int y; // mouse location y axis
    // (0, 0) is the left top corner, and increases right and downwards,,,

    public int n;

    public TheGrid theGrid;

    public boolean justClicked = false;

    public Color currentColor = Color.black;

    public EvolutionPanel(int sizeN) {
        n = sizeN;
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("mouse clicked at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed at: " + e.getX() + ", " + e.getY());
        System.out.println("log of the window width and height:: ");
        System.out.println("Screen Width:: " + getWidth());
        System.out.println("Screen Width:: " + getHeight());
        int size = theGrid.n;
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
        theGrid.updateBoard(locationX, locationY);
        justClicked = true;
        System.out.println(justClicked);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("mouse released at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("mouse entered at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("mouse exited at: " + e.getX() + ", " + e.getY());  
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // set background color ...
        // graphics.setColor(new Color(0, 0, 0));
        int size = theGrid.n;
        for (int i=0; i<size; i++) {
            graphics.drawLine(i * getWidth()/(size), 0, i * getWidth()/(size), getHeight());
        }
        for (int i=0; i<size; i++) {
            graphics.drawLine(0, i * getHeight()/(size), getWidth(), i * getHeight()/(size));
        }
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                // i is the row number corresponding to the vertical
                // j is the horizontal,, the column number...
                Integer locationValue = theGrid.board.get(i).get(j).get(0);
                if (locationValue != 0) {
                    ArrayList<Integer> aCell = theGrid.board.get(i).get(j);
                    //System.out.println("aCell.get(2):: " + aCell.get(2));
                    graphics.setColor(new Color(aCell.get(1), aCell.get(2), aCell.get(3)));
                    graphics.fillRect((int) (i * Math.ceil(40*n / (size))), (int) (j * Math.ceil(40*n / (size))), 
                            (int) (40*n/(size)), (int) (40*n/(size)));
                }
            }
        }
    }
}
