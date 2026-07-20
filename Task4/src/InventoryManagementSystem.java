import java.util.ArrayList;
import java.util.Collections;

public class InventoryManagementSystem {
    public static void main(String[] args){
        //Create the following ArrayLists
        //1. Product name
        ArrayList<String> productNames = new ArrayList<>();

        //2. Product quantities
        ArrayList<Integer> productQuantities = new ArrayList<>();

        //3. Product Prices
        ArrayList<Double> productPrices = new ArrayList<>();

        //Store information for at least 10 products
        productNames.add("Laptop");
        productQuantities.add(5);
        productPrices.add(750.50);

        productNames.add("Laptop");
        productQuantities.add(2);
        productPrices.add(350.50);

        productNames.add("PC");
        productQuantities.add(1);
        productPrices.add(1500.850);

        productNames.add("PC");
        productQuantities.add(2);
        productPrices.add(3500.850);

        productNames.add("Microphone");
        productQuantities.add(5);
        productPrices.add(250.50);

        productNames.add("Iphone 17");
        productQuantities.add(2);
        productPrices.add(750.50);

        productNames.add("iPad air");
        productQuantities.add(3);
        productPrices.add(750.50);

        productNames.add("Mouse");
        productQuantities.add(10);
        productPrices.add(300.50);

        productNames.add("Mouse pad");
        productQuantities.add(3);
        productPrices.add(50.500);

        productNames.add("USB 125 GB");
        productQuantities.add(20);
        productPrices.add(100.850);


        //Display Inventory
        for(int i=0; i < productNames.size(); i++){
            //1. Product index
            System.out.println("Product "+i+": ");

            //2. Product name
            System.out.println("Name: "+productNames.get(i));

            //3. Quantity
            System.out.println("Quantity: "+productQuantities.get(i));

            //4. Price
            System.out.println("Price: "+productPrices.get(i));
        }

        //Add New Product

        //1. Ask the user for product name
        IO.println("Enter Product Name: ");
        String proName = IO.readln();
        //2. Ask for quantity
        IO.println("Enter Quantity:");
        int proQuantity = Integer.parseInt(IO.readln());
        //3. Ask for price
        IO.println("Enter Price:");
        double proPrice = Double.parseDouble(IO.readln());

        productNames.add(proName);
        productQuantities.add(proQuantity);
        productPrices.add(proPrice);
        System.out.println("Product added successfully");

        //Update Product Information
        //1. Ask the user for the product index
        IO.println("Please enter the index position: ");
        int index = Integer.parseInt(IO.readln());

        //2. Replace the old name with a new name
        if (index >= 0 && index < productNames.size()) {
            //A. Allow updating Product name
            IO.println("New Product Name: ");
            String updatedName = IO.readln();

            //B. Allow updating Quantity
            IO.println("New Quantity: ");
            int updatedQuantity = Integer.parseInt(IO.readln());

            //C. Allow updating Price
            IO.println("New Price: ");
            double updatedPrice = Double.parseDouble(IO.readln());
            productNames.set(index, updatedName);
            productQuantities.set(index, updatedQuantity);
            productPrices.set(index, updatedPrice);
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Invalid index!");
        }

        //Search Product System
        //1. Ask the user to enter a product name
        IO.println("Please enter name of product you want to search for: ");
        String searchName = IO.readln();

        //2. Check if the product exists
        int searchIndex = -1;
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).equalsIgnoreCase(searchName)) {
                searchIndex = i;
                break;
            }
        }
        if (searchIndex != -1) {
            //Display Product index, Product quantity, & Product price
            System.out.println("Index: " + searchIndex);
            System.out.println("Quantity: " + productQuantities.get(searchIndex));
            System.out.println("Price: " + productPrices.get(searchIndex));
        } else {
            System.out.println("Product not found");
        }

        //Stock Analysis
        //1. Total number of products
        System.out.println("Total Products:"+productQuantities.size());

        //2. Total quantity of all products
        double sum = 0;
        for(int i = 0; i<productPrices.size(); i++){
            sum += productPrices.get(i);
        }
        System.out.println("The total price is: "+sum);

        //3. Total inventory value
        System.out.println("Inventory Value: "+ productQuantities.size() * sum);


        //Stock Status Checking
        //1.Products with low stock (quantity < 5)
        for(int i = 0; i<productNames.size(); i++){
            if(productQuantities.get(i)<5){
                System.out.println("Low Stock: "+productNames.get(i));
            }
        }
        //2. Products that are out of stock (quantity == 0).
        for(int i = 0; i<productNames.size(); i++){
            if(productQuantities.get(i).equals(0)){
                System.out.println("Out of Stock: "+productNames.get(i));
            }
        }

        //3. Products with available stock.
        for(int i = 0; i<productNames.size(); i++){
            if(productQuantities.get(i)>= 5){
                System.out.println("Highest Stock: "+productNames.get(i));
            }
        }

        //Remove Product
        //1.Remove product by index
        IO.println("Please enter product you want to remove by index: ");
        int removePro= Integer.parseInt(IO.readln());
        if (removePro >= 0 && removePro < productNames.size()) {
            String removedName = productNames.remove(removePro);
            productQuantities.remove(removePro);
            productPrices.remove(removePro);
            System.out.println("Product " + removedName + " removed successfully");
        } else {
            System.out.println("Product not found");
        }

        //Sorting Products
        //1. Sort products by name alphabetically.
        ArrayList<String>sortedProName = new ArrayList<>(productNames);
        Collections.sort(sortedProName);
        System.out.println("Sorted Product name: "+sortedProName);

        //2. Sort products by price from lowest to highest
        ArrayList<Double>sortedProPrice = new ArrayList<>(productPrices);
        Collections.sort(sortedProPrice);
        System.out.println("Sorted Product price"+ productPrices.reversed());
    }
}
