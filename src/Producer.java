import java.util.Random;

public class Producer implements Runnable {

    private Printer print;
    private int[] ap;
    private static final int MAX = 5;
    private static final int MIN = 1;

    public Producer(Printer print, int[] ap) {
        this.print = print;
        this.ap = ap;
    }

    @Override
    public void run() {
        for (int i : ap) {
            int millis = new Random().nextInt((MAX - MIN) + 1) + MIN;

            try {
                System.out.println(Thread.currentThread().getName() + " fall asleep for " + millis + " seconds");
                Thread.sleep(millis * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            print.add(i);
            print.print();
        }
    }
}
