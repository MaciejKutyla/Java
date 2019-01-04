import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {
    public static int Lav(String a, String b){
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        int wynik=costs[b.length()];
        return wynik;
    }
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");

        while ((userInput = stdIn.readLine()) != null) {
            if(userInput.equals("PASS")){
                File plik = new File("/Users/Maciek/IdeaProjects/Zad 9.2/src");
                LinkedList<String> has=new LinkedList<String>();
                Scanner odczyt = new Scanner(plik);
                String pierwszy = odczyt.nextLine();
                out.println("LOGIN szymon;"+pierwszy);
                String haslo;
                int e=Integer.parseInt(in.readLine());
                while (odczyt.hasNextLine()) {
                    haslo = odczyt.nextLine();
                    if(!haslo.equals(" ")){
                        if (Lav(haslo, pierwszy) == e) {
                            has.add(haslo);}
                    }}
                System.out.println(has);
                for(int i=0; i<has.size();i++) {
                    out.println("LOGIN szymon;" + has.get(i));
                    int e2 = 0;
                    String read=in.readLine();
                    if (!read.equals("Nie podałeś hasła")) {
                        e2 = Integer.parseInt(read);
                        if (e2 >= 100000000) {
                            System.out.println("HASŁO:" + has.get(i));
                            break;
                        }
                    }
                }

            }
            else if(!userInput.equals("PASS")){
                out.println(userInput);
                System.out.println("echo: " + in.readLine());

            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}