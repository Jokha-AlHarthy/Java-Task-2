public class DecimalToBinary {
    public static void main(String[] args){
        //Declare and initialize the required variables
        int number = 25;
        String binary = "";
        int orginalNumber = number;
        int remainder;

        //Use a loop to repeatedly divide the decimal number by 2
        while(number>0){
            //remainder value to build the binary representation.
            remainder = number % 2;

            //To get the binary number
            binary = remainder + binary ;

            //iteration for each loop until number become 0
            number = number / 2;
        }

        //Display the original decimal number and its binary equivalent.
        System.out.println("Decimal Number: "+orginalNumber);
        System.out.println("Binary number: "+binary);
    }
}
