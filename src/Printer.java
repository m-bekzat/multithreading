import java.util.Stack;

public class Printer {
    private Stack<Integer> stack = new Stack<>();

    synchronized void add(int i) {
        stack.add(i);
    }

    synchronized void print() {
        while (stack.isEmpty()) {

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName() + " is printing: " + stack.pop());
        notify();
    }
}
