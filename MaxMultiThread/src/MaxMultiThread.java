public class MaxMultiThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyThread());
        GenerateRandoms a = new GenerateRandoms();
        a.fill();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for( int i=0; i<10; i++ )
            System.out.println("Nowy wątek!");
    }

}