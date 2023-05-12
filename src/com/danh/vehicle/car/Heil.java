package com.danh.vehicle.car;

import com.danh.vehicle.DealWithSpeed;
import com.danh.vehicle.HaveEngine;
import com.danh.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Heil extends Vehicle implements DealWithSpeed, HaveEngine {
    private final String TYPE = "CAR";

    private String color;
    private CarType engineType;
    private boolean isMaintained;

    private LocalDate maintenanceDate;
    private int speed;

    public Heil(UUID id, String manufacturer, String model, BigDecimal price, String color, CarType type) {
        super(id, manufacturer, model, price);
        this.color = color;
        this.engineType = type;
        this.isMaintained = false;
        this.maintenanceDate=null;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getEngineType() {
        return engineType;
    }

    public void setEngineType(CarType engineType) {
        this.engineType = engineType;
    }

    public boolean isMaintained() {
        return isMaintained;
    }

    public void setMaintained(boolean maintained) {
        isMaintained = maintained;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public void startUp(int amount) {
        System.out.println("start up engine");
        System.out.println("accelerate...");
        speed += amount;
    }

    @Override
    public int getCurrentSpeed() {
        return speed;
    }

    @Override
    public void applyBreak(int amount) {
        System.out.println("slowing down...");
        speed -= amount;
    }

    @Override
    public void checkEngine() {
        System.out.println("checking " + engineType + " " + TYPE);
    }

    @Override
    public void mantainance() {
        System.out.println("mantainance " + engineType + " " + TYPE);
    }

    @Override
    public LocalDate mantainanceDate() {
        return this.maintenanceDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineType=" + engineType +
                "} " + super.toString();
    }
}

