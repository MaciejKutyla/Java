package excp;

public class TooBigNumberException extends Exception {
    public TooBigNumberException(int x){
        System.out.println("Podane x jest za duze");
        System.out.println("Podaj mniej niz" + x);
    }
}
