import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    private static LinkedList<Punkt3D> punkty;

    public static void main(String[] argv) throws IOException {

        System.out.println("1. Wczytaj punkt 3D");
        System.out.println("2. Wyświetl wszystkie punkty");
        System.out.println("3. Oblicz odległość");
        System.out.println("4. Zakończ");

        int i = 0;
        while (i > 1 || i < 4) {
            Scanner odczyt = new Scanner(System.in);
            i = odczyt.nextInt();

                if (i==1) {
                    System.out.println("Podaj x nowego punktu");
                    double _x;
                    _x = odczyt.nextInt();

                    System.out.println("Podaj y nowego punktu");
                    double _y;

                    _y = odczyt.nextInt();

                    System.out.println("Podaj z nowego punktu");
                    double _z;

                    _z = odczyt.nextInt();

                    Punkt3D punkt = new Punkt3D(_x, _y, _z);
                    if(punkty!=null){
                        punkty.add(punkt);}
                    else{
                        punkty = new LinkedList<Punkt3D>();
                        punkty.addFirst(punkt);
                    }
                }
                if (i==2){
                    if (punkty != null) {
                        for (int j = 0; j < punkty.size(); j++) {
                            Punkt3D p = punkty.get(j);
                            System.out.println("[" + p.getX() + ", " + p.getY() + ", " + p.getZ() + "]");
                        }
                    } else {
                        System.out.println("Punkty nie istnieja");
                    }
                }

                if (i==3)  {
                    int x1, x2, y1, y2, z1, z2;
                    System.out.println("Podaj współrzędne pierwszego punktu");
                    x1 = odczyt.nextInt();
                    y1 = odczyt.nextInt();
                    z1 = odczyt.nextInt();
                    System.out.println("Podaj współrzędne drugiego punktu");
                    x2 = odczyt.nextInt();
                    y2 = odczyt.nextInt();
                    z2 = odczyt.nextInt();
                    Punkt3D p3 = new Punkt3D(x1, y1, z1);
                    Punkt3D p4 = new Punkt3D(x2, y2, z2);
                    System.out.println(p3.distance(p4));
                }
                if (i==4) {
                    System.exit(0);
                }
                else {
                    System.out.println("1. Wczytaj punkt 3D");
                    System.out.println("2. Wyświetl wszystkie punkty");
                    System.out.println("3. Oblicz odległość");
                    System.out.println("4. Zakończ");
                }
            }

        }
    }
