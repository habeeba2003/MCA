import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int rollNo;
    String name;
    int marks;
    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    public void display(int rank) {
        System.out.println("Rank " + rank + ": Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks);
    }
}

public class RankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Marks: ");
            int marks = scanner.nextInt();
            scanner.nextLine(); 
            students.add(new Student(rollNo, name, marks));
        }
        Collections.sort(students, Comparator.comparingInt(s -> -s.marks));

        // Displaying Rank List
        System.out.println("\n--- Rank List (Sorted by Marks) ---");
        int rank = 1;
        for (Student student : students) {
            student.display(rank);
            rank++;
        }

        scanner.close();
    }
}
