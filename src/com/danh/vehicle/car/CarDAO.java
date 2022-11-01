package com.danh.vehicle.car;

import com.danh.FindResult;
import com.danh.ObjectDAO;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO implements ObjectDAO<Car> {
    public static Car[] carList;
    public static int currentEmptyIndex = 0;

    static {
        Car[] original = new Car[]{
                new Car(
                        UUID.fromString("6f356e6e-db27-4cde-8978-21a1cf7e0fe1"),
                        "TESLA",
                        "Model X",
                        new BigDecimal("1000000"),
                        "Orange",
                        CarType.ELECTRIC
                ),
                new Car(
                        UUID.fromString("2e2b811b-bec9-4221-be4a-afd5c33ec091"),
                        "TESLA",
                        "CyberTruck",
                        new BigDecimal("2000000"),
                        "Steel",
                        CarType.ELECTRIC
                ),
                new Car(
                        UUID.fromString("2de0b031-3169-43c8-9f6d-604354255a0f"),
                        "AUDI",
                        "Q5",
                        new BigDecimal("1500000"),
                        "Blue",
                        CarType.HYBRID
                ),
                new Car(
                        UUID.fromString("974a8943-1dba-4761-a587-22aad670989b"),
                        "HONDA",
                        "Accord",
                        new BigDecimal("500000"),
                        "Red",
                        CarType.HYBRID
                ),
                new Car(
                        UUID.fromString("9453d0fc-e356-4a6c-82ec-7093430a456f"),
                        "BMW",
                        "X1",
                        new BigDecimal("1000000"),
                        "Blue",
                        CarType.COMBUSTION
                ),
                new Car(
                        UUID.fromString("f6830677-653a-4dab-8e82-bd1a5a77ac9c"),
                        "TOYOTA",
                        "Land Cruiser",
                        new BigDecimal("800000"),
                        "White",
                        CarType.COMBUSTION
                ),
                new Car(
                        UUID.fromString("3727c7bf-9c74-4044-9e1f-834c3e6985bf"),
                        "FORD",
                        "Ranger XL",
                        new BigDecimal("100000"),
                        "Orange",
                        CarType.COMBUSTION
                ),
        };
        carList = new Car[20];
        currentEmptyIndex = original.length - 1;
        for (int i = 0; i < original.length; i++) {
            carList[i] = original[i];
        }

    }

    @Override
    public Car[] getAllObjects() {
        return carList;
    }

    @Override
    public FindResult<Car> findObject(UUID uuid) {
        for (int i = 0; i < currentEmptyIndex; i++) {
            if (carList[i] != null && carList[i].getId().equals(uuid)) {
                return new FindResult<>(true, carList[i], i);
            }
        }
        System.out.println("No Such Car");
        return new FindResult<>(false, null, -1);
    }

    @Override
    public void addObject(Car car) {
        carList[currentEmptyIndex] = car;
        currentEmptyIndex++;
        System.out.println("Added Successfully");
    }

    @Override
    public void updateObject(UUID uuid, Car car) {
        for (Car ca : carList) {
            if (ca != null && ca.getId().equals(uuid)) {
                ca = car;
                System.out.println("Updated successfully");
            }
        }
        System.out.println("Can not Update");
    }

    @Override
    public void deleteObject(UUID uuid) {
        for (Car car : carList) {
            if (car != null && car.getId().equals(uuid)) {
                UUID deletedId = car.getId();
                Car emptyCar = new Car(
                        null,
                        "",
                        "",
                        new BigDecimal("0"),
                        "",
                        null
                );
                car = emptyCar;
                System.out.println("Car ID deleted: " + deletedId.toString());
            }
        }
    }
}
