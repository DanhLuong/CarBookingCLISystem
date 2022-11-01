package com.danh;

import com.danh.booking.Booking;
import com.danh.booking.BookingDAO;
import com.danh.booking.BookingService;
import com.danh.user.customer.Customer;
import com.danh.user.customer.CustomerDAO;
import com.danh.user.customer.CustomerService;
import com.danh.vehicle.car.Car;
import com.danh.vehicle.car.CarDAO;
import com.danh.vehicle.car.CarService;
import com.danh.vehicle.car.CarType;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();
        CarDAO carDAO = new CarDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        CarService carService = new CarService(carDAO);
        CustomerService customerService = new CustomerService(customerDAO);
        BookingService bookingService = new BookingService(bookingDAO, carService, customerService);
        final String welcome = "1️⃣ - Book Car\n" +
                "2️⃣ - View All User Booked Cars\n" +
                "3️⃣ - View All Bookings\n" +
                "4️⃣ - View Available Cars\n" +
                "5️⃣ - View Available Electric Cars\n" +
                "6️⃣ - View all users\n" +
                "7️⃣ - Exit";
        int option = 0;
        String string;
        String stringCustomerId;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, please choose servies:\n" + welcome);
        Customer[] customers = customerService.getAllCustomer();
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.println(customer.toString());
            }
        }
        System.out.print("Your ID: ");
        stringCustomerId = scan.nextLine();
        do {
            System.out.print("Your Command: ");
            try {
                string = scan.nextLine();
                option = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("PLease choose number within range 1:7");
                e.printStackTrace();
                option = 1;
            }

            if (option < 1 || option > 7) {
                System.out.println("PLease choose number within range 1:7");
                option = 0;
            }

            switch (option) {
                case 1:
                    System.out.print("Please insert your car ID: ");
                    String temp = scan.nextLine();
                    bookingService.makeBooking(UUID.fromString(stringCustomerId), UUID.fromString(temp));
                    break;
                case 2:
                    System.out.println("All customers booked car: ");
                    Customer[] customers1 = customerService.getAllCustomer();
                    for (Customer customer : customers1) {
                        if (customer!=null&&customer.isBookedCar()) {
                            if (customer != null) {
                                System.out.println(customer.toString());
                            }

                        }
                    }
                    break;
                case 3:
                    System.out.println("All booking information: ");
                    Booking[] bookings = bookingService.getAllBooking();
                    for (Booking booking : bookings) {
                        if (booking!=null&&booking != null) {
                            System.out.println(booking.toString());
                        }

                    }
                    break;
                case 4:
                    System.out.println("All available cars:");
                    Car[] cars = carService.getAllCar();
                    for (Car car : cars) {
                        if (car != null && !car.isBooked()) {
                            System.out.println(car.toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("All available Electric cars:");
                    Car[] cars1 = carService.getAllCar();
                    for (Car car : cars1) {
                        if (car != null && !car.isBooked() && car.getEngineType() == CarType.ELECTRIC) {
                            System.out.println(car.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("All Customers: ");
                    Customer[] customers2 = customerService.getAllCustomer();
                    for (Customer customer : customers2) {
                        if(customer!=null) {
                            System.out.println(customer.toString());
                        }
                    }
                    break;
                case 7:
                    break;
            }
        } while (option != 7);
        System.out.println("Hope you have a nice day! See you");
    }
}
