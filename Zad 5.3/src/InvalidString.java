public class InvalidString extends Exception {
    private int sw;
    public InvalidString(int sw){
        this.sw =sw;
    }
    public void printException(){
        if(sw ==0){
            System.out.println("Napisy kończą się przed początkiem");
        }
        else if(sw ==1){
            System.out.println("Napisy nie pasują");
        }
    }
}