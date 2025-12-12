    import java.util.Scanner;
    import java.io.*;

    public class StudentManagementSystem {

        
        static String[] studentNames = new String[250];
        static String[] studentIDs = new String[250];
        static int [] studentAges = new  int [250];
        static String[] semester = new String[250];
        static String[] emails = new String[250];
        static String[] studentAddresses = new String[250];
        static int studentCount = 0;

        static String [] courseNames = new String [100];
        static String [] courseIDs = new String [100];
        static int courseCount = 0;

        static int[][] enrollments = new int [250][100];


        public static void main(String[] args) {
            loadData();
            loadCourses();

            Scanner input = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n***************************");
                System.out.println("   STUDENT MANAGEMENT SYSTEM");
                System.out.println("***************************");
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
            Scanner input = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = input.next();
            System.out.print("Enter password: ");
            String password = input.next();

            if (!username.equals("Abubakar") || !password.equals("001")) {
                System.out.println("Invalid credentials! Please try again.");
                return;
            }

            System.out.println("Login successful!");

            int choice;
            do {
                System.out.println("\n===== ADMIN PORTAL =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. View Enrollments");
            System.out.println("7. Logout");
            System.out.println("--------------------------");

            System.out.println("Enter the choice :");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        addCourse();
                        break;
                    case 4:
                        viewCourses();
                        break;
                    case 5:
                        enrollStudent();
                        break;
                    case 6:
                        viewEnrollments();
                        break;
                    case 7:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 7);
        }

        public static void showStudentPortal() {
            System.out.println("\n****** STUDENT PORTAL ******");
            System.out.println("1. View Available Courses");
            System.out.println("2. View My Enrollments");
            System.out.println("3. Marks in each subject ");
            System.out.println("4. Cgpa");
            System.out.println("5. Logout");
            System.out.println("*************************");
        }

        public static void addStudent() {
            Scanner sc = new Scanner(System.in);

            if (studentCount >= 250) {
                System.out.println("Student limit reached!");
                return;
            }

            System.out.println("\n--- Add New Student ---");
            System.out.print("Enter Student Name: ");
            studentNames[studentCount] = sc.nextLine();

            System.out.print("Enter Student ID: ");
            studentIDs[studentCount] = sc.nextLine();

            System.out.print("Enter Student Age: ");
            studentAges[studentCount] = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Semester: ");
            semester[studentCount] = sc.nextLine();

            System.out.print("Enter Email: ");
            emails[studentCount] = sc.nextLine();

            System.out.print("Enter Address: ");
            studentAddresses[studentCount] = sc.nextLine();

            studentCount++;
            saveData();
            System.out.println("Student added successfully!");
        }

        public static void viewStudents() {
            if (studentCount == 0) {
                System.out.println("No students available.");
                return;
            }

            System.out.println("\n====== STUDENT LIST ======");
            for (int i = 0; i < studentCount; i++) {
                System.out.println("Student Name: " + studentNames[i]);
                System.out.println("Student ID: " + studentIDs[i]);
                System.out.println("Age: " + studentAges[i]);
                System.out.println("Semester: " + semester[i]);
                System.out.println("Email: " + emails[i]);
                System.out.println("Address: " + studentAddresses[i]);
                System.out.println("-------------------------");
            }
        }
        public static void saveData(){
            try{
                FileWriter writer = new FileWriter("students.txt");
                PrintWriter Pr = new PrintWriter(writer);
                Pr.println(studentCount);
                for(int i = 0; i<studentCount;i++){
                    Pr.println(studentNames[i]);
                    Pr.println(studentIDs[i]);
                    Pr.println(studentAges[i]);
                    Pr.println(semester[i]);
                    Pr.println(emails[i]);
                    Pr.println(studentAddresses[i]);

            }
                writer.close();
                Pr.close();

            }catch(IOException r){
                System.out.println("An error occured while saving data.");
            }
        }
        public static void loadData(){
            try{
                File f = new File("students.txt");
                if(!f.exists()){
                    return;
                }
                    Scanner sc = new Scanner(f);
                    studentCount = Integer.parseInt(sc.nextLine());
                    for(int i = 0 ; i < studentCount; i++){
                        studentNames[i] = sc.nextLine();
                        studentIDs[i] = sc.nextLine();
                        studentAges[i] = Integer.parseInt(sc.nextLine());;
                        semester[i] = sc.nextLine();
                        emails[i] = sc.nextLine();
                        studentAddresses[i] = sc.nextLine();

                    }
                    sc.close();

                }catch(IOException e){
                    System.out.println("An error occured while loading data.");
                }
            }


            public static void addCourse(){
            Scanner sc = new Scanner(System.in);

            if(courseCount >= 100){
                System.out.println("Course limit reached ");
                return;
            }
            System.out.println("Enter the course name:");
            courseNames[courseCount] = sc.nextLine();

            System.out.println("Enter course  ID :");
            courseIDs[courseCount] = sc.nextLine();

            courseCount ++;
            saveCourses();
            System.out.println("Course added successfully ! ");

                
            }
        
        public static void viewCourses(){
            if(courseCount == 0){
                System.out.println("No course available ");
                return;

            }
            System.out.println("=====course List =====");
            for(int i = 0 ; i < courseCount;i++){
                System.out.println("Course name : " + courseNames[i]);
                System.out.println("course ID : " + courseIDs[i]);
                System.out.println("---------------------");
                
            
              }
            }

            public static void saveCourses(){
            try{
                FileWriter file = new FileWriter("Courses.txt");
                PrintWriter pr = new PrintWriter (file);

                pr.println(courseCount);

                for(int i = 0 ; i < courseCount;i++){
                    pr.println(courseNames[i]);
                    pr.println(courseIDs[i]);
                }
                file.close();
                pr.close();

            }catch(IOException r){
                System.out.println("An errr occured while saving courses.");

             }
            }
            public static void loadCourses(){
             try{
                File f = new File ("Courses.txt");
                if(!f.exists()){
                    return;
                }
                Scanner sc = new Scanner(f);
                courseCount = Integer.parseInt(sc.nextLine());
                for(int i = 0 ; i < courseCount ; i++){
                    courseNames[i] = sc.nextLine();
                    courseIDs[i] = sc.nextLine();
                }
                sc.close();
            }catch(IOException e){
                    System.out.println("An error occured while loading courses.");
             }
            }
            
            public static void enrollStudent(){
                Scanner sc = new Scanner(System.in);

                if(studentCount == 0 || courseCount == 0){
                    System.out.println("No students or courses available for enrollemnets .");
                    return;
                }
                System.out.println("Enter Student ID to enroll:");
                String inputID = sc.nextLine();
                int studentIndex = -1;

                for(int i = 0 ; i < studentCount;i++){
                    if(inputID.equals(studentIDs[i])){
                        studentIndex = i;   
                        break;
                    }
                }
                if(studentIndex == -1){
                    System.out.println("Student not found .");
                    return;
                }
                System.out.println("\nAvailable Courses:");
                 for(int i = 0 ; i < courseCount;i++){
                    System.out.println((i+1) + "." + courseNames[i] + " (ID: " + courseIDs[i] + " )");
                 }
                   System.out.println("Enter the number of the course to enroll in:");
                 int choice = sc.nextInt() -1;

                 if(choice < 0 || choice >= courseCount){
                    System.out.println("Invalid course details ");
                    return;
                 }
                 try{
                    FileWriter file = new FileWriter ("Enrollments.txt", true);
                    PrintWriter pr = new  PrintWriter (file);
                    pr.println(studentIDs[studentIndex ]  + " Enrolled in " + courseNames[choice]  + " Successfully");

                    pr.close();
                    System.out.println("Enrollement successful :" + studentNames[studentIndex] + "Enrolled in " + courseNames[choice]);

                 }catch(IOException e){
                    System.out.println("An error occured while saving enrollement.");
                 }
            }

            public static void viewEnrollments(){
                try{
                    File f = new File ("Enrollments.txt");

                    if(!f.exists()){
                        System.out.println("No enrollements found .");
                        return;

                    }
                    Scanner sc = new Scanner (f);
                    System.out.println("\n----ENROLLMENT LIST ----");

                    while(sc.hasNextLine()){
                        String line = sc.nextLine ();
                        System.out.println(line);
                    }
                    sc.close();  
                }catch(IOException e){
                    System.out.println("File is not found " );
                }
            }
        }



