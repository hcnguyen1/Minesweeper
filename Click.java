import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener {

    private Board board;
    private boolean[][] revealed;
    private int[][] mines;
    private boolean[][] flagged;
    private int[][] neighbours;
    
    public Click(Board board, boolean[][] revealed, int[][] mines, boolean[][] flagged, int[][] neighbours) {
        this.board = board;
        this.revealed = revealed;
        this.mines = mines;
        this.flagged = flagged;
        this.neighbours = neighbours;
    }

    @Override
    
    public void mouseClicked(MouseEvent e) {
        // Open Tile
        if(e.getButton() == MouseEvent.BUTTON1 && inBoxX() != -1 && inBoxY() != -1 && !flagged[inBoxX()][inBoxY()]) { // Reveal
            System.out.println("It is inside the box: [" + inBoxX() + ", " + inBoxY() + "], Number of neighbours: " + neighbours[inBoxX()][inBoxY()]);

            revealed[inBoxX()][inBoxY()] = true;
            if(revealed[inBoxX()][inBoxY()] == true && mines[inBoxX()][inBoxY()] == 1 && !flagged[inBoxX()][inBoxY()]) { // Revealed a bomb
                System.out.println("Game Over");
            }
        } else if(e.getButton() == MouseEvent.BUTTON1 && inBoxX() != 1 && inBoxY() != 1) {
            System.out.println("Not a box!");
        } else if(e.getButton() == MouseEvent.BUTTON3 && flagged[inBoxX()][inBoxY()] == true) { // Unflag
            flagged[inBoxX()][inBoxY()] = false;
            System.out.println("Unflagged!");
        } else if(e.getButton() == MouseEvent.BUTTON3 && !revealed[inBoxX()][inBoxY()]) { // Flag
            flagged[inBoxX()][inBoxY()] = true;
            System.out.println("Flagged!");
        }
    }
    
    // If Mouse are inside the box
    public int inBoxX() {
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 9; j++) {
                if(board.mX >= board.spacing+i*80+7 && board.mX < board.spacing+i*80+80+7-2*board.spacing
                && board.mY >= board.spacing+j*80+80+30 && board.mY < board.spacing+j*80+30+80+80+-2*board.spacing) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int inBoxY() {
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 9; j++) {
                if(board.mX >= board.spacing+i*80+7 && board.mX < board.spacing+i*80+80+7-2*board.spacing
                && board.mY >= board.spacing+j*80+80+30 && board.mY < board.spacing+j*80+30+80+80+-2*board.spacing) {
                    return j;
                }
            }
        }
        return -1;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
