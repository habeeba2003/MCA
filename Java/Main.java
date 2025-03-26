class Publisher {
    String publisherName;
    String publisherAddress;

    public Publisher(String name, String address) {
        this.publisherName = name;
        this.publisherAddress = address;
    }

    public void displayPublisher() {
        System.out.println("Publisher Name: " + publisherName);
        System.out.println("Publisher Address: " + publisherAddress);
    }
}

class Book extends Publisher {
    String bookTitle;
    String author;
    double price;

    public Book(String title, String author, double price, String pubName, String pubAddress) {
        super(pubName, pubAddress);
        this.bookTitle = title;
        this.author = author;
        this.price = price;
    }

    public void displayBook() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        displayPublisher();
    }
}

class Department {
    String deptName;
    int deptId;

    public Department(String name, int id) {
        this.deptName = name;
        this.deptId = id;
    }

    public void displayDepartment() {
        System.out.println("Department Name: " + deptName);
        System.out.println("Department ID: " + deptId);
    }
}

class Employee extends Department {
    String empName;
    int empId;
    double salary;

    public Employee(String empName, int empId, double salary, String deptName, int deptId) {
        super(deptName, deptId);
        this.empName = empName;
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
        displayDepartment();
    }
}

class BookThread extends Thread {
    private Book book;

    public BookThread(Book book) {
        this.book = book;
    }

    public void run() {
        book.displayBook();
    }
}

class EmployeeThread extends Thread {
    private Employee employee;

    public EmployeeThread(Employee employee) {
        this.employee = employee;
    }

    public void run() {
        employee.displayEmployee();
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating Book and Employee objects
        Book book1 = new Book("Java Programming", "James Gosling", 45.99, "Tech Books", "New York");
        Employee emp1 = new Employee("Alice Johnson", 101, 60000, "IT Department", 5);

        BookThread bookThread = new BookThread(book1);
        EmployeeThread empThread = new EmployeeThread(emp1);

        bookThread.start();
        try {
            bookThread.join(); // Ensures book details print before employee details
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        empThread.start();
    }
}
