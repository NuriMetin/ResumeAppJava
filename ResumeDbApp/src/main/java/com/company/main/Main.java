package com.company.main;

import com.company.bean.User;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();

        User user= userDao.getById(1);
        System.out.println(user.toString());

        userDao.updateUser(new User(2, "Rifallll", "Ramazanov", "fgrf", "kjhf"));
        List<User> users = userDao.getAll();

        for (User u : users) {
            System.out.println(u.toString());
        }
    }
}
