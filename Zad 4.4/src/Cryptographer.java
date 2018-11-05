import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File in, File out, Algorithm algo) throws IOException {

        FileReader fr = null;
        String linia;
        FileWriter fw = new FileWriter(out);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            fr = new FileReader(in);
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);

        try {
            while((linia = bfr.readLine()) != null){
                bw.write(algo.crypt(linia));
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

    }
    public static void decryptfile(File in, File out, Algorithm algo) throws IOException {
        FileReader fr = null;
        String linia;
        FileWriter fw = new FileWriter(out);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            fr = new FileReader(in);
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);

        try {
            while((linia = bfr.readLine()) != null){
                bw.write(algo.decrypt(linia));
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

    }
}