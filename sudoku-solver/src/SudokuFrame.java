import javax.swing.*;
import java.awt.*;

/**
 * Classe che crea un semplice frame
 */

public class SudokuFrame extends JFrame {
    public SudokuFrame(){
        this.add(new SudokuPanel());
        this.setTitle("Sudoku solver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
