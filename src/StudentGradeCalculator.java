public class StudentGradeCalculator {
    public static void main(String[] args){
        //Declaring & initializing the needed variables
        double grade1 = 85;
        double grade2 = 90;
        double grade3 = 80;
        double average;
        String status;

        //Calculate the average grade and store the result in the average variable
        average = (grade1 + grade2 + grade3) / 3;

        //First condition Average 90 or above → Excellent
        if(average >= 90){
           status = "Excellent";
            //Second condition Average 75 to 89 → Good
        } else if (average >= 75 && average < 90) {
            status="Good";
            //Third condition Average 60 to 74 → Pass
        } else if (average >= 60 && average < 75) {
            status="Pass";
            //Last condition Average below 60 → Fail
        } else{
           status = "Fail";
        }
        //Displaying the grades, average, and final status
        System.out.println("Grade 1: "+grade1);
        System.out.println("Grade 2: "+grade2);
        System.out.println("Grade 3: "+grade3);
        System.out.println("Average "+average);
        System.out.println("Status: "+ status);
    }
}
