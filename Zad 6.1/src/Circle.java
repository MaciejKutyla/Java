import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    public Circle(){
        setX1(250);
        setY1(250);
    }
    @Override
    public void draw(){
        System.out.print("  *  \n"+" *** \n"+"  *  \n");
    }
    public void draw(Graphics g) {
        Ellipse2D c = new Ellipse2D.Double(getX1(),getY1(),200,200);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.fill(c);
        g2.draw(c);
    }
}