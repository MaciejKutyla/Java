import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Triangle extends Shape{
    public Triangle(){
        setX1(110);
        setY1(300);
    }
    @Override
    public void draw() {
        System.out.print("   *   \n"+"  ***  \n"+" ***** \n"+"*******\n");
    }
    public void draw(Graphics g) {
        Polygon t = new Polygon(new int[] {getX1()-100, +getX1(), getX1()+100}, new int[] {getY1()+100, getY1(), getY1()+100}, 3);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fill(t);
        g2.draw(t);
    }
}