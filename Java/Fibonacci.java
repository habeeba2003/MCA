import java.util.Scanner;

public class Fibonacci {
    public static void fibo(int n) {
        if (n <= 0) {
            System.out.println("Enter a positive number.");
            return;
        }

        int a = 0, b = 1;
        System.out.print("Fibonacci series: " + a); // Print first term without newline
        
        if (n > 1) {
            System.out.print(", " + b); // Print second term
        }

        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(", " + c); // Print remaining terms with a comma
            a = b;
            b = c;
        }
        System.out.println(); // Move to a new line after printing the series
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();
        fibo(n);
        sc.close();
    }
}
