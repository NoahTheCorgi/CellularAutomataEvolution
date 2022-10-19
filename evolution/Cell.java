// NoahTheCorgi

package evolution;

import java.awt.*;
import java.swing.*;
import java.util.ArrayList;

public class Cell {

    public protected int x;
    public protected int y;
    
    public protected Color color;
    
    public protected ArrayList<Behavior> behaviors;
    
    public Cell() {
        x = 0;
        y = 0;
        color = new Color(0, 0, 0);
        behaviors = new ArrayList<Behavior>();
        Behavior defaultBehavior = new Behvaior();
        behaviors.add(defaultBehavior);
        System.out.println("A Unique Cell has been created...");
    }
    
}
