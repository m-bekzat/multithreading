public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread threadOne = new Thread(new Producer(printer, 3, 3));
        threadOne.setName("Producer 1");

        Thread threadTwo = new Thread(new Producer(printer, 5, 5));
        threadTwo.setName("Producer 2");

        threadOne.start();
        threadTwo.start();
    }
}
