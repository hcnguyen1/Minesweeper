import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame {

  public GUI() {
    this.setTitle("Minesweeper");
    this.setSize(1297, 840);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);
    
    Board board = new Board();
    this.setContentPane(board);
  }
}
