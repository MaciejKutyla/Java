import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] argv) throws IOException {
        Polibiusz pol=new Polibiusz();
        ROT11 rot=new ROT11();
        Cryptographer crypt=new Cryptographer();
        System.out.print("1.Zaszyfrować Polibiuszem\n2.Zaszyfrować Rot11\n3.Odszyfrować Polibiuszem\n4.Odszyfrować Rot11\n");
        Scanner odczyt = new Scanner(System.in);
        int i = odczyt.nextInt();
        System.out.print("Podaj ścieżkę do pliku wejściowego\n");
        Scanner odczyt2 = new Scanner(System.in);
        String we = odczyt2.nextLine();
        File wejscie=new File(we);
        System.out.print("Podaj ścieżkę do pliku wyjściowego\n");
        Scanner odczyt3 = new Scanner(System.in);
        String wy = odczyt3.nextLine();
        File wyjscie=new File(wy);

        int switcher;
        switch (i){
            case 1:
                crypt.cryptfile(wejscie, wyjscie, pol);
                break;
            case 2:
                crypt.cryptfile(wejscie, wyjscie, rot);
                break;
            case 3:
                crypt.decryptfile(wejscie, wyjscie, pol);
                break;
            case 4:
                crypt.decryptfile(wejscie, wyjscie, rot);
                break;
            default:
                System.out.print("Wystąpił błąd");
        }
    }
}