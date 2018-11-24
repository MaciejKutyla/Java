import javax.swing.*;
import java.awt.event.*;


public class Histogram extends JFrame{
    private JButton b1;
    private JPanel panel;
    private JSpinner s1;
    private JSpinner s2;
    private JSpinner s3;
    private JSpinner s4;
    private JSpinner s5;
    private SpinnerNumberModel spinnerModel;
    private SpinnerNumberModel spinnerMode2;
    private SpinnerNumberModel spinnerMode3;
    private SpinnerNumberModel spinnerMode4;
    private SpinnerNumberModel spinnerMode5;

    public static void main(String arg[]){
        new Histogram();
    }

    public Histogram(){
        this. setSize(500,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Histogram");

        this.panel = new JPanel();
        b1 = new JButton("Stwórz histogram");

        ListenForButton listenForButton = new ListenForButton();
        b1.addActionListener(listenForButton);

        panel.add(b1);



        spinnerModel = new SpinnerNumberModel(50, 0, 300, 20);
        spinnerMode2 = new SpinnerNumberModel(50, 0, 300, 20);
        spinnerMode3 = new SpinnerNumberModel(50, 0, 300, 20);
        spinnerMode4 = new SpinnerNumberModel(50, 0, 300, 20);
        spinnerMode5 = new SpinnerNumberModel(50, 0, 300, 20);

        s1 = new JSpinner(spinnerModel);
        s2 = new JSpinner(spinnerMode2);
        s3 = new JSpinner(spinnerMode3);
        s4 = new JSpinner(spinnerMode4);
        s5 = new JSpinner(spinnerMode5);

        panel.add(s1);
        panel.add(s2);
        panel.add(s3);
        panel.add(s4);
        panel.add(s5);


        this.add(panel);
        
        this.setLocationByPlatform(true);

        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1){
                try {
                    s1.commitEdit();
                } catch ( Exception l ) { }


                int values[] = {(int) s1.getValue(), (int) s2.getValue(), (int) s3.getValue(), (int) s4.getValue(), (int) s5.getValue()};
                DrawHistogram.createAndShowGui(values);
            }
        }
    }

}