import java.util.ArrayList;

public class FileInventoryReport {
    public static void main(String[] args){
        //Store at least six CSV records
        ArrayList<String> records = new ArrayList<>();
        records.add("report.pdf, 1500");
        records.add("photo.png, 340");
        records.add("app.java, 15");
        records.add("song.mp3, 4500");
        records.add("video.mp4, 8750");
        records.add("notes.txt, 800");

        //Keep a total size, a counter per type (Document, Image, Audio, Code, Other)
        int totalFiles = 0;
        int totalSizes = 0;
        int docCount = 0;
        int imgCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        //largest file seen
        String largestFileName ="";
        int largestFileSize = -1;


        //Loop through the records and split each on the comma
        for(String record: records){
            String [] parts = record.split(",");

            //Skip any record that is not two fields (print a message)
            if(parts.length != 2){
                IO.println("Skipping malformed row: " + record);
                continue;
            }

            //Trim both parts and convert the size to a number
            String fileName = parts[0].trim();
            int size = Integer.parseInt(parts[1].trim());

            //Get the extension from the file name and classify
            int lastDotIndex = fileName.lastIndexOf('.');
            String extension = "";
            if (lastDotIndex != -1){
                extension = fileName.substring(lastDotIndex+1).toLowerCase();
            }
            String type = "";
            if(extension.equals("txt") || extension.equals("pdf") || extension.equals("docx") || extension.equals("xlsx")){
                type =  "Document";
                docCount++;
            } else if (extension.equals("jpg") || extension.equals("png") || extension.equals("gif")) {
                type = "Image";
                imgCount++;
            } else if (extension.equals("mp3") || extension.equals("wav")) {
                type = "Audio";
                audioCount++;
            } else if(extension.equals("java") || extension.equals("py") || extension.equals("js")){
                type = "Code";
                codeCount++;
            } else{
                type = "Other";
                otherCount++;
            }

            //Add the size to the total and check for largest file
            totalSizes += size;
            totalFiles++;
            if(size > largestFileSize){
                largestFileSize = size;
                largestFileName = fileName;
            }

            //Print the details
            IO.println("File: "+fileName+", file extension is: "+extension+", type of file: "+type+ ", size of file is: "+size+" KB");
        }
        //print the summary
        IO.println("Total files: "+totalFiles);
        IO.println("Total size: "+totalSizes);
        IO.println("Count per category as following:  ");
        IO.println("Document: "+docCount);
        IO.println("Image: "+imgCount);
        IO.println("Audio: "+audioCount);
        IO.println("Code: "+codeCount);
        IO.println("Other: "+otherCount);
        IO.println("The largest file: "+largestFileName+" and the size of it is: "+largestFileSize);


    }
}
