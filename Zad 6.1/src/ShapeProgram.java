import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

public class ShapeProgram extends java.awt.Frame {
    public ShapeProgram(){
        super("Shapes");}
    public static void main(String[] argv){
        LinkedList<Shape> list=new LinkedList<Shape>();
        list.add(new Triangle());
        list.add(new Square());
        list.add(new Circle());
        list.add(new Rectriangle());
        MyPanel mp=new MyPanel(list);
        ShapeProgram sp=new ShapeProgram();
        sp.setSize(1000,500);
        sp.setVisible(true);
        sp.add(mp);
        sp.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}