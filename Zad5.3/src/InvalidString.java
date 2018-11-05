
public class InvalidString extends Exception {
    private int which;
    public InvalidString(int _switcher){
        which =_switcher;
    }
    public void printException(){
        if(which ==0){
            System.out.println("Napisy kończą się przed ich rozpoczęciem");
        }
        else if(which ==1){
            System.out.println("Tekst nie pasuje");
        }
    }
}