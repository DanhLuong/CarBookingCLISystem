package com.danh.booking;

import com.danh.user.User;
import com.danh.vehicle.car.Car;

import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private UUID customerId;
    private UUID carId;
    private boolean isExpired;

    public Booking(UUID customerId, UUID carId) {
        this.bookingId = UUID.randomUUID();
        this.customerId = customerId;
        this.carId = carId;
        this.isExpired=false;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", isExpired=" + isExpired +
                '}';
    }
}
