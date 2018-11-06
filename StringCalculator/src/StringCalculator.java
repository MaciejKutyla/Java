package  appl;

import excp.NothingToSubstractFromException;
import excp.TooBigNumberException;
import excp.BadInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StringCalculator extends appl.Calculator {
    private String result;

    public StringCalculator(){
        result = null;
    }

    public StringCalculator(String _result) {
        result = _result;
    }

    public static void main(String [] argv){
        StringCalculator m = new StringCalculator("Testowaniejakiestamtest");
        m.Subtract("test");
        System.out.print(m.result);
    }

    @Override
    public abstract  void SaveToFile(String x, String filename) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.print(x);
        pw.close();
    }

    @Override
    public abstract  String Add(String x){
        result = new StringBuilder(x).append(result).toString();
        return result;

    }

    @Override
    public abstract  void Subtract(String x){
        if(result.isEmpty()){
            throw new NothingToSubstractFromException();
        }
        if(!result.contains(x)){
            throw
        }
        result = result.replace(x, "");

    }

    @Override
    public abstract void Multiply(int x){
        if(x>5){
            throw new TooBigNumberException(x);
        }
        String np = result;
        int i;
        for(i=0; i<x; i++){
            result+=np;
    }
}
