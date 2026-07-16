public class MultiplicationCalculator {
    public static void main(String[] args){
       //Declaring and initializing the required variables
        int start = 1;
        int end = 10;
        int result=1;

        //Use a loop to multiply the numbers from start to end
        while(start<=end){
            result = result * start;
            start++;
        }
        System.out.println("Multiplication Result: "+ result);
    }
}
