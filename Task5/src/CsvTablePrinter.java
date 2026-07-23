import java.util.ArrayList;

public class CsvTablePrinter {
    public static void main(String[] args){
        //Store CSV rows in an array or Listb
        ArrayList<String> csvRow = new ArrayList<>();
        csvRow.add("Name, Age, City");
        csvRow.add("Jokha, 23, Muscat");
        csvRow.add("Hamed, 60, Muscat");
        csvRow.add("Rashid, 30, Al amerat");
        csvRow.add("Nasser, 19, Salalah");

        //Split the header on commas to get the column titles
        String [] headers = csvRow.get(0).split(",");
        int columns = headers.length;

        //Print the titles
        IO.println(String.format("%15s %10s %15s", headers[0].trim(), headers[1].trim(), headers[2].trim()));

        //Print a separator line made with "-".repeat(...)
        IO.println("-".repeat(40));

        //Loop through the data rows and split each on commas
        int count = 0;
        for(int i = 1; i <csvRow.size(); i++){
            String row = csvRow.get(i);
            String [] parts = row.split(",");
            //Skip any row whose field count differs from the header
            if(parts.length != columns){
                IO.println("Skipping malformed row: "+row);
            }

            // Print each row using String.format so columns line up
            IO.println(String.format("%-15s %-10s %-15s",
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim()));
            count++;
        }

        //Print how many data rows were shown
        IO.println("-".repeat(40));
        IO.println("Total rows displayed: "+count);

    }
}
