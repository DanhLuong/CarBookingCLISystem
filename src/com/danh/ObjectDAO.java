package com.danh;

import com.danh.vehicle.Vehicle;
import com.danh.vehicle.car.Car;

import java.util.UUID;

public interface ObjectDAO<T> {
    T[] getAllObjects();

    FindResult findObject(UUID uuid);

    void addObject(T t);

    void updateObject(UUID uuid, T t);

    void deleteObject(UUID uuid);

}
