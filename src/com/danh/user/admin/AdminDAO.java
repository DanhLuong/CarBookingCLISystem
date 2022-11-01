package com.danh.user.admin;

import com.danh.FindResult;
import com.danh.ObjectDAO;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class AdminDAO implements ObjectDAO<Admin> {
    public static Admin[] adminList;
    private static int currentEmptyIndex = 0;

    static {
        Admin[] original = new Admin[]{
                new Admin(
                        UUID.fromString("129b5e30-21b4-47e5-a11a-352c122cf8dd"),
                        "LeadBeater",
                        "leadb126@gmail.com",
                        "5 years Admin"
                ),
                new Admin(
                        UUID.fromString("57d22cee-3eaa-4728-9b92-e062f56f4340"),
                        "Kim",
                        "kimdan@booking.com",
                        "2 years Admin"
                )
        };
        adminList = new Admin[20];
        currentEmptyIndex = original.length - 1;
        for (int i = 0; i < original.length; i++) {
            adminList[i] = original[i];
        }
    }

    @Override
    public Admin[] getAllObjects() {
        return adminList;
    }

    @Override
    public FindResult<Admin> findObject(UUID uuid) {
        for (int i=0;i<currentEmptyIndex;i++) {
            if (adminList[i].getUserId().equals(uuid)) {
                return new FindResult<>(true, adminList[i], i);
            }
        }
        System.out.println("No Such Car");
        return new FindResult<>(false, null, -1);
    }

    @Override
    public void addObject(Admin admin) {
        adminList[currentEmptyIndex] = admin;
        currentEmptyIndex++;
        System.out.println("Added successfully");
    }

    @Override
    public void updateObject(UUID uuid, Admin admin) {
        for (Admin ad : adminList) {
            if (ad.getUserId().equals(uuid)) {
                ad = admin;
                System.out.println("Updated Successfully");
            }
        }
        System.out.println("Can not Update");
    }

    @Override
    public void deleteObject(UUID uuid) {
        for (Admin admin : adminList) {
            if (admin.getUserId().equals(uuid)) {
                UUID deletedId = admin.getUserId();
                Admin emptyAdmin = new Admin(
                        null,
                        "",
                        "",
                        ""
                );
                admin = emptyAdmin;
                System.out.println("Car ID deleted: " + deletedId.toString());
            }
        }
    }
}
