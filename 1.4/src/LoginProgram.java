/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            // TODO: prosba o wpisanie hasła i loginu
            String login = null;
            System.out.println("Wpisz jakis login: ");
            login = bfr.readLine();
            InputStreamReader rd2 = new InputStreamReader(System.in);
            BufferedReader bfr2 = new BufferedReader(rd2);
            String haslo = null;
            System.out.println("Wpisz jakies haslo: ");
            haslo = bfr2.readLine();

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
            log.check(login, haslo);
        }catch(IOException e){e.printStackTrace();}

    }
}
