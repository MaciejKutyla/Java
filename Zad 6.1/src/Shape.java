import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;

public abstract class Shape extends MouseAdapter implements MouseListener, MouseMotionListener {
    private int x;
    private int y;
    public String name;

    public void setX1(int x) {
        this.x = x;
    }

    public void setY1(int y) {
        this.y = y;
    }
    
    public int getX1() {
        return x;
    }

    public int getY1() {
        return y;
    }

    public abstract void draw();
    public abstract void draw(Graphics g);
    
}



