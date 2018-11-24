import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class DrawHistogram extends JPanel {
    private static int RX = 10;
    private static int RY = 300;
    private static int RW = 45;
    private static int RH[];
    private static final int RECT_SPACE = RW + 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int counter = 1;
        for (int i = 0; i< RH.length; i++){

            g.drawRect(RX + RECT_SPACE * counter, RY - RH[i], RW, RH[i]);
            counter ++;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(RH.length * 80, 400);
    }

    public static void createAndShowGui(int rect_height[]) {
        RH = rect_height;

        DrawHistogram mainPanel = new DrawHistogram();

        JFrame window = new JFrame("DrawHistogram");
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        window.getContentPane().add(mainPanel);
        window.pack();
        window.setLocationByPlatform(true);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
}