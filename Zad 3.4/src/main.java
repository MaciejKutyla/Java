import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] argv) {

        LinkedList<Shape> lista = new LinkedList<Shape>();


        int i=0;
        while(i<6 || i>0){
            System.out.print("1.Dodaj koło\n2.Dodaj trójkąt\n3.Dodaj kwadrat\n4.Dodaj prostokąt\n5.Wypisz\n6.Zakończ\n");
            Scanner odczyt1 = new Scanner(System.in);
            i = odczyt1.nextInt();
            if(i==1){
                System.out.print("Podaj nazwę");
                String new_c;
                Scanner odczyt = new Scanner(System.in);
                new_c = odczyt.nextLine();
                Circle c = new Circle();
                c.name=new_c;
                lista.add(c);
            }
            if(i==2){
                System.out.print("Podaj nazwę");
                String new_t;
                Scanner odczyt = new Scanner(System.in);
                new_t = odczyt.nextLine();
                Triangle t = new Triangle();
                t.name=new_t;
                lista.add(t);
            }

            if(i==3){
                System.out.print("Podaj nazwę");
                String new_s;
                Scanner odczyt = new Scanner(System.in);
                new_s = odczyt.nextLine();
                Square s = new Square();
                s.name=new_s;
                lista.add(s);
            }
            if(i==4){
                System.out.println("Podaj nazwe");
                String rec;
                Scanner odczyt = new Scanner(System.in);
                rec = odczyt.nextLine();
                Rectriangle r = new Rectriangle();
                r.name=rec;
                lista.add(r);

            }
            if(i==5){
                Collections.sort(lista, new Comparator<Shape>() {
                    @Override
                    public int compare(Shape shape, Shape t1) {
                        if (shape.name.charAt(0) > t1.name.charAt(0)) {
                            return 1;
                        } else if (shape.name.charAt(0) < t1.name.charAt(0)) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }});
                for(Shape n:lista){
                    n.draw();
                }
            }
            if(i==6){
                System.exit(0);
            }
        }
    }
}