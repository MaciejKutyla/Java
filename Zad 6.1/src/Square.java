import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Square extends Shape{
    public Square(){
        setX1(40);
        setY1(20);
    }
    @Override
    public void draw(){
        System.out.print("***\n"+"***\n"+"***\n");
    }
    @Override
    public void draw(Graphics g) {
        Rectangle2D s = new Rectangle2D.Double(getX1(),getY1(),200,200);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.green);
        g2.fill(s);
        g2.draw(s);
    }
}