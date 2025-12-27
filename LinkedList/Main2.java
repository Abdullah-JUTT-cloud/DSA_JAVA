import java.util.Scanner;

class StudentNode {
    String studentId;
    String studentName;
    StudentNode next;

    StudentNode(String id, String name) {
        this.studentId = id;
        this.studentName = name;
        this.next = null;
    }
}

class StudentList {
    private StudentNode head;

    void insertStudent(String id, String name) {
        if (searchById(id) != null) {
            System.out.println("Already in the list.");
            return;
        }
        StudentNode newStudent = new StudentNode(id, name);
        if (head == null) {
            head = newStudent;
            System.out.println("Student added successfully!");
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
        System.out.println("Student added successfully!");
    }

    StudentNode searchById(String id) {
        StudentNode current = head;
        while (current != null) {
            if (current.studentId.equalsIgnoreCase(id)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void searchByName(String name) {
        boolean found = false;
        StudentNode current = head;
        System.out.println("\nSearching for: " + name);
        while (current != null) {
            if (current.studentName.equalsIgnoreCase(name)) {
                System.out.println("Found - ID: " + current.studentId + ", Name: " + current.studentName);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }

    void deleteById(String id) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.studentId.equalsIgnoreCase(id)) {
            head = head.next;
            System.out.println("Record deleted successfully.");
            return;
        }
        StudentNode previous = head;
        StudentNode current = head.next;
        while (current != null) {
            if (current.studentId.equalsIgnoreCase(id)) {
                previous.next = current.next;
                System.out.println("Record deleted successfully.");
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    void printAll() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\nStudent Records:");
        System.out.println("=====================================");
        System.out.printf("%-20s %-20s%n", "Student ID", "Student Name");
        System.out.println("-------------------------------------");
        StudentNode current = head;
        while (current != null) {
            System.out.printf("%-20s %-20s%n", current.studentId, current.studentName);
            current = current.next;
        }
        System.out.println("=====================================");
    }

    int countStudents() {
        int count = 0;
        StudentNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void reverseList() {
        if (head == null || head.next == null) {
            System.out.println("Not enough students to reverse.");
            return;
        }
        StudentNode previous = null;
        StudentNode current = head;
        StudentNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        System.out.println("List reversed successfully!");
    }

    void sortByName() {
        if (head == null || head.next == null) {
            System.out.println("Not enough students to sort.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            StudentNode current = head;
            while (current.next != null) {
                if (current.studentName.compareToIgnoreCase(current.next.studentName) > 0) {
                    String tempId = current.studentId;
                    String tempName = current.studentName;
                    current.studentId = current.next.studentId;
                    current.studentName = current.next.studentName;
                    current.next.studentId = tempId;
                    current.next.studentName = tempName;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted alphabetically by name!");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        System.out.println("Welcome to Student Management System!");
        System.out.println("========================================\n");
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Enter student information");
            System.out.println("2. Search student by ID");
            System.out.println("3. Search student by Name");
            System.out.println("4. Delete student information");
            System.out.println("5. Print all students");
            System.out.println("6. Reverse the list (Bonus)");
            System.out.println("7. Sort by name (Bonus)");
            System.out.println("8. Quit");
            System.out.print("\nEnter your choice: ");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine().trim();
                    if (id.isEmpty() || name.isEmpty()) {
                        System.out.println("ID and Name cannot be empty!");
                    } else {
                        list.insertStudent(id, name);
                    }
                    break;
                case 2:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = sc.nextLine().trim();
                    StudentNode student = list.searchById(searchId);
                    if (student != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println("ID: " + student.studentId);
                        System.out.println("Name: " + student.studentName);
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student Name to search: ");
                    String searchName = sc.nextLine().trim();
                    list.searchByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.nextLine().trim();
                    list.deleteById(deleteId);
                    break;
                case 5:
                    list.printAll();
                    int total = list.countStudents();
                    System.out.println("\nTotal Students: " + total);
                    break;
                case 6:
                    list.reverseList();
                    break;
                case 7:
                    list.sortByName();
                    break;
                case 8:
                    System.out.println("\nProgram terminated. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose 1-8.");
            }
        }
    }
}
