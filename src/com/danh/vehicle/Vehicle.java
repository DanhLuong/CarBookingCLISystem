package com.danh.vehicle;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Vehicle {
    private UUID id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private boolean isBooked;

    public Vehicle() {
    }

    public Vehicle(UUID id, String manufacturer, String model, BigDecimal price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        isBooked = false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(model, vehicle.model) && Objects.equals(price, vehicle.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, price);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}
