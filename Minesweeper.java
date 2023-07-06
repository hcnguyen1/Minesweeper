public class Minesweeper implements Runnable {

  GUI gui = new GUI();

  public static void main(String[] args) {
    new Thread(new Minesweeper()).start();
    
  }

  @Override
  public void run() {
    while (true) {
      gui.repaint();
    }
  
  }
}
