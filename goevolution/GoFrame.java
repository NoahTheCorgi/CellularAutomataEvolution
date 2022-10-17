// NoahTheCorgi

package goevolution;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;

public class GoFrame extends JFrame {

    public GoFrame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 28 is the offset for the border in the height
        // 760 is a multiple of the n = 19,,,
        // this is only the case for version 1,,,
        setSize(new Dimension(760, 760 + 28));
        setResizable(false);
        setTitle("Go Evolution");
        // GoPanel is extending JPanel with mouse listener.
        GoPanel gopanel = new GoPanel();
        // set background to brown color...
        gopanel.setBackground(new Color(100, 70, 25));
        gopanel.goevolution = new GoEvolution();
        add(gopanel);
        gopanel.requestFocusInWindow();
    }

    public static void main(String[] args) throws IOException {
        GoFrame goframe = new GoFrame();
        while (true) {
            goframe.repaint();
        }
    }
}
