import java.util.Random;
import javax.swing.*;

public class GUI extends JFrame {

  Random rand = new Random(); // Randomly placed.
  private int[][] mines = new int[16][9]; // Mines through out the map
  // private int[][] neighbours = new int[16][9]; // How much bomb is adjacent to this tile.
  // private boolean[][] revealed = new boolean[16][9]; // Opened square created by Player
  // private boolean[][] flagged = new boolean[16][9]; // Flagged square created by Player

  public GUI() {
    this.setTitle("Minesweeper");
    this.setSize(1297, 840);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);

    // Creating Mines
    for(int i=0; i<16; i++) {
      for(int j=0; j<9; j++) {
        if(rand.nextInt(100) < 20) { // 20% chance to generate a mine
          mines[i][j] = 1; // Generate
        } else {
          mines[i][j] = 0; // Empty
        }
      }
    }
    

    Board board = new Board(mines);
    this.setContentPane(board);

    Interaction interaction = new Interaction(board);
    this.addMouseMotionListener(interaction);

    Click click = new Click();
    this.addMouseListener(click);

  }
  public int[][] getMines() {
    return this.mines;
  }
}

