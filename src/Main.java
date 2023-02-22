public class Main {
    public static void main(String[] args) {
        int[] ap1 = {3, 6, 9, 15, 24};
        int[] ap2 = {5, 10, 15, 25, 40};

        Printer printer = new Printer();
        Thread threadOne = new Thread(new Producer(printer, ap1));
        Thread threadTwo = new Thread(new Producer(printer, ap2));

        threadOne.start();
        threadTwo.start();
    }
}
