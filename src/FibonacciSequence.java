public class FibonacciSequence {
    public static void main(String[] args){
        //Declaring & initializing the needed variables
        int first = 0;
        int second = 1;
        int next;
        int count;


        //Displaying the first numbers in Fibonacci sequence
        System.out.println(first + " " + second + " ");


        //Generating the loop for the remaining numbers
        for(count = 3; count <= 15; count++){

            //calculate new numbers by adding remaining numbers after the first two values
            next = first + second;
            System.out.println(" "+next);

            //updating the variables
            first = second;
            second = next;
        }
    }
}
