package com.java.CustomerManagement;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerOperations {

    private HashSet<Customer> customers;

    public CustomerOperations() {
        customers = new HashSet<>();

        customers.add(new Customer(101, "Rahul", "Sharma", 'M'));
        customers.add(new Customer(102, "Priya", "Reddy", 'F'));
        customers.add(new Customer(103, "Arjun", "Kumar", 'M'));
        customers.add(new Customer(104, "Sneha", "Rao", 'F'));
        customers.add(new Customer(105, "Kiran", "Patel", 'M'));
    }

    public boolean addCustomer(int id, String firstname,
                               String lastname, char gender) {
        Customer customer = new Customer(
                id, firstname, lastname, gender);

        return customers.add(customer);
    }

    public boolean updateCustomer(int customerId, String firstname,
                                  String lastname, char gender) {
        Customer customer = findCustomerById(customerId);

        if (customer == null) {
            return false;
        }

        // Remove before modifying fields because HashSet uses hashCode().
        customers.remove(customer);

        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setGender(gender);

        customers.add(customer);
        return true;
    }

    public boolean deleteCustomer(int customerId) {
        Iterator<Customer> iterator = customers.iterator();

        while (iterator.hasNext()) {
            Customer customer = iterator.next();

            if (customer.getId() == customerId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public HashSet<Customer> getCustomers() {
        return new HashSet<>(customers);
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    public Customer findCustomerByFirstname(String firstname) {
        for (Customer customer : customers) {
            if (customer.getFirstname().equalsIgnoreCase(firstname)) {
                return customer;
            }
        }

        return null;
    }
}