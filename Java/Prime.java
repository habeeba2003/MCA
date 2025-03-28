import java.util.Scanner;
public class Prime {
    public void prime(int n) {
        if (n <= 1) {
            System.out.println(n + " is not a prime number");
            return;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) { 
                System.out.println(n + " is not a prime number");
                return;
            }
        }
        System.out.println(n + " is a prime number");
    }
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        Prime pr = new Prime();
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        pr.prime(n); 
        sc.close();
    }
}
