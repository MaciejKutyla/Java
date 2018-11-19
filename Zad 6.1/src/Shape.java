import java.awt.event.MouseListener;

import java.awt.Graphics;

public abstract class Shape {
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



