public class PalindromeChecker {
    public static void main(String[] args) {
        //Declaring & initializing the needed variables
        int number = 1221;
        int originalNumber = number;
        int reversedNumber=0;
        int digit;

        //Use a loop to reverse the digits of the given number
        while (number > 0) {
            // Extract the last digit
            digit = number % 10;

            // Add the digit to the reversed number
            reversedNumber = reversedNumber * 10 + digit;

            // Remove the last digit from the original number
            number = number / 10;

            //Checking a number if it's palindrome or not
            if(originalNumber==reversedNumber){
                System.out.println("Number: "+originalNumber);
                System.out.println("The number is a palindrome");
            }else{
                System.out.println("Number: "+reversedNumber);
                System.out.println("The number is not a palindrome");
            }
        }
    }
}
