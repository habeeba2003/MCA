import java.util.Scanner;

class FactorialThread extends Thread {
    private int number;
    private final Object lock;

    public FactorialThread(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }

        synchronized (lock) {
            System.out.println("Factorial of " + number + " is: " + fact);
            lock.notify(); // Notify ReverseThread that it can proceed
        }
    }
}

class ReverseThread extends Thread {
    private int number;
    private final Object lock;

    public ReverseThread(int number, Object lock) {
        this.number = number;import java.util.Scanner;

class FactorialThread extends Thread {
    private int number;
    private final Object lock;

    public FactorialThread(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }

        synchronized (lock) {
            System.out.println("Factorial of " + number + " is: " + fact);
            lock.notify(); // Notify ReverseThread that it can proceed
        }
    }
}

class ReverseThread extends Thread {
    private int number;
    private final Object lock;

    public ReverseThread(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait until FactorialThread completes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Reverse logic
        int reversed = 0, temp = number;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Reverse of " + number + " is: " + reversed);
    }
}

public class Mains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for factorial: ");
        int factNumber = scanner.nextInt();
        System.out.print("Enter a number to reverse: ");
        int reverseNumber = scanner.nextInt();
        scanner.close();

        Object lock = new Object();

        FactorialThread factorialThread = new FactorialThread(factNumber, lock);
        ReverseThread reverseThread = new ReverseThread(reverseNumber, lock);

        reverseThread.start(); // Start reverse thread first, so it waits
        factorialThread.start(); // Start factorial thread after
    }
}

        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait until FactorialThread completes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Reverse logic
        int reversed = 0, temp = number;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Reverse of " + number + " is: " + reversed);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for factorial: ");
        int factNumber = scanner.nextInt();
        System.out.print("Enter a number to reverse: ");
        int reverseNumber = scanner.nextInt();
        scanner.close();

        Object lock = new Object();

        FactorialThread factorialThread = new FactorialThread(factNumber, lock);
        ReverseThread reverseThread = new ReverseThread(reverseNumber, lock);

        reverseThread.start(); // Start reverse thread first, so it waits
        factorialThread.start(); // Start factorial thread after
    }
}
