import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosophers {

    static int p_number = 5;
    static Philosopher philosophers[] = new Philosopher[p_number];
    static Fork forks[] = new Fork[p_number];

    static class Philosopher extends Thread {

        public int num;
        public Fork l_f, r_f;

        Philosopher(int num, Fork left, Fork right) {
            this.num = num;
            l_f = left;
            r_f = right;
        }

        public void run(){

            while (true) {
                l_f.grab();
                r_f.grab();
                eat();
                l_f.release();
                r_f.release();
            }
        }

        void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                Thread.sleep(sleepTime);
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

    }

    static class Fork {

        public Semaphore mutex = new Semaphore(1);

        void grab() {
            try {
                mutex.acquire();
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        void release() {
            mutex.release();
        }

        boolean isFree() {
            return mutex.availablePermits() > 0;
        }

    }
    public static void main(String argv[]) {
        for (int i = 0; i < p_number; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < p_number; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % p_number]);
            philosophers[i].start();
        }

        while (true) {
            try {
                Thread.sleep(1000);
                boolean deadlock = true;
                for (Fork f : forks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Koniec");
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.exit(0);
    }

}