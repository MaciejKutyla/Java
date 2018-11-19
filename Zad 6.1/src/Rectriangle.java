import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectriangle extends Shape {

    public Rectriangle(){
        setX1(550);
        setY1(50);
    }
    @Override
    public void draw(){
        System.out.print("***\n"+"* *\n"+"***\n");
    }
    @Override
    public void draw(Graphics g) {
        Rectangle2D r = new Rectangle2D.Double(getX1(),getY1(),300,200);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.cyan);
        g2.fill(r);
        g2.draw(r);
    }
}