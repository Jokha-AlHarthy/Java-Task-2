import java.util.ArrayList;

public class FileTypeClassifier {
    public static void main(String[] args){
        //Make a List<String> of at least 8 file names with different extensions (include one with no extension)
        ArrayList<String> files = new ArrayList<String>();

        //Adding at least 8 file names with different extensions & include one with no extension
        files.add("Java.txt");
        files.add("Java.java");
        files.add("Java.docx");
        files.add("picture.jpg");
        files.add("picture.png");
        files.add("string.py");
        files.add("string.js");
        files.add("code");

        //Keep a counter
        int countDocument = 0;
        int countImage = 0;
        int countCode = 0;
        int countOther = 0;

        // Loop through the list
        String classification= "";
        for (String file : files) {
            int dotIndex = file.lastIndexOf('.');
            String extension = "";

            // Get extension if a valid dot exists
            if (dotIndex > 0 && dotIndex < file.length() - 1) {
                extension = file.substring(dotIndex + 1).toLowerCase();
            }

            //Classify each extension
            if(extension.equals("txt") || extension.equals("pdf") || extension.equals("docx")){
                classification = "Document";
                countDocument++;
            } else if (extension.equals("jpg") || extension.equals("png")  || extension.equals("gif")) {
                classification = "Image";
                countImage++;
            } else if (extension.equals("java")  || extension.equals("py") || extension.equals("js")) {
                classification = "Code";
                countCode++;

            } else{
                classification = "Other";
                countOther++;
            }

        }

        //print the details
        IO.println("File name is: "+files+"."+classification);
        IO.println("Total number of files is: "+files.size());
        IO.println("Document file: "+countDocument);
        IO.println("Image file is: "+countImage);
        IO.println("Code file is: "+countCode);
        IO.println("Other files: "+countOther);
    }
}
