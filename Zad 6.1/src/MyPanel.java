import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.awt.event.*;


public class MyPanel extends java.awt.Panel implements MouseMotionListener, MouseListener   {
    private LinkedList<Shape> lista;
    static final int WIDTH = 800, HEIGHT = 500;
    Shape moving;
    public MyPanel(LinkedList<Shape> lista){
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.lista=lista;
    }
    @Override
    public void paint(Graphics g1){
        for(Shape n:lista){
            n.draw(g1);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();

        int x2, y2;
        int index = 0;
        int size = lista.size();
        Shape p;

        while (moving == null && index < size) {
            p = lista.get(index);
            x2 = p.getX1();
            y2 = p.getY1();
            if (x1>x2&&x1<(x2+200)&&y1>y2&&y1<(y2+200)) {
                moving = p;
            }
            index++;
        }
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    public void mouseReleased(MouseEvent e){
        moving = null;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (moving != null) {
            moving.setX1(mouseEvent.getX());
            moving.setY1(mouseEvent.getY());
        }

        repaint();
    }
    public void mouseMoved(MouseEvent e){ }
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        LinkedList<Shape> list=new LinkedList<Shape>();
        list.add(new Triangle());
        list.add(new Square());
        list.add(new Circle());
        f.setContentPane(new MyPanel(list));
        f.setSize(800,375);
        f.setVisible(true);

    }
}

