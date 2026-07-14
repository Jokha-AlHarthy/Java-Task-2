public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        //Declare and initialize the required variables
        int number = 153;
        int orignalNumber = number;
        int digit;
        int sum = 0;
        int count=0;

        //Use a loop to count the number of digits in the given number
        while(number>0){
            count++;
            number = number / 10;
        }
        number = orignalNumber;

        //Use another loop to extract each digit and calculate the Armstrong value
        while(number>0){
            digit = number %10;
            sum = sum + (int)Math.pow(digit,count);
            number = number / 10;
        }

        //Compare the calculated sum with the original number & Display whether the number is an Armstrong number or not
        if(sum == orignalNumber){
            System.out.println("Number: "+orignalNumber);
            System.out.println("The number is an Armstrong number");
        }else{
            System.out.println("Number: "+orignalNumber);
            System.out.println("The number is not an Armstrong number");
        }
    }
}

