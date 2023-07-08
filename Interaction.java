import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Interaction implements MouseMotionListener {

    private Board board;
    public Interaction(Board board) {
        this.board = board;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("The mouse dragged.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("The mouse moved.");
        board.mX = e.getX();
        board.mY = e.getY();
        System.out.println("X: " + board.mX + ", Y: " + board.mY);
        
    }
}
