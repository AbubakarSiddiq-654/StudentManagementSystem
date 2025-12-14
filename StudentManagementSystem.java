     import java.util.Scanner;
    import java.io.*;

    public class StudentManagementSystem {
    
        static Scanner sc = new Scanner(System.in);
        
        static String[] studentNames = new String[250];
        static String[] studentIDs = new String[250];
        static int [] studentAges = new  int [250];
        static String[] semester = new String[250];
        static String[] department = new String [250];
        static String [] program = new String [250];
        static String[] emails = new String[250];
        static String[] studentAddresses = new String[250];
        static int studentCount = 0;

        static String [] courseNames = new String [100];
        static String [] courseIDs = new String [100];
        static int courseCount = 0;

        static int[][] enrollments = new int [250][100];

        static String [] subjects = {"ICT", "Programming Fundamentals", "Islamic studies", "English", "Sociology", "Mathematics"};
        static  int subjectCount = subjects.length;

        static int [][] marks = new  int [250][subjectCount];
        static String [] studentPasswords = new String [250];


        public static void main(String[] args) {
            loadData();
            loadCourses();
            loadMarks();
               int choice = -1;

            do {
                System.out.println("\n***************************");
                System.out.println("   STUDENT MANAGEMENT SYSTEM");
                System.out.println("***************************");
                System.out.println("1. Admin Portal");
                System.out.println("2. Student Portal");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                
                if(sc.hasNextInt()){
                    choice  = sc.nextInt();
                }else{
                    System.out.println("Invalid input ! please enter a number .");
                    sc.nextLine();
                    continue;
                }
                
             
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

        }

        public static void showAdminPortal() {
           
            System.out.println("Login to continue :");
            System.out.print("Enter username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String password = sc.next();

            if (!username.equals("Abubakar") || !password.equals("001")) {
                System.out.println("Invalid credentials! Please try again.");
                return;
            }

            System.out.println("Login successful!");

            int choice = -1;
            do {
                System.out.println("\n===== ADMIN PORTAL =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student");
             System.out.println("6. Search Student");
            System.out.println("7 .update student ");
            System.out.println("8. Enter marks");
            System.out.println("9. View Enrollments");         
            System.out.println("10. Logout");
            System.out.println("--------------------------");
            System.out.println("Enter the choice :");
            
              if(sc.hasNextInt()){
                choice = sc.nextInt();
              }else{
                System.out.println("Invalid input ! please enter a number .");
                sc.nextLine();
                continue;

              }
              
                sc.nextLine();

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
                        searchStudent();
                        break;
                    case 7:
                        updateStudent();
                        break;
                    case 8:
                        enterMarks();
                        break;
                    case 9:
                        viewEnrollments();
                        break;
                    case 10:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 10);
        }

        public static void showStudentPortal() {

            System.out.println("Login to continue :");
            sc.nextLine();

             System.out.print("Enter Student ID:");
             String id = sc.nextLine();

             System.out.print("Enter password :");
             String password = sc.nextLine();

             int studentIndex = -1;
              for( int i = 0 ;i < studentCount ; i++){
                if(id.equals(studentIDs[i]) && password.equals (studentPasswords[i])){
                    studentIndex = i;
                    break;
                }
              }

                if(studentIndex == -1){
                    System.out.println("Invalid credentials ! please try again");
                    return;
                }
                System.out.println("Login successful! welcome " + studentNames[studentIndex]);
               int choice = -1;
         do{

            System.out.println("\n****** STUDENT PORTAL ******");
            System.out.println("1. View Available Courses");
            System.out.println("2. View My Enrollments");
            System.out.println("3. Marks in each subject ");
            System.out.println("4. Cgpa");
            System.out.println("5. View my profile");
            System.out.println("6. Logout");
            System.out.println("*************************");
            
            if(sc.hasNextInt()){
            choice = sc.nextInt();
            sc.nextLine();
           } else {
            System.out.println("Invalid input! Enter a number.");
           sc.nextLine();
             continue; 
           }

            switch(choice){
                case 1:

                    viewCourses();
                    break;

                 case 2:
                    viewMyEnrollments(studentIDs[studentIndex]);
                    break;

                case 3:

                    System.out.println("Marks in Each subject:");
                    for(int i = 0 ; i < subjectCount ; i++){
                        System.out.println(subjects[i] + " : " + marks[studentIndex][i]);
                    }
                    break;
                case 4:

                     double totalMarks = 0;
                     for(int i = 0; i < subjectCount; i++){
                     totalMarks += marks[studentIndex][i];
                     }
                  double cgpa = (totalMarks / (subjectCount * 100)) * 4.0; 
                    System.out.printf("CGPA: %.2f\n", cgpa);
                    break;

               case 5:
                    System.out.println("\n--- My profile ---");
                    System.out.println("Student Name : " + studentNames[studentIndex]);
                    System.out.println("Student ID : " + studentIDs[studentIndex]);
                    System.out.println("Age : " + studentAges[studentIndex]);
                    System.out.println("Semester :" + semester[studentIndex]);
                    System.out.println("Department : " + department[studentIndex]);
                    System.out.println("Program :" + program[studentIndex]);
                    System.out.println("Email: " + emails[studentIndex]);
                    System.out.println("Address : " + studentAddresses[studentIndex]);
                    break;
              case 6:
                    System.out.println("Logging out...." );
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    }

              }while(choice != 6);
 
        }

        public static void addStudent() {

            if (studentCount >= 250) {
                System.out.println("Student limit reached!");
                return;
            }
         

            System.out.println("\n--- Add New Student ---");
            System.out.print("Enter Student Name: ");
            studentNames[studentCount] = sc.nextLine();

            System.out.println("Enter Student ID: ");
            studentIDs[studentCount] = sc.nextLine();

            System.out.print("Enter password : ");
            studentPasswords[studentCount] = sc.nextLine();

            System.out.print("Enter Student Age: ");
            studentAges[studentCount] = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Semester: ");
            semester[studentCount] = sc.nextLine();

            System.out.println("Enter Department: ");
            department[studentCount] = sc.nextLine( );

            System.out.println("Enter program:");
            program[studentCount] = sc.nextLine();

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
                    Pr.println(studentPasswords[i]);
                    Pr.println(department[i]);
                    Pr.println(program[i]);
                    Pr.println(emails[i]);
                    Pr.println(studentAddresses[i]);

            }
                writer.close();
                Pr.close();

            }catch(IOException r){
                System.out.println("An error occured while saving data.");
            }
        }
       public static void loadMarks() {
    File f = new File("Marks.txt");
    if (!f.exists()) return;

    try (Scanner fileScanner = new Scanner(f)) {
        while (fileScanner.hasNextLine()) {
            String id = fileScanner.nextLine();
            int studentIndex = -1;
            for (int i = 0; i < studentCount; i++) {
                if (studentIDs[i].equals(id)) {
                    studentIndex = i;
                    break;
                }
            }
            for (int j = 0; j < subjectCount; j++) {
                if (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    int mark = 0;
                    try {
                        mark = Integer.parseInt(line);
                        if (mark < 0 || mark > 100) mark = 0;
                    } catch (NumberFormatException e) {
                        mark = 0;
                    }
                    if (studentIndex != -1) marks[studentIndex][j] = mark;
                }
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while loading marks.");
    }
}

      public static void viewMyEnrollments(String studentID) {

    File f = new File("Enrollments.txt");

    if (!f.exists()) {
        System.out.println("No enrollments found.");
        return;
    }

    boolean found = false;

    try {
        Scanner fileScanner = new Scanner(f);
        System.out.println("\n--- My Enrollments ---");

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            if (line.contains("Student ID: " + studentID)) {
                System.out.println(line);
                found = true;
            }
        }

        fileScanner.close();

        if (!found) {
            System.out.println("You are not enrolled in any course.");
        }

    } catch (IOException e) {
        System.out.println("Error reading enrollments.");
    }
          }


          public static void loadData() {
    try {
        File f = new File("students.txt");
        if (!f.exists()) {
            return; 
        }

        Scanner scFile = new Scanner(f);

        
        try {
            studentCount = Integer.parseInt(scFile.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid student count in file. Starting with 0 students.");
            studentCount = 0;
        }

        for (int i = 0; i < studentCount; i++) {
            if (scFile.hasNextLine()) studentNames[i] = scFile.nextLine();
            if (scFile.hasNextLine()) studentIDs[i] = scFile.nextLine();

            
            if (scFile.hasNextLine()) {
                try {
                    studentAges[i] = Integer.parseInt(scFile.nextLine());
                } catch (NumberFormatException e) {
                    studentAges[i] = 0;
                }
            }

             if (scFile.hasNextLine()) semester[i] = scFile.nextLine();
             if (scFile.hasNextLine()) studentPasswords[i] = scFile.nextLine();
             if (scFile.hasNextLine()) department[i] = scFile.nextLine();
             if (scFile.hasNextLine()) program[i] = scFile.nextLine();

        }

        scFile.close();
        
    } catch (IOException e) {
        System.out.println("An error occurred while loading data.");
    }
}

            public static void addCourse(){
          

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
            public static void loadCourses() {
    try {
        File f = new File("Courses.txt");
        if (!f.exists()) return;

        Scanner scFile = new Scanner(f);

        try {
            courseCount = Integer.parseInt(scFile.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid course count in file. Starting with 0 courses.");
            courseCount = 0;
        }

        for (int i = 0; i < courseCount; i++) {
            if (scFile.hasNextLine()) courseNames[i] = scFile.nextLine();
            if (scFile.hasNextLine()) courseIDs[i] = scFile.nextLine();
        }

        scFile.close();
        
    } catch (IOException e) {
        System.out.println("An error occurred while loading courses.");
    }
}

 
        public static void enterMarks() {
    if (studentCount == 0) {
        System.out.println("No students available.");
        return;
    }

    System.out.print("Enter Student ID: ");
    String id = sc.nextLine();

    int studentIndex = -1;
    for (int i = 0; i < studentCount; i++) {
        if (id.equals(studentIDs[i])) {
            studentIndex = i;
            break;
        }
    }

    if (studentIndex == -1) {
        System.out.println("Student not found!");
        return;
    }

    System.out.println("Entering marks for: " + studentNames[studentIndex]);

    for (int i = 0; i < subjectCount; i++) {
        int mark = -1;
        while (true) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            if (sc.hasNextInt()) {
                mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    break; 
                } else {
                    System.out.println("Marks must be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input! Enter numbers only.");
            }
            sc.nextLine(); 
        }
        marks[studentIndex][i] = mark;
    }

    sc.nextLine(); 
    saveMarks();
    System.out.println("All marks saved successfully for " + studentNames[studentIndex] + "!");
}



            public static void viewEnrollments() {
    try {
        File f = new File("Enrollments.txt");

        if (!f.exists()) {
            System.out.println("No enrollments found.");
            return;
        }

        System.out.println("\n----ENROLLMENT LIST ----");

        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close(); 

    } catch (IOException e) {
        System.out.println("File is not found.");
    }
}

           public static void saveMarks() {
    try {
        FileWriter file = new FileWriter("Marks.txt");
        PrintWriter pr = new PrintWriter(file);

        for (int i = 0; i < studentCount; i++) {
            pr.println(studentIDs[i]); // SAVE ID FIRST
            for (int j = 0; j < subjectCount; j++) {
                pr.println(marks[i][j]);
            }
        }

        pr.close();
        file.close();
        System.out.println("Marks saved successfully!");
    } catch (IOException e) {
        System.out.println("An error occurred while saving marks.");
    }
}

 public static void searchStudent() {

    if (studentCount == 0) {
        System.out.println("No students available to search.");
        return;
    }

    System.out.print("Enter Student ID to search: ");
    String id = sc.nextLine();

    int index = -1;
    for (int i = 0; i < studentCount; i++) {
        if (id.equals(studentIDs[i])) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Student not found!");
        return;
    }

    System.out.println("\n--- Student Found ---");
    System.out.println("Name       : " + studentNames[index]);
    System.out.println("Student ID : " + studentIDs[index]);
    System.out.println("Age        : " + studentAges[index]);
    System.out.println("Semester   : " + semester[index]);
    System.out.println("Department : " + department[index]);
    System.out.println("Program    : " + program[index]);
    System.out.println("Email      : " + emails[index]);
    System.out.println("Address    : " + studentAddresses[index]);
}
   
     public static void updateStudent() {

    if (studentCount == 0) {
        System.out.println("No students available to update.");
        return;
    }

    System.out.print("Enter Student ID to update: ");
    String id = sc.nextLine();

    int index = -1;
    for (int i = 0; i < studentCount; i++) {
        if (id.equals(studentIDs[i])) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Student not found!");
        return;
    }

    System.out.println("\nUpdating record for: " + studentNames[index]);

    // AGE (validated)
    int age;
    while (true) {
        System.out.print("Enter new Age (17–60): ");
        if (sc.hasNextInt()) {
            age = sc.nextInt();
            if (age >= 17 && age <= 60) {
                studentAges[index] = age;
                break;
            } else {
                System.out.println("Age must be between 17 and 60.");
            }
        } else {
            System.out.println("Invalid input! Enter numbers only.");
            sc.next();
        }
    }
    sc.nextLine(); 

    
    System.out.print("Enter new Semester: ");
    semester[index] = sc.nextLine();

   
    System.out.print("Enter new Email: ");
    emails[index] = sc.nextLine();

    
    System.out.print("Enter new Address: ");
    studentAddresses[index] = sc.nextLine();

    saveData();
    System.out.println("Student record updated successfully!");
}

        

        public static void enrollStudent(){
            System.out.print("Enter Student ID to enroll: ");
            String id = sc.nextLine();

            int studentIndex = -1;
            for(int i = 0 ; i < studentCount ; i++){
                if(id.equals(studentIDs[i])){
                    studentIndex = i;
                    break;
                }
            }

            if(studentIndex == -1){
                System.out.println("Student not found!");
                return;
            }

            System.out.println("Available Courses:");
            for(int i = 0 ; i < courseCount ; i++){
                System.out.println((i + 1) + ". " + courseNames[i] + " (ID: " + courseIDs[i] + ")");
            }

            System.out.print("Enter the number of the course to enroll in: ");
            int choice;
            if(sc.hasNextInt()){
                choice = sc.nextInt() - 1;
                sc.nextLine();
            }else{
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                return;
            }

            if(choice < 0 || choice >= courseCount){
                System.out.println("Invalid course choice!");
                return;
            }

            enrollments[studentIndex][choice] = 1; 

            try{
                FileWriter file = new FileWriter("Enrollments.txt", true);
                PrintWriter pr = new PrintWriter(file);
                pr.println("Student ID: " + studentIDs[studentIndex] + " enrolled in Course: " + courseNames[choice] + " (ID: " + courseIDs[choice] + ")");
                file.close();
                pr.close();
            }catch(IOException e){
                System.out.println("An error occured while saving enrollment.");
            }

            System.out.println("Student enrolled successfully in " + courseNames[choice]);
        } 
    }          
