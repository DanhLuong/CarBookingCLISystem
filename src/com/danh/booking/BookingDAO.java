package com.danh.booking;

import com.danh.FindResult;
import com.danh.ObjectDAO;
import com.danh.vehicle.car.Car;
import com.danh.vehicle.car.CarType;

import java.math.BigDecimal;
import java.util.UUID;

public class BookingDAO implements ObjectDAO<Booking> {
    public static Booking[] bookingList;
    private static int currentEmptyIndex = 0;

    static {
        bookingList = new Booking[20];
        currentEmptyIndex = 0;
    }

    @Override
    public Booking[] getAllObjects() {
        return bookingList;
    }

    @Override
    public FindResult<Booking> findObject(UUID uuid) {
        for (int i=0;i<currentEmptyIndex;i++) {
            if (bookingList[i]!=null&&bookingList[i].getBookingId().equals(uuid)) {
                return new FindResult<>(true, bookingList[i], i);
            }
        }
        System.out.println("No Such Booking");
        return new FindResult<>(false, null, -1);
    }

    @Override
    public void addObject(Booking booking) {
        bookingList[currentEmptyIndex] = booking;
        currentEmptyIndex++;
        System.out.println("Added Successfully");
    }

    @Override
    public void updateObject(UUID uuid, Booking booking) {
        for (Booking book : bookingList) {
            if (book!=null&&book.getBookingId().equals(uuid)) {
                book = booking;
                System.out.println("Updated successfully");
            }
        }
        System.out.println("Can not Update");
    }

    @Override
    public void deleteObject(UUID uuid) {
        for (Booking book : bookingList) {
            if (book!=null&&book.getBookingId().equals(uuid)) {
                UUID deletedId = book.getBookingId();
                book = null;
                System.out.println("Booking ID deleted: " + deletedId.toString());
            }
        }
    }
}
