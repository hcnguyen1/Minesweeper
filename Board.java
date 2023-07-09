import javax.swing.*;
import java.awt.*;

// Board UI

public class Board extends JPanel {
    private int[][] mines;
    private int[][] neighbours;
    private boolean[][] revealed;
    private boolean[][] flagged;
    public int mX = -100;
    public int mY = -100;
    public int spacing = 5;

    public Board(int[][] mines, int[][] neighbours, boolean[][] revealed, boolean[][] flagged) {
        this.mines = mines;
        this.neighbours = neighbours;
        this.revealed = revealed;
        this.flagged = flagged;
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0, 0, 1297, 840);

        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 9; j++) {
                // Creating Tiles 
                graphics.setColor(Color.gray);
                if(revealed[i][j] == true) {
                    graphics.setColor(Color.white);
                }
                if(mines[i][j] == 1) {
                    graphics.setColor(Color.RED);
                }
                if(flagged[i][j] == true) {
                    graphics.setColor(Color.orange);
                }
                                
                if(mX >= spacing+i*80+7 && mX < spacing+i*80+80+7-2*spacing
                && mY >= spacing+j*80+80+30 && mY < spacing+j*80+30+80+80+-2*spacing) {
                    graphics.setColor(Color.GREEN);
                }
                graphics.fillRect(spacing + i*80, spacing + j*80+80, 80-2*spacing, 80-2*spacing);
            }
        }
    }
}