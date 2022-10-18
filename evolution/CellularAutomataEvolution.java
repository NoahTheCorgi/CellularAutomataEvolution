// NoahTheCorgi

package evolution;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;

public class CellularAutomataEvolution extends JFrame {

    public static int n = 20;

    public static EvolutionPanel evolutionPanel;

    public CellularAutomataEvolution() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Future Task #1: dynamically create size with perfect integer division::
        // 28 is the offset for the border in the height
        setSize(new Dimension(n*40, n*40 + 28));
        setResizable(false);
        setTitle("Cellular Automata Evolution");
        evolutionPanel = new EvolutionPanel(n);
        evolutionPanel.setBackground(new Color(100, 200, 100));
        evolutionPanel.theGrid = new TheGrid(n);
        add(evolutionPanel);
        evolutionPanel.requestFocusInWindow();
    }

    public static void main(String[] args) throws IOException {
        CellularAutomataEvolution cellularAutomataEvolution = new CellularAutomataEvolution();
        cellularAutomataEvolution.repaint();
    }
}
