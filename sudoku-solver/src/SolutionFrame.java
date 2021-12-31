import javax.swing.*;

public class SolutionFrame extends JFrame {
    public SolutionFrame(String output){
        this.add(new SolutionPanel(output));
        this.setTitle("SOLUTION");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
