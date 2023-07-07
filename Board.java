import java.util.*;
import javax.swing.*;
import java.awt.*;

// Board UI

public class Board extends JPanel {
    public void paintComponent(Graphics graphics) {
      graphics.setColor(Color.DARK_GRAY);
      graphics.fillRect(0, 0, 1280, 800);
      
    }
}