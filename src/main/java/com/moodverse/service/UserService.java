package com.moodverse.service;

public class UserService {
    private static UserService userService;

    public static UserService getUserService(){
        if (userService == null){
            userService = new UserService();
        }
        return userService;
    }

    private UserService() {}


}