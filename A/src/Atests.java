public class Atests {

    public static boolean test1(){
        A aaa=new A();
        String res = aaa.met(1);
        if (res.equals("pierwszy")){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean test2(){
        A aaa=new A();
        String res = aaa.met(2);
        if (res.equals("drugi")){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean test3(){
        A aaa=new A();
        String res = aaa.met(3);
        if (res.equals("inny")){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args){
        if(test1()){
            System.out.print("OK");
        }

        if(test2()){
            System.out.print("OK");
        }

        if(test3()){
            System.out.print("OK");
        }
    }
}