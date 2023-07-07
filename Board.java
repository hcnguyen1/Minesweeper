import java.util.*;
import javax.swing.*;
import java.awt.*;

// Board UI

public class Board extends JPanel {
    public void paintComponent(Graphics graphics) {
        int spacing = 5;

        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0, 0, 1297, 840);
      

        // Creating Tiles 
        graphics.setColor(Color.gray);
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 9; j++) {
                graphics.fillRect(spacing + i*80, spacing + j*80+80, 80-2*spacing, 80-2*spacing);
            }
        }
    }
}