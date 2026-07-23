public class CSVLineParseri {
    public static void main(String[] args){
        //Read one line like "Ali, 25, Muscat" with a Scanner
        IO.println("Enter line like this Ali, 25, Muscat");
        String nameAgeCity = IO.readln();

        //Split it on commas
        String[]parts = nameAgeCity.split(",");


        //If it does not split into exactly three fields, print "Invalid record." and stop
        if(parts.length != 3){
            IO.println("Invalid record");
        }

        //Trim each field; convert the age to an int with Integer.parseInt.
        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        String city = parts[2].trim();

        //Classify the age
        String ageGroup = "";
        if(age < 18){
            ageGroup = "Minor";
        } else if (age>18 && age<=64) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Senior";
        }

        //print details
        IO.println("Name: "+name);
        IO.println("Age "+age+" and age group is "+ageGroup);
        IO.println("City: "+city);
    }
}
