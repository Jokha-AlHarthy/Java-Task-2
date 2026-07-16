public class DigitCounter {
    public static void main(String[] args){
        //Declaring & initializing the needed variables
        int number = 123456;
        int count = 0;

        //Storing number into another variable
        int originalNumber = number;

        //Use a loop to process the digits of the given number
        while(number>0){
            number = number / 10;
            count++;
        }

        //Display the original number and the total number of digits./
        System.out.println("Number: "+originalNumber);
        System.out.println("Number of digits "+ count);
    }
}
