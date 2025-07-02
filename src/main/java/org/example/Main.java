package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        boolean active = true;
        while(active){
            System.out.println("\n");
            printOrders(pizzas, quantities);

            System.out.println("\n1. Add order");
            System.out.println("2. Update order");
            System.out.println("3. Remove order");
            System.out.println("4. View orders");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1: // Add order
                    System.out.print("Pizza type: ");
                    String pizzaType = sc.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;

                case 2: // Update order
                    System.out.print("Order number to update: ");
                    int updateIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    System.out.print("New quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    updateOrder(quantities, updateIndex, newQuantity);
                    break;

                case 3: // Remove order
                    System.out.print("Enter order number to delete: ");
                    int removeIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    removeOrder(pizzas, quantities, removeIndex);
                    break;

                case 4: // Print orders
                    printOrders(pizzas, quantities);
                    break;

                case 5: // Exit
                    System.out.println("Thank you!");
                    active = false;
            }
        }
    }

    public static void addOrder (
        ArrayList<String> pizzas,
        ArrayList<Integer> quantities,
        String pizzaType,
        int quantity) {
            if (quantity > 0) {
                pizzas.add(pizzaType);
                quantities.add(quantity);
            } else {
                System.out.println("Invalid quantity value");
            }
    }

    public static void updateOrder(
        ArrayList<Integer> quantities,
        int index,
        int newQuantity) {
            if (newQuantity > 0 && index >= 0 && index < quantities.size()){
                quantities.set(index, newQuantity);
            } else {
                System.out.println("Invalid input");
            }
    }

    public static void removeOrder(
            ArrayList<String> pizzas,
            ArrayList<Integer> quantities,
        int index) {
            if (index >= 0 && index < quantities.size()){
                pizzas.remove(index);
                quantities.remove(index);
            } else{
                System.out.println("Invalid input");
            }
    }

    public static void printOrders(
        ArrayList<String> pizzas,
        ArrayList<Integer> quantities) {
            if (pizzas.isEmpty()) {
                return;
            }
            System.out.println("---- Current Orders ----");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("Order #%d: %s x %d\n", i + 1, pizzas.get(i), quantities.get(i));
        }
    }
}