import java.util.ArrayList;
import java.util.Scanner;

public class StudentApplication {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> searchStudent(sc);
                case 4 -> generateReport();
                case 5 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine();

        Student s = new Student(name, age, id, marks);
        students.add(s);
        System.out.println("Student added!\n");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println("----------------------------");
                System.out.println(s);
            }
        }
    }

    private static void searchStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Student found:");
                System.out.println(s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void generateReport() {
        System.out.println("\n===== STUDENT REPORT =====");
        if (students.isEmpty()) {
            System.out.println("No students to show.");
        } else {
            for (Student s : students) {
                System.out.println("----------------------------");
                System.out.println(s);
            }
        }
    }
}
