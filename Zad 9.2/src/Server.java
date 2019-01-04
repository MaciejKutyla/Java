import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static LinkedList<Integer> zalogowani=new LinkedList<Integer>();

    public static void main(String[] args) throws IOException, FileNotFoundException {
        ServerSocket serverSocket = null;
        short port=6666;
        try {
            serverSocket = new ServerSocket(6666);
            ExecutorService services = Executors.newFixedThreadPool(2);
            while(true) {
                Socket s = serverSocket.accept();
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                services.submit(new SockReader(s));
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }

        clientSocket.close();
        serverSocket.close();

    }
}

class SockReader implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;


    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input,OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }
    public void run() {
        msg("serving new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {
            String line = in.nextLine();
            msg(line);
            String[] parts = line.split("\\s+");
            if (parts[0].equals("LOGIN") && parts.length==2) {
                String logpas = parts[1];
                String[] parts2=logpas.split(";");
                if(parts2.length==2) {
                    String part1 = parts2[0]; 
                    String part2 = parts2[1];
                    if (part1.equals("szymon") && part2.equals("zzuwszy")) {
                        if (Server.zalogowani.isEmpty()) {
                            Server.zalogowani.addFirst(1000000000);
                        } else {
                            Server.zalogowani.add(Server.zalogowani.getLast() + 1);
                        }
                        out.println(Server.zalogowani.getLast());
                    } else if (!part1.equals("szymon")) {
                        out.println("Niepoprawny login");
                    } else if (!part2.equals("zzuwszy")) {
                        String a = part2.toLowerCase();
                        String b = "zzuwszy";
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
                        out.println(costs[b.length()]);

                    }
                }
                else if(parts2.length==1){
                    out.println("Nie podałeś hasła");
                }

            }
            if (parts[0].equals("LOGOUT") && parts.length==2) {
                int t=0;
                if(parts[1].matches("-?\\d+")) {
                    if (parts[1].matches("-?\\d+")) {
                        for (Integer i : Server.zalogowani) {
                            if (i.equals(Integer.parseInt(parts[1]))) {
                                t = 1;
                                Server.zalogowani.remove(i);
                                out.println("true");
                            }
                        }
                    }
                }
                if (t == 0) {
                    out.println("false");
                }
            }
            if(parts[0].equals("LS") && parts.length==2){
                int t=0;
                String pliki = "";
                if(parts[1].matches("-?\\d+")){
                    for (Integer i : Server.zalogowani) {
                        if (i.equals(Integer.parseInt(parts[1]))) {
                            t = 1;
                            File directory = new File("/Users/Maciek/");
                            File[] contents = directory.listFiles();
                            Pattern compiledPattern = Pattern.compile(".+\\.txt");
                            Matcher matcher;
                            for (File f : contents) {
                                matcher = compiledPattern.matcher(f.toString());
                                if (matcher.find()) {
                                    pliki = pliki + f.getName() + " ";
                                }
                            }
                            out.println(pliki);
                        }
                    }
                }
                if (t == 0) {
                    out.println("false");
                }
            }
            if(parts[0].equals("GET") && parts.length==3) {
                int t = 0;
                if(parts[1].matches("-?\\d+")) {
                    for (Integer i : Server.zalogowani) {
                        if (i.equals(Integer.parseInt(parts[1]))) {
                            File directory = new File("/Users/Maciek/");
                            File[] contents = directory.listFiles();
                            for (File f : contents) {
                                if (f.getName().equals(parts[2])) {
                                    t = 1;
                                    File file = new File("/Users/Maciek/" + parts[2]);
                                    try {
                                        Scanner odczyt = new Scanner(file);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    Scanner wpis = null;
                                    try {
                                        wpis = new Scanner(file);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    String zdanie = wpis.nextLine();
                                    out.println(zdanie);
                                }
                            }


                        }
                    }
                }
                if (t == 0) {
                    out.println("false");
                }
            }
            else if((parts[0].equals("GET") && parts.length!=3) || (parts[0].equals("LS") && parts.length !=2) || (parts[0].equals("LOGOUT") && parts.length!=2) || (parts[0].equals("LOGIN") && parts.length!=2)  || (!parts[0].equals("LOGOUT") && !parts[0].equals("LS") && !parts[0].equals("GET") && !parts[0].equals("LOGIN")) ){
                out.println("Niepoprawna komenda");
            }

        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }


}