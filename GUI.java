import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class GUI extends JFrame {

  Random rand = new Random(); // Randomly placed.
  private int[][] mines = new int[16][9]; // Mines through out the map
  private int[][] neighbours = new int[16][9]; // How much bomb is adjacent to this tile.
  private boolean[][] revealed = new boolean[16][9]; // Opened square created by Player
  private boolean[][] flagged = new boolean[16][9]; // Flagged square created by Player
  MouseEvent e;
  private int neighs;

  public GUI() {
    this.setTitle("Minesweeper");
    this.setSize(1297, 840);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);

    // Game Template
    for(int i=0; i<16; i++) {
      for(int j=0; j<9; j++) {
        if(rand.nextInt(100) < 20) { // 20% chance to generate a mine
          mines[i][j] = 1; // Generate
        } else {
          mines[i][j] = 0; // Empty
        }
        revealed[i][j] = false; // Revealed?
      }
    }
    // How much mines are in this box?
    for(int i=0; i<16; i++) {
      for(int j=0; j<9; j++) {
        neighs = 0;
        for(int m = 0; m < 16; m++) {
          for(int n = 0; n < 9; n++) {
            if(!(m==i && n == j)) {
              if(isN(i,j,m,n) == true) {
                neighs++;
              }
            }
          }
          neighbours[i][j] = neighs;
        }
      }
    }

    Board board = new Board(mines, neighbours, revealed, flagged);
    this.setContentPane(board);

    Interaction interaction = new Interaction(board);
    this.addMouseMotionListener(interaction);

    Click click = new Click(board, revealed, mines, flagged, neighbours);
    this.addMouseListener(click);

  }
  public int[][] getMines() {
    return this.mines;
  }

  public boolean isN(int mX, int mY, int cX, int cY) {
    if(mX - cX < 2 && mX - cX > -2 && 
    mY - cY < 2 && mY - cY > -2 &&
    mines[cX][cY] == 1) {
      return true;
    }
    return false;
  }

}

