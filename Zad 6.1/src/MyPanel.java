import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends java.awt.Panel  {
    private LinkedList<Shape> lista;
    static final int WIDTH = 800, HEIGHT = 500;
    public MyPanel(LinkedList<Shape> lista){
        this.lista=lista;
    }
    @Override
    public void paint(Graphics g1){
        for(Shape n:lista){
            n.draw(g1);
        }
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        LinkedList<Shape> list=new LinkedList<Shape>();
        list.add(new Triangle());
        list.add(new Square());
        list.add(new Circle());
        list.add(new Rectriangle());
        f.setContentPane(new MyPanel(list));
        f.setSize(800,375);
        f.setVisible(true);

    }

}