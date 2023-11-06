
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentCourseRegistrationSystem {

    public static void main(String args[]) {
        int[] courseSelect = new int[4];

        boolean quit = false;

        Scanner input = new Scanner(System.in);
        boolean invalidInput = false; // Flag to track invalid input

        Math math = new Math();
        Physics physics = new Physics();
        Computer computer = new Computer();

        CourseRegistration cr = new CourseRegistration();

        while (!quit) {
            int n;

            do {
                if (invalidInput) {
                    System.out.println("Invalid input. Please enter a valid option (1-5).");
                    invalidInput = false; // Reset the flag
                }

                System.out.println("\n======================================");
                System.out.println("1. View Available Courses");
                System.out.println("2. Register a Student");
                System.out.println("3. Show Student Records");
                System.out.println("4. Drop a Course");
                System.out.println("5. Close Application");
                System.out.println("======================================\n");

                try {
                    System.out.print("Enter your choice (1-5): ");
                    n = input.nextInt();
                } catch (InputMismatchException e) {
                    input.nextLine(); // Clear the input buffer
                    n = -1; // Set n to an invalid value
                    invalidInput = true; // Set the flag to show an error message
                }

                if (n < 1 || n > 5) {
                    invalidInput = true; // Set the flag to show an error message
                }
            } while (n < 1 || n > 5);

            if (n == 1) {
                System.out.println("======================================");
                System.out.println("Available Courses:");
                math.showData();
                physics.showData();
                computer.showData();
                System.out.println("======================================");
            } else if (n == 2) {
                System.out.println("======================================");
                System.out.println("Student Registration:");
                System.out.print("Enter the student's name: ");
                String name = input.next();
                System.out.print("Enter the student's id: ");
                int id = input.nextInt();

                boolean done = false;

                while (done == false) {
                    System.out.println("Select course number \n1.Mathematics\n2.Physics\n3.Computer\n4.select all\n5.done");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("\nenter  number and select done");
                        courseSelect[i] = input.nextInt();
                        if (courseSelect[i] == 5) {
                            done = true;
                            break;
                        } else if (courseSelect[i] == 4) {
                            if (math.capacity > 0 && physics.capacity > 0 && computer.capacity > 0) {
                                done = true;
                                break;
                            } else {
                                System.out.println("At least one of the selected courses is currently full. Cannot add all courses.");
                                courseSelect[i] = 0; // Mark the course as unselected
                            }
                        } else if ((courseSelect[i] == 1 && math.capacity <= 0)
                                || (courseSelect[i] == 2 && physics.capacity <= 0)
                                || (courseSelect[i] == 3 && computer.capacity <= 0)) {
                            System.out.println("The selected course is currently full. Cannot add the course.");
                            courseSelect[i] = 0; // Mark the course as unselected
                        }
                    }
                }

                cr.newRegistration(id, name, courseSelect, math, computer, physics);

                System.out.println("======================================");
            } else if (n == 3) {
                System.out.println("======================================");
                System.out.println("Student Data:");
                cr.showData();
                System.out.println("======================================");
            } else if (n == 4) {
                if (!cr.list.isEmpty()) { // Check if there are records
                    System.out.println("======================================");
                    System.out.println("Drop a Course:");
                    cr.showData();
                    System.out.print("Enter student Id to remove: ");
                    int stId = input.nextInt();
                    System.out.print("Enter student Course Number (1. Mathematics, 2. Physics, 3. Computer): ");
                    int stCoNum = input.nextInt();
                    cr.removeCourse(stId, stCoNum, math, computer, physics);

                    System.out.println("======================================");
                } else {
                    System.out.println("No records found. Cannot remove a course.");
                }
            } else if (n == 5) {
                System.out.println("======================================");
                System.out.println("THANK YOU");
                quit = true;
            }
        }
    }

}

class Math {

    final int code = 123;
    String title = "MatMathematics";
    int capacity = 3;
    String[] schedule = {"Monday", "Tuesday"};
    String courseDescription = " This course covers fundamental mathematical concepts\n and problem-solving techniques.";

    public Math() {
    }

    public void showData() {
        if (capacity > 0) {
            System.out.println("Course Title: " + title);
            System.out.println("Course Code: " + code);
            System.out.print("Course Description: ");

            System.out.println(courseDescription);
            System.out.println("Available slots: " + capacity);
            System.out.println("Schedule: " + String.join(", ", schedule) + "\n");
        } else {
            System.out.println("Mathematics course is currently full.");
        }
    }

    public void reduceCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        if (capacity < 3) {
            capacity++;
        }
    }
}

class Physics {

    final int code = 456;
    String title = "Physics";
    int capacity = 3;
    String[] schedule = {"Wednesday", "Thursday"};
    String courseDescription = "This course explores the principles of \nphysics and their real-world applications.";

    public Physics() {
    }

    public void showData() {
        if (capacity > 0) {
            System.out.println("Course Title: " + title);
            System.out.println("Course Code: " + code);
            System.out.print("Course Description: ");

            System.out.println(courseDescription);
            System.out.println("Available slots: " + capacity);
            System.out.println("Schedule: " + String.join(", ", schedule) + "\n");
        } else {
            System.out.println("Physics course is currently full.");
        }
    }

    public void reduceCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        if (capacity < 3) {
            capacity++;
        }
    }
}

class Computer {

    final int code = 789;
    String title = "Computer";
    int capacity = 3;
    String schedule = "Friday";
    String courseDescription = "This course covers computer hardware, software, and programming.";

    public Computer() {
    }

    public void showData() {
        if (capacity > 0) {
            System.out.println("Course Title: " + title);
            System.out.println("Course Code: " + code);
            System.out.print("Course Description: ");

            System.out.println(courseDescription);
            System.out.println("Available slots: " + capacity);
            System.out.println("Schedule: " + schedule + "\n");
        } else {
            System.out.println("Computer course is currently full.");
        }
    }

    public void reduceCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        if (capacity < 3) {
            capacity++;
        }
    }
}

// Rest of the code remains the same
class Student {

    int id;
    String name;
    String[] Courses = new String[3];

    public Student() {
    }

}

class CourseRegistration {

    ArrayList<Student> list = new ArrayList<>();

    public CourseRegistration() {
    }

    public void newRegistration(int id, String name, int[] coursesSelect, Math m1, Computer c1, Physics ph1) {
        // Validate the student ID
        if (id <= 0) {
            System.out.println("Invalid student ID. Please enter a positive integer.");
            return;
        }

        Student newstudent = new Student();
        newstudent.id = id;
        newstudent.name = name;

        for (int i = 0; i < 3; i++) {
            if (coursesSelect[i] == 1) {
                m1.reduceCapacity();
                newstudent.Courses[i] = "Mathematics";

            } else if (coursesSelect[i] == 2) {
                ph1.reduceCapacity();
                newstudent.Courses[i] = "Physics";
            } else if (coursesSelect[i] == 3) {
                c1.reduceCapacity();
                newstudent.Courses[i] = "Computer";
            } else if (coursesSelect[i] == 4) {
                newstudent.Courses[0] = "Mathematics";
                newstudent.Courses[1] = "Physics";
                newstudent.Courses[2] = "Computer";
                m1.reduceCapacity();
                ph1.reduceCapacity();
                c1.reduceCapacity();

                break;
            }
        }
        list.add(newstudent);
        System.out.println("Student registered successfully.");
    }

    public void showData() {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Id: " + list.get(i).id);
                System.out.print("Name: " + list.get(i).name + "\n");

                System.out.println("Courses Enrolled: ");
                boolean coursesEnrolled = false;
                for (int j = 0; j < list.get(i).Courses.length; j++) {
                    if (list.get(i).Courses[j] != null) {
                        System.out.print(" " + list.get(i).Courses[j]);
                        coursesEnrolled = true;
                    }
                }
                if (!coursesEnrolled) {
                    System.out.print("No courses enrolled");
                }
                System.out.println("");
            }
        } else {
            System.out.println("No records found");
        }
    }

    public void removeCourse(int id, int courseNum, Math m1, Computer c1, Physics ph1) {
        boolean successFlag = false;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).id) {
                list.get(i).Courses[courseNum - 1] = null;
                System.out.println("Course Dropped Successfully");
                successFlag = true;
                if (courseNum == 1) {
                    m1.increaseCapacity();

                } else if (courseNum == 2) {
                    ph1.increaseCapacity();

                } else if (courseNum == 3) {
                    c1.increaseCapacity();

                }
                break;
            }
           
        }
         if (!successFlag) {
                System.out.println("Id Not Found");
            }

    }

}
