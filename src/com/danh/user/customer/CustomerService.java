package com.danh.user.customer;

import com.danh.FindResult;
import com.danh.vehicle.car.Car;

import java.util.UUID;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();


    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void registerCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Can not register null");
        } else {
            customerDAO.addObject(customer);
        }
    }

    public void changeCustomerInformation(UUID customerId, Customer customer) {
        if (customer == null) {
            System.out.println("Can not update null");
        } else {
            customerDAO.updateObject(customerId, customer);
        }
    }

    public Customer[] getAllCustomer() {
        return customerDAO.getAllObjects();
    }

    public FindResult findCustomer(UUID customerId) {
        return customerDAO.findObject(customerId);
    }

    public void deleteCustomer(UUID customerId) {
        customerDAO.deleteObject(customerId);
    }
}

