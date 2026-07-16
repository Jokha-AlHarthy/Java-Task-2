import java.util.ArrayList;

public class NumberListStatistics {
    public static void main(String[] args){
        //Create a List<Integer> named numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        //Add at least 20 integer values to the list
        numbers.add(0);
        numbers.add(1);
        numbers.add(8);
        numbers.add(7);
        numbers.add(4);
        numbers.add(6);
        numbers.add(6);
        numbers.add(7);
        numbers.add(3);
        numbers.add(1);
        numbers.add(-1);
        numbers.add(-1);
        numbers.add(-8);
        numbers.add(-7);
        numbers.add(-4);
        numbers.add(-6);
        numbers.add(-6);
        numbers.add(-7);
        numbers.add(-3);
        numbers.add(-1);

        //Create variables to store
        int sum = 0;
        int evenNumber = 0;
        int oddNumber = 0;
        int countPositiveNo = 0;
        int countNegativeNo = 0;

        //Initialize the largest and smallest values using the first number in the list
        int largestNumber = numbers.get(0);
        int smallestNumber = numbers.get(0);

        //Use a loop to go through all numbers in the list
        for (int number : numbers) {

            // Calculate the total sum of all numbers
            sum += number;

            //Check if the number is even or odd
            if (number % 2 == 0) {
                evenNumber++;
            } else {
                oddNumber++;
            }

            // Check if the number is positive or negative
            if (number > 0) {
                countPositiveNo++;
            } else if (number < 0) {
                countNegativeNo++;
            }

            // Find the largest number
            if (number > largestNumber) {
                largestNumber = number;
            }

            // Find the smallest number
            if (number < smallestNumber) {
                smallestNumber = number;
            }
        }

        //Find the average number
        double average = (double) sum / numbers.size();

        //Use a loop to display all numbers in the list
        System.out.println("The list of numbers are");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        //Display the result
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Average value: " + average);
        System.out.println("Largest number: " + largestNumber);
        System.out.println("Smallest number: " + smallestNumber);
        System.out.println("Count of even numbers: " + evenNumber);
        System.out.println("Count of odd numbers: " + oddNumber);
        System.out.println("Count of positive numbers: " + countPositiveNo);
        System.out.println("Count of negative numbers: " + countNegativeNo);

    }
}
