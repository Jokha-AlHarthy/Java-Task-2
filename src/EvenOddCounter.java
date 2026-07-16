public class EvenOddCounter {
    public static void main(String[] args){
        //Declaring and initialize the required variables
        int start= 1;
        int end=10;
        int evenCount=0;
        int oddCount=0;

        //Use a loop to check numbers within the given range.
        while(start<=end){
            //create a condition to check whether the number is even or odd
            if(start % 2 ==0){
                evenCount++;
            }else{
                oddCount++;
            }
            start++;
        }

        //Display the total number of even and odd values
        System.out.println("Even Numbers Count: "+evenCount);
        System.out.println("Odd Numbers Count: "+oddCount);
    }
}
