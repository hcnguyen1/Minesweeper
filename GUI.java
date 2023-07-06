import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame {

  public GUI() {
    this.setTitle("Minesweeper");
    this.setSize(1286, 829);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);
    
    Board board = new Board();
    this.setContentPane(board);
  }

  public class Board extends JPanel {
    public void paintComponent(Graphics graphics) {
      graphics.setColor(Color.DARK_GRAY);
      graphics.fillRect(0, 0, 1280, 800);
      
    }
  }
}
