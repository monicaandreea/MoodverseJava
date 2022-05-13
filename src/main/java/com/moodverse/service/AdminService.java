package com.moodverse.service;

public class AdminService {
    private static AdminService adminService;

    public static AdminService getAdminService(){
        if (adminService == null){
            adminService = new AdminService();
        }
        return adminService;
    }

    private AdminService() {}

}
