import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {
    public static void delay(const String in, const String out,int delay, int fps) throws Delay, InvalidString {
        Subtitles work = new Subtitles(in);
        int adder=delay*fps;
        if((work.getFirst()-adder)<0){
            throw new Delay();
        }
        else{
            work.setFirst(work.getFirst()-adder);
            work.setSecond(work.getSecond()-adder);
            work.setSub("{"+work.getFirst()+"}"+"{"+work.getSecond()+"}");
            out=work.getSub();
            for(int i=work.getSub().length(); i<in.length();i++){
                out+=in.charAt(i);
            }
        }
    }

    public static void speed(const String in,const String out, int delay, int fps) throws Delay, InvalidString {
        Subtitles work = new Subtitles(in);
        int adder = delay * fps;
        work.setFirst(work.getFirst() + adder);
        work.setSecond(work.getSecond() + adder);
        work.setSub("{" + work.getFirst() + "}" + "{" + work.getSecond() + "}");
        out = work.getSub();
        for (int i = work.getSub().length(); i < in.length(); i++) {
            out += in.charAt(i);
        }
    }




    public static void main(String[] argv) throws Delay, InvalidString, FileNotFoundException {
        try {
            String out = "";
            File file = new File("C:\\Users\\Maciek\\IdeaProjects\\Zad 5.3\\src\\gravity.txt");
            Scanner odczyt = new Scanner(file);
            String reader = odczyt.nextLine();
            try {
                while (odczyt.hasNext()) {
                    speed(reader, out, 10, 30);
                    reader = odczyt.nextLine();
                    System.out.println(out);
                    out = "";
                }
            } catch (Delay | InvalidString e) {
                throw e;
            }
        }
        catch (FileNotFoundException e){
            throw e;
        }

    }
}