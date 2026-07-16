public class DigitFrequencyCounter {
    public static void main(String[] args){
        //Declare and initialize the required variables
        int number = 122333;
        int orginalNumber = number;
        int targetDigit= 3;
        int count=0;
        int digit;

        //Use a loop to extract each digit from the given number
        while(number>0){
            //Extract the last digit number
            digit = number %10;

            //Compare each extracted digit with the target digit
            if(digit == targetDigit){
                count++;
            }

            //remove the last digit number
            number = number / 10;
        }


        //Display the target digit and the number of times it appears
        System.out.println("Number: "+orginalNumber);
        System.out.println("Target Digit: "+targetDigit);
        System.out.println("Frequency: "+count);
    }
}
