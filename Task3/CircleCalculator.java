public class CircleCalculator {
    public static void main(String[] args){

        //Declaring needed variables
        double pi = 3.14;
        double radius;
        double area;
        double circumference;
        String classification;

        //Prompt the user to enter the radius using a Scanner
        IO.println("Please enter the value of radius:");
        radius = Double.parseDouble(IO.readln());

        //Condition to check the radius
        if(radius <= 0){
            System.out.println("Invalid radius. Radius must be greater than zero");
        }else{

            //calculate the area & circumference
            area = pi * radius * radius;
            circumference = 2 * pi * radius;

            if (radius < 5) {
                classification = "Small Circle";
            } else if (radius <= 15) {
                classification = "Medium Circle";
            } else {
                classification = "Large Circle";
            }
            //Display the base, height, side lengths, area, perimeter, and triangle type
        System.out.println("The raduis of the cricle is "+radius);
        System.out.println("The area of cricle is "+area);
        System.out.println("The circumference of cicle is "+circumference);
        System.out.println("The classification of the sricle is "+ classification);
    }
    }
}
