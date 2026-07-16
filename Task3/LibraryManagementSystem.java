import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args){

        //Create lists to store data
        ArrayList<String>bookNames= new ArrayList<>();
        ArrayList<String>authorNames = new ArrayList<>();
        ArrayList<Boolean>bookAvailabilityStatus = new ArrayList<>();

        //Add at least 10 books with their authors and availability status
        int bookCount = 0;
        while(bookCount < 10){
            IO.println("Please enter book name ");
            bookNames.add(IO.readln());
            IO.println("Please enter author name: ");
            authorNames.add(IO.readln());
            IO.println("Please enter book availability status: ");
            bookAvailabilityStatus.add(Boolean.parseBoolean(IO.readln()));
            bookCount++;
        }

        //Create a menu using switch case
        int choice = 0;
        while(choice!= 6){
            System.out.println("Library menu");
            System.out.println("1.Display all books");
            System.out.println("2.Search for a book");
            System.out.println("3.Borrow a book");
            System.out.println("4.Return a book");
            System.out.println("5.Display library report");
            System.out.println("6.Exit the program");

            IO.println("Please choose one of the choices: ");
            choice = Integer.parseInt(IO.readln());

            switch (choice){
                case 1:
                    displayBooks(bookNames, authorNames, bookAvailabilityStatus);
                    break;
                case 2:
                    IO.println("Enter book name to search: ");
                    String searchBookName = IO.readln();
                    searchBook(bookNames,searchBookName);
                    break;
                case 3:
                    IO.println("Enter book name to borrow: ");
                    String borrowBookName = IO.readln();
                    borrowBook(bookNames, bookAvailabilityStatus, borrowBookName);
                    break;
                case 4:
                    IO.println("Enter book name to return: ");
                    String returnBookName = IO.readln();
                    returnBook(bookNames, bookAvailabilityStatus, returnBookName);
                    break;
                case 5:
                    int[] bookCounts = countBooks(bookAvailabilityStatus);

                    int availableBooks = bookCounts[0];
                    int unavailableBooks = bookCounts[1];
                    displayReport(bookNames, availableBooks, unavailableBooks);
                    break;
                case 6:
                    System.out.println("Exit the program");
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }


    }

    //Create a method named displayBooks()
    public static void displayBooks(ArrayList<String>bookNames, ArrayList<String>authorNames, ArrayList<Boolean>bookAvailabilityStatus){
        for(int i=0; i < bookNames.size(); i++){
            System.out.println("Book name is: "+bookNames.get(i));
            System.out.println("Book author is: "+authorNames.get(i));
            System.out.println("The book is"+bookAvailabilityStatus.get(i));
        }
    }

    //Create a method named searchBook()
    public static void searchBook(ArrayList<String> bookNames, String searchBookName) {
        boolean found = false;
        for (String bookName : bookNames) {
            if (bookName.equals(searchBookName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The book exists");
        } else {
            System.out.println("The book does not exist");
        }
    }

    //Create a method named borrowBook()
    public static void borrowBook(ArrayList<String> bookNames, ArrayList<Boolean> availability, String bookToBorrow) {
        for (int i = 0; i < bookNames.size(); i++) {
            if (bookNames.get(i).equals(bookToBorrow)) {
                if (availability.get(i)) {
                    availability.set(i, false);
                    System.out.println("Book borrowed successfully");
                } else {
                    System.out.println("Book is already unavailable");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    //Create a method named returnBook()
    public static void returnBook(ArrayList<String> bookNames, ArrayList<Boolean> availability, String bookToBorrow) {
        for (int i = 0; i < bookNames.size(); i++) {
            if (bookNames.get(i).equals(bookToBorrow)) {
                if (availability.get(i)) {
                    availability.set(i, true);
                    System.out.println("Book returned successfully");
                } else {
                    System.out.println("Book is not returned yet!");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    //Create a method named countBooks()
    public static int[] countBooks(ArrayList<Boolean> availability) {
        int availableBooks = 0;
        int unavailableBooks = 0;
        for (boolean isAvailable : availability) {
            if (isAvailable) {
                availableBooks++;
            } else {
                unavailableBooks++;
            }
        }
        return new int[]{availableBooks, unavailableBooks};
    }

    //Create a method named displayReport()
    public static void displayReport(ArrayList<String> bookNames, int availableBooks, int unvailableBook){
        System.out.println("Book information Summary");
        System.out.println("Total inventory value: "+bookNames.size());
        System.out.println("Number of available products: "+availableBooks);
        System.out.println("Number of out-of-stock products: "+unvailableBook);
    }
}
