package com.danh.booking;


import com.danh.FindResult;
import com.danh.user.customer.Customer;
import com.danh.user.customer.CustomerDAO;
import com.danh.user.customer.CustomerService;
import com.danh.vehicle.car.Car;
import com.danh.vehicle.car.CarDAO;
import com.danh.vehicle.car.CarService;

import java.awt.print.Book;
import java.util.UUID;

public class BookingService {

    private BookingDAO bookingDAO;
    private CarService carService;
    private CustomerService customerService;

    public BookingService(BookingDAO bookingDAO, CarService carService, CustomerService customerService) {
        this.bookingDAO = bookingDAO;
        this.carService = carService;
        this.customerService = customerService;
    }

    public void makeBooking(UUID customerId, UUID carId) {
        FindResult<Customer> customerResult = customerService.findCustomer(customerId);
        FindResult<Car> carResult = carService.findCar(carId);
        if (!customerResult.isExist()) {
            System.out.println("Customer does not exist");
        } else if (!carResult.isExist()) {
            System.out.println("Car does not exist");
        } else {
            Booking newBooking = new Booking(customerId, carId);
            bookingDAO.addObject(newBooking);
            Customer customer = customerResult.getT();
            customer.setBookedCar(true);
            customerService.changeCustomerInformation(customerId, customer);
            Car car = carResult.getT();
            car.setBooked(true);
            carService.changeCarInformation(carId, car);
            System.out.println("Thanks for booking, your car information:");
            System.out.println(car.toString());
        }

    }

    public void changeBookingData(UUID bookingId, UUID newCustomerId, UUID newCarId) {
        FindResult<Booking> bookingResult = bookingDAO.findObject(bookingId);
        Booking booking = bookingResult.getT();
        if (!bookingResult.isExist()) {
            System.out.println("booking ID does not exist, please try again");
        } else if (booking.getCustomerId().equals(newCustomerId) || booking.getCarId().equals(newCarId)) {
            System.out.println("booking data is not changed");
        } else {
            Booking newBooking = new Booking(newCustomerId, newCarId);
            bookingDAO.updateObject(bookingId, newBooking);
        }
    }

    public Booking[] getAllBooking() {
        return bookingDAO.getAllObjects();
    }

    public void expiredBooking(UUID uuid) {
        bookingDAO.findObject(uuid).getT().setExpired(true);
    }
}
