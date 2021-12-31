import javax.swing.*;
import java.awt.*;

public class SolutionPanel extends JPanel {

    //dimensions of frame
    static final int WIDTH = 540;
    static final int HEIGHT = 540;

    //dimension of single box, in this case there are 81 boxes (540/9 = 60)
    static final int UNIT = 60;
    private GridLayout layout;
    private TextField[] textField = new TextField[81];
    private String output;

    public SolutionPanel(String output) {

        this.output = output;
        System.out.println(this.output);
        layout = new GridLayout(9,9);
        this.setLayout(layout);

        for(int i = 0; i < 81; i++){
            textField[i] = new TextField("" + output.charAt(i));
            textField[i].setPreferredSize(new Dimension(10, 10));
            this.add(textField[i]);
        }

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
