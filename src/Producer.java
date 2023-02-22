import java.util.Random;

public class Producer implements Runnable {

    private Printer print;
    private int number;
    private int step;
    private static final int MAX = 5;
    private static final int MIN = 1;

    public Producer(Printer print, int number, int step) {
        this.print = print;
        this.number = number;
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {

            int millis = new Random().nextInt((MAX - MIN) + 1) + MIN;

            try {
                System.out.println(Thread.currentThread().getName() + " fall asleep for " + millis + " seconds");
                Thread.sleep(millis * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            print.add(number);
            print.print();

            number = number + step;
        }
    }
}
