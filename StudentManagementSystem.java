import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n***************************");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("******************************");
            System.out.println("1. Admin Portal");
            System.out.println("2. Student Portal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    showAdminPortal();
                    break;
                case 2:
                    showStudentPortal();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
        input.close();
    }

    public static void showAdminPortal() {
        System.out.println("\n===== ADMIN PORTAL =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Add Course");
        System.out.println("4. View Courses");
        System.out.println("5. Enroll Student");
        System.out.println("6. View Enrollments");
        System.out.println("7. Logout");
        System.out.println("--------------------------");
    }

    public static void showStudentPortal() {
        System.out.println("\n****** STUDENT PORTAL ******");
        System.out.println("1. View Available Courses");
        System.out.println("2. View My Enrollments");
        System.out.println("3. Marks");
        System.out.println("4. Cgpa");
        System.out.println("5. Logout");
        System.out.println("*************************");
    }
}