package com.moodverse.service;

public class AdminService {
    private static AdminService adminService;
    private AdminService() {}

    public static AdminService getAdminService(){
        if (adminService == null){
            adminService = new AdminService();
        }
        return adminService;
    }

}
