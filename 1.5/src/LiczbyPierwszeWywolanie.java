import java.io.*;

public class LiczbyPierwszeWywolanie {
    public static void main(String[] argv){
        int num;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            System.out.print("Wpisz liczbę: ");
            num = Integer.parseInt(bfr.readLine());
            LiczbyPierwsze.search(num);
        }
        catch(IOException e){e.printStackTrace();}
    }
} 