// NoahTheCorgi

package goevolution;

import java.util.ArrayList;

public class GoEvolution {

    public String evolutionType;
    public int n; // size
    public ArrayList<ArrayList<Integer>> board;

    public GoEvolution() {
        evolutionType = "default";
        n = 19; // size
        board = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<n; i++) {
            System.out.println("was here 1");
            ArrayList<Integer> aRow = new ArrayList<Integer>();
            for (int j=0; j<n; j++) {
                System.out.println("was here 2");
                aRow.add(0);
            }
            board.add(aRow);
        }
    }

    public void updateBoard(int x, int y) {
        board.get(x).set(y, 1);
    }
}
