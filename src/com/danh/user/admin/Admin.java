package com.danh.user.admin;

import com.danh.user.AdminExt;
import com.danh.user.User;

import java.util.UUID;

public class Admin extends User implements AdminExt {
    private String experience;


    public Admin(UUID userId, String name, String email, String experience) {
        super(userId, name, email);
        this.experience = experience;
    }

    @Override
    public void performAdminTask() {
        System.out.println("Admin " + this.getName() + " do some admin tasks");
    }

    @Override
    public String toString() {
        return "Admin{" +
                "experience='" + experience + '\'' +
                "} " + super.toString();
    }
}
