// NoahTheCorgi

package goevolution;

import java.util.ArrayList;

public class GoEvolution {

    public String evolutionType;
    // board size (standard is the classical 19)
    public int n;
    // rows and columns and the inner most ArrayList<Integer>
    // ... is <type, red, blue, green> 4 elements ...
    public ArrayList<ArrayList<ArrayList<Integer>>> board;
    public int current = -1; // the initial starting is black rock in standard game

    public GoEvolution() {
        evolutionType = "default";
        n = 19; // size
        board = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int i=0; i<n; i++) {
            //System.out.println("was here 1");
            ArrayList<ArrayList<Integer>> aRow = new ArrayList<ArrayList<Integer>>();
            for (int j=0; j<n; j++) {
                //System.out.println("was here 2");
                ArrayList<Integer> aRock = new ArrayList<Integer>();
                aRock.add(0); // rock type is currently empty
                aRock.add(0); // rock color red: 0 by default
                aRock.add(0); // rock color green: 0 by default
                aRock.add(0); // rock color blue: 0 by default
                aRow.add(aRock);
            }
            board.add(aRow);
        }
    }

    public void updateBoard(int x, int y) {
        if (board.get(x).get(y).get(0) != 0) {
            // if it is a non-empty location...
            // empty the location
            board.get(x).get(y).set(0, 0);
            board.get(x).get(y).set(1, 0);
            board.get(x).get(y).set(2, 0);
            board.get(x).get(y).set(3, 0);
        }
        else {
            if (current == -1) {
                board.get(x).get(y).set(0, current); // rock type
                board.get(x).get(y).set(1, 0); // red
                board.get(x).get(y).set(2, 0); // green
                board.get(x).get(y).set(3, 0); // blue
                current = 1;
            }
            else {
                board.get(x).get(y).set(0, current); // rock type
                board.get(x).get(y).set(1, 230); // red
                board.get(x).get(y).set(2, 230); // green
                board.get(x).get(y).set(3, 230); // blue
                current = -1;
            }
        }
    }
}
