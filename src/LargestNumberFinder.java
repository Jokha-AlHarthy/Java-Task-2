public class LargestNumberFinder {
    public static void main(String[] args){
        //Declaring & initializing the needed variables
        int number;
        int largest = 0;
        int i = 1;

        while(i<=5){
            if(i==1){
                number = 1874;
            } else if (i==2) {
                number = 1738;
            } else if (i==3) {
                number=6673;
            } else if (i==4) {
                number=9922;
            } else {
                number=8001;
            }

            if(number > largest){
                largest = number;
            }
            i++;
        }
        System.out.println("Largest Number: "+largest);
    }
}
