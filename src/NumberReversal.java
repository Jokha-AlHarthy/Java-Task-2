public class NumberReversal {
    public static void main(String[] args){
        //Declaring & initializing the required variables
        int number=12345;
        int reversedNumber=0;
        int digit;
        int originalNumber = number;

        //Use a loop to extract the digits from the given number
        while (number > 0) {

            // Extract the last digit
            digit = number % 10;

            // Add the digit to the reversed number
            reversedNumber = reversedNumber * 10 + digit;

            // Remove the last digit from the original number
            number = number / 10;
        }

        //Displaying the original number and the reversed result
        System.out.println("Original Number: "+originalNumber);
        System.out.println("Reversed Number: "+reversedNumber);
    }
}
