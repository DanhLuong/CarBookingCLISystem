package com.danh.user.admin;

import com.danh.FindResult;

import java.util.UUID;

public class AdminService {
    private AdminDAO adminDAO = new AdminDAO();
    private FindResult<Admin> tempResult;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
        this.tempResult = new FindResult<>(false, null, -1);
    }

    public FindResult<Admin> getTempResult() {
        return tempResult;
    }

    public void registerAdmin(Admin admin) {
        if (admin == null) {
            System.out.println("Can not register null");
        } else {
            adminDAO.addObject(admin);
        }
    }

    public void changeAdminInformation(UUID uuid, Admin admin) {
        if (admin == null) {
            System.out.println("Can not update null");
        } else {
            adminDAO.updateObject(uuid, admin);
        }
    }

    public Admin[] getAllCustomer() {
        return adminDAO.getAllObjects();
    }

    public void find(UUID uuid) {
        this.tempResult = adminDAO.findObject(uuid);
    }

    public void deleteAdmin(UUID uuid) {
        adminDAO.deleteObject(uuid);
    }
}
