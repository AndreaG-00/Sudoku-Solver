import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe che crea un semplice panel in cui inseriro'
 * una tabella per sudoku in cui l'utente inserira'
 * i numeri dati dal sudoku da risolvere
 */

public class SudokuPanel extends JPanel implements ActionListener{

    //dimensions of frame
    static final int WIDTH = 540;
    static final int HEIGHT = 540;

    private GridLayout layout;
    private TextField[] textField = new TextField[81];
    private JButton solve;
    private String input = "";

    public SudokuPanel() {
        layout = new GridLayout(10,9);
        this.setLayout(layout);

        for(int i = 0; i < 81; i++){
            textField[i] = new TextField();
            textField[i].setPreferredSize(new Dimension(10, 10));
            this.add(textField[i]);
        }

        solve = new JButton("solve");
        solve.addActionListener(this);
        this.add(solve);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
    }

    public String readText(){
        for(int i = 0; i < 81; i++){
            if(textField[i].getText().isEmpty()){
                input += ".";
            }
            else{
                input += "" + textField[i].getText();
            }
        }
        return input;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SolveSudoku(readText());
    }
}
