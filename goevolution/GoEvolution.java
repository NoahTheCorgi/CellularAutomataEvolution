// NoahTheCorgi

package goevolution;

import java.util.ArrayList;

public class GoEvolution {

    String evolutionType;
    int n; // size
    ArrayList<ArrayList<Integer>> board;

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
}
