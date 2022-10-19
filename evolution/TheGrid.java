// NoahTheCorgi

package evolution;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class TheGrid {

    // Future Task #2: create Cell class instead of representing it as ArrayList in TheGrid,,,

    public String evolutionType;
    // board size (standard is the classical 19)
    public int n;
    // rows and columns and the inner most ArrayList<Integer>
    // ... is <type, red, blue, green> 4 elements ...
    
    public ArrayList<ArrayList<Cell>> board;

    //public ArrayList<ArrayList<ArrayList<Integer>>> board;
    public int current = -1; // the initial starting is black Cell in standard game

    public TheGrid(int sizeN) {
        n = sizeN;
        evolutionType = "default";
        // n = 20; // size
        
        // board = new ArrayList<ArrayList<ArrayList<Integer>>>();

        board = new ArrayList<ArrayList<Cell>>();

        for (int i=0; i<n; i++) {
            //System.out.println("was here 1");
            ArrayList<Cell> aRow = new ArrayList<Cell>();
            for (int j=0; j<n; j++) {
                //System.out.println("was here 2");
                Cell aCell = new Cell();
                // aCell.add(0); // Cell type is currently empty
                // aCell.add(0); // Cell color red: 0 by default
                // aCell.add(0); // Cell color green: 0 by default
                // aCell.add(0); // Cell color blue: 0 by default
                aRow.add(aCell);
            }
            board.add(aRow);
        }
    }

    public void updateBoard(int x, int y) {
        //if (board.get(x).get(y).get(0) != 0) {

        Cell aCell = board.get(x).get(y);

        //if (aCell.celltype != 0) {
        if (false) {
            // if it is a non-empty location...
            // empty the location
            // board.get(x).get(y).set(0, 0);
            // board.get(x).get(y).set(1, 0);
            // board.get(x).get(y).set(2, 0);
            // board.get(x).get(y).set(3, 0);
        }
        else {
            if (current == -1) {
                // board.get(x).get(y).set(0, current); // Cell type
                // board.get(x).get(y).set(1, 0); // red
                // board.get(x).get(y).set(2, 0); // green
                // board.get(x).get(y).set(3, 0); // blue
                aCell.celltype = current;
                aCell.color = new Color(0, 0, 0);
                current = 1;
            }
            else {
                // board.get(x).get(y).set(0, current); // Cell type
                // board.get(x).get(y).set(1, 230); // red
                // board.get(x).get(y).set(2, 230); // green
                // board.get(x).get(y).set(3, 230); // blue
                aCell.celltype = current;
                aCell.color = new Color(230, 230, 230);
                current = -1;
            }
        }
    }
}
