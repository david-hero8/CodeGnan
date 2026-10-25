package com.java.CustomerManagement;

public class Main {

    public static void main(String[] args) {

        CustomerOperations operations = new CustomerOperations();

        // 1. Display all initial customers
        System.out.println("Initial Customers:");
        for (Customer customer : operations.getCustomers()) {
            System.out.println(customer);
        }

        // 2. Add a new customer
        System.out.println("\nAdding Customer 106:");
        boolean added = operations.addCustomer(
                106, "Ananya", "Verma", 'F');
        System.out.println("Customer added: " + added);

        // 3. Attempt to add the same customer again
        System.out.println("\nAdding Duplicate Customer:");
        boolean duplicate = operations.addCustomer(
                106, "Ananya", "Verma", 'F');
        System.out.println("Customer added: " + duplicate);

        // 4. Update customer 103
        System.out.println("\nUpdating Customer 103:");
        boolean updated = operations.updateCustomer(
                103, "Arjun", "Reddy", 'M');
        System.out.println("Customer updated: " + updated);

        // 5. Delete customer 104
        System.out.println("\nDeleting Customer 104:");
        boolean deleted = operations.deleteCustomer(104);
        System.out.println("Customer deleted: " + deleted);

        // 6. Find customer by ID
        System.out.println("\nFinding Customer ID 102:");
        Customer customer = operations.findCustomerById(102);

        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }

        // 7. Find customer by first name
        System.out.println("\nFinding Customer First Name Kiran:");
        customer = operations.findCustomerByFirstname("Kiran");

        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }

        // 8. Search for a nonexistent customer
        System.out.println("\nFinding Customer ID 999:");
        customer = operations.findCustomerById(999);

        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer ID 999 does not exist.");
        }

        // 9. Display all customers after operations
        System.out.println("\nFinal Customer List:");
        for (Customer c : operations.getCustomers()) {
            System.out.println(c);
        }
    }
}