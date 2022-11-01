package com.danh.user.customer;

import com.danh.user.CustomerExt;
import com.danh.user.User;

import java.time.LocalDate;
import java.util.UUID;

public class Customer extends User implements CustomerExt {
    private boolean isBookedCar;
    private LocalDate joinedDate;
    private boolean isVIPMember;

    public Customer(UUID userId, String name, String email, LocalDate joinedDate) {
        super(userId, name, email);
        this.joinedDate = joinedDate;
        this.isVIPMember=false;
        this.isBookedCar=false;
    }

    public boolean isBookedCar() {
        return isBookedCar;
    }

    public void setBookedCar(boolean bookedCar) {
        isBookedCar = bookedCar;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public boolean isVIPMember() {
        return isVIPMember;
    }

    public void setVIPMember(boolean VIPMember) {
        isVIPMember = VIPMember;
    }

    @Override
    public void choosePaymentMethod() {
        System.out.println("Customer "+ this.getName()+" choose payment Method");
    }

    @Override
    public void makePayment() {
        System.out.println("Customer "+ this.getName()+" make payment");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "joinedDate=" + joinedDate +
                "} " + super.toString();
    }
}
