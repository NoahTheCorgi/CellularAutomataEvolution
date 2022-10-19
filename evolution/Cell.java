// NoahTheCorgi

package evolution;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Cell {

    protected int celltype;

    protected int x;
    protected int y;
    
    protected Color color;
    
    protected ArrayList<Behavior> behaviors;
    
    public Cell() {
        celltype = 0; // empty cell as default,,,
        x = 0;
        y = 0;
        color = new Color(0, 0, 0);
        behaviors = new ArrayList<Behavior>();
        Behavior defaultBehavior = new Behavior();
        behaviors.add(defaultBehavior);
        System.out.println("A Unique Cell has been created...");
    }
    
}
