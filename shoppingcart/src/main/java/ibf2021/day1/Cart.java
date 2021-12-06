package ibf2021.day1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private static ArrayList<String> cart;

    public int cartSize() {
        return cart.size();
    }

    public void greeting() {
        System.out.println("Please select from the following options:");
        System.out.println("ADD/REMOVE/LIST/STOP");
    }

    public Cart() {
        cart = new ArrayList<String>();

    }

    public String listCart() {
        return cart.toString();
    }

    public boolean addItem(String item) {
        boolean success = true; // Set default outcome to true
        for (int i = 0; i < cart.size(); i++) { // Loop throught the cart
            if (cart.get(i).equals(item)) { // Check if item already exists in cart
                success = false; // Set outcome to false if found
            }
        }
        if (success) { // If duplicate is not found
            cart.add(item); // Add item to cart
        }
        return success; // Return outcome
    }

    public String deleteItem(int i) {
        String message;
            message = (cart.get(i) + " removed from cart");
            cart.remove(i);
        return message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        Cart ws = new Cart();
        // List<String> cart = new LinkedList<> ();
        // cart.add("apple"); cart.add("durian");

        ws.greeting();

        boolean workshopIsOpen = true;

        // ws.addToCart("Apple");

        while (workshopIsOpen) {
            Console cons = System.console();
            String input = cons.readLine();
            Scanner scan = new Scanner(input);

            // Scanner scan2 = new Scanner(System.console().readLine());

            switch (scan.next().toLowerCase()) { // reading first word from scanner and formatting
                case "add":
                    scan.useDelimiter(",");

                    while (scan.hasNext()) {
                        String newItem = scan.next().trim().toLowerCase();
                        if (ws.addItem(newItem)) {
                            System.out.println(newItem + " added");
                        } else {
                            System.out.println(newItem + " already exists");
                        }
                    }
                    break;

                case "remove":
                    // To Do: Check if there is an integer after the command
                    // Sanitize the integer for use in DeleteItem();
                    if (scan.hasNextInt()){
                        int index = scan.nextInt();
                       if (index <= cart.size() && index > 0){
                           index--;
                           System.out.println(ws.deleteItem(index));
                       }
                       else if(cart.isEmpty()){
                           System.out.println("Cart is empty");
                       }
                       else {
                           System.out.println("Index is out of range");
                       }
                    }
                    break;

                case "list":
                    //System.out.println("items in shopping carts are " + cart);
                    for (int i = 0; i < ws.cartSize(); i++) {
                        System.out.println((i + 1) + ". " + cart.get(i));
                    }
                    break;

                case "stop":
                    workshopIsOpen = false;
                    System.out.println("thank you come again");
                    break;
                default:

                    System.out.println("Wrong command, please try again");
                    break;
            }
            scan.close();
        }
    }
}
