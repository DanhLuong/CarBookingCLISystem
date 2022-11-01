package com.danh.vehicle.car;

import com.danh.FindResult;

import java.util.UUID;

public class CarService {
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void registerCar(Car car) {
        if (car == null) {
            System.out.println("Can not register null");
        } else {
            carDAO.addObject(car);
        }
    }

    public void changeCarInformation(UUID carId, Car car) {
        if (car == null) {
            System.out.println("Can not update null");
        } else {
            carDAO.updateObject(carId, car);
        }

    }

    public Car[] getAllCar() {
        return carDAO.getAllObjects();
    }

    public FindResult<Car> findCar(UUID carId) {
        return carDAO.findObject(carId);
    }

    public void deleteCar(UUID carId) {
        carDAO.deleteObject(carId);
    }

}
