import java.util.Scanner;
public class Multiplication {
    public void printMul(int n) { 
        for (int j = 1; j <= 10; j++) {
            System.out.println(n + " * " + j + " = " + (n * j));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        Multiplication obj = new Multiplication();
        obj.printMul(n);
        sc.close(); 
    }
}
