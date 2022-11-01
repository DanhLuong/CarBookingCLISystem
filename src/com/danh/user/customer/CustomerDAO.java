package com.danh.user.customer;

import com.danh.FindResult;
import com.danh.ObjectDAO;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class CustomerDAO implements ObjectDAO<Customer> {
    public static Customer[] customerList;
    private static int currentEmptyIndex = 0;

    static {
        Customer[] original = new Customer[]{
                new Customer(
                        UUID.fromString("ecd88e54-41c7-4e4c-9ceb-5b981c42777b"),
                        "John",
                        "john126@gmail.com",
                        LocalDate.of(2006, Month.MAY, 25)
                ),
                new Customer(
                        UUID.fromString("4cc8fa79-6c6e-4a97-a84f-930c80e351e4"),
                        "Bach",
                        "bachoven756@bac.com",
                        LocalDate.of(2010, Month.AUGUST, 12)
                ),
                new Customer(
                        UUID.fromString("9326744d-c639-42b4-a984-204bbfa99aef"),
                        "Dorothy",
                        "dorothy4658@outlook.com",
                        LocalDate.of(2017, Month.FEBRUARY, 1)
                )
        };
        customerList = new Customer[20];
        currentEmptyIndex = original.length - 1;
        for (int i = 0; i < original.length; i++) {
            customerList[i] = original[i];
        }
    }

    @Override
    public Customer[] getAllObjects() {
        return customerList;
    }

    @Override
    public FindResult<Customer> findObject(UUID uuid) {
        for (int i=0;i<currentEmptyIndex;i++) {
            if (customerList[i]!=null&&customerList[i].getUserId().equals(uuid)) {
                return new FindResult<>(true, customerList[i], i);
            }
        }
        System.out.println("No Such Car");
        return new FindResult<>(false, null, -1);
    }

    @Override
    public void addObject(Customer customer) {
        customerList[currentEmptyIndex]=customer;
        currentEmptyIndex++;
        System.out.println("Added successfully");
    }

    @Override
    public void updateObject(UUID uuid, Customer customer) {
        for(Customer cus: customerList) {
            if(cus!=null && cus.getUserId().equals(uuid)){
                cus=customer;
                System.out.println("Updated Successfully");
            }
        }
        System.out.println("Can not Update");
    }

    @Override
    public void deleteObject(UUID uuid) {
        for (Customer customer : customerList) {
            if (customer!=null&&customer.getUserId().equals(uuid)) {
                UUID deletedId = customer.getUserId();
                Customer emptyCustomer = new Customer(
                        null,
                        "",
                        "",
                        null
                );
                customer = emptyCustomer;
                System.out.println("Car ID deleted: " + deletedId.toString());
            }
        }
    }
}
