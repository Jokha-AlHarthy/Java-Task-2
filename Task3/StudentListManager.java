import java.util.ArrayList;

public class StudentListManager {
    public static void main(String[] args){
        String studentToSearch;
        //Create a List<String> named students
        ArrayList<String>students = new ArrayList<>();

        //Add at least 10 student names to the list
        students.add("Jokha");
        students.add("Hoor");
        students.add("Shadha");
        students.add("Reem");
        students.add("Taqwa");
        students.add("Maiyada");
        students.add("Intisar");
        students.add("Salima");
        students.add("Salwa");
        students.add("Reem Al Harrasi");

        //Use a loop to display all student names in the list
        System.out.println("The list of students are");
        for (String student : students) {
            System.out.println(student);
        }

        //Display the total number of students in the list
        System.out.println("The total number of students: "+students.size());

        //Display the first student in the list
        System.out.println("The first student in the list is: "+students.getFirst());

        //Display the last student in the list
        System.out.println("The first student in the list is: "+students.getLast());

        //Check if a specific student name exists in the list using a condition
        IO.println("Please enter the student name:");
        studentToSearch = IO.readln();
        if (students.contains(studentToSearch)) {
            System.out.println(studentToSearch + " Student exists in the list");
        } else {
            System.out.println(studentToSearch + " Student does not exist in the list");
        }

        //Remove a student from the list
        students.remove(5);

        //Display the updated list after removing the student
        System.out.println("The updated list of student"+students);
    }
}
