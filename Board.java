import javax.swing.*;
import java.awt.*;
import java.util.*;


// Board UI

public class Board extends JPanel {
    private int[][] mines;
    private int[][] neighbours;
    private boolean[][] revealed;
    private boolean[][] flagged;
    public int mX = -100;
    public int mY = -100;
    public int spacing = 5;
    private boolean revealedAll = false;
    private int flagCounter;


    public Board(int[][] mines, int[][] neighbours, boolean[][] revealed, boolean[][] flagged) {
        this.mines = mines;
        this.neighbours = neighbours;
        this.revealed = revealed;
        this.flagged = flagged;
    }

    public void paintComponent(Graphics graphics) {

        // Implement Number Colors
        Color darkBlue = new Color(0, 0, 139);
        Color cyan = new Color(0, 100, 100);
        Color darkRed = new Color(139, 0, 0);

        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0, 0, 1297, 840);

        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 9; j++) {
                // Mechanics
                graphics.setColor(Color.GRAY);
                if(revealed[i][j] == true) {
                    graphics.setColor(Color.white);
                    if(mines[i][j] == 1) {
                        graphics.setColor(Color.red);
                        revealedAll = true;
                    }
                }
                // If revealed and its a bomb, reveal all other bombs
                if(mines[i][j] == 1 && revealedAll == true) {
                    graphics.setColor(Color.RED);
                }
                
                if(flagged[i][j] == true) {
                    graphics.setColor(Color.orange);
                }               
                if(mX >= spacing+i*80+7 && mX < spacing+i*80+80+7-2*spacing
                && mY >= spacing+j*80+80+30 && mY < spacing+j*80+30+80+80+-2*spacing) {
                    graphics.setColor(Color.GREEN);
                }
                graphics.fillRect(spacing + i*80, spacing + j*80+80, 80-2*spacing, 80-2*spacing); // Creates Tile

                // Implement Numbers
                if(revealed[i][j] == true) { 
                    graphics.setColor(Color.black);
                    if(mines[i][j] == 0) {
                        graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                        switch(neighbours[i][j]) {
                            case 1:
                                graphics.setColor(Color.BLUE);
                                break;
                            case 2:
                                graphics.setColor(Color.GREEN);
                                break;
                            case 3:
                                graphics.setColor(Color.RED);
                                break;
                            case 4:
                                graphics.setColor(darkBlue);
                                break;
                            case 5:
                                graphics.setColor(darkRed);
                                break;
                            case 6:
                                graphics.setColor(cyan);
                                break;
                            case 7:
                                graphics.setColor(Color.black);
                                break;
                            case 8:
                                graphics.setColor(Color.gray);
                                break;
                            default:
                                graphics.setColor(Color.WHITE);
                                break;
                        }
                        
                        graphics.drawString(Integer.toString(neighbours[i][j]), i*80+27, j*80+80+55);
                    } else {
                        graphics.fillRect(i*80+10+20, j*80+80+20, 20, 40);
                        graphics.fillRect(i*80+20, j*80+80+10+20, 40, 20);
                        graphics.fillRect(i*80+5+20, j*80+80+5+20, 30, 30);
                        
                    }
                }
                // Draw all revealed bombs
                if(mines[i][j] == 1 && revealedAll == true) {
                    graphics.setColor(Color.black);
                    graphics.fillRect(i*80+10+20, j*80+80+20, 20, 40);
                    graphics.fillRect(i*80+20, j*80+80+10+20, 40, 20);
                    graphics.fillRect(i*80+5+20, j*80+80+5+20, 30, 30);
                }
            }
        }
    }
}