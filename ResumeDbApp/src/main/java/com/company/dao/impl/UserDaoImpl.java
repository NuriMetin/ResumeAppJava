package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                users.add(new User(id, name, surname, phone, email));
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM user WHERE id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int idFromDb = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                user = new User(idFromDb, name, surname, phone, email);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE user SET name=? WHERE id=?");
            stmt.setString(1, u.getName());
            stmt.setInt(2, u.getId());
            return stmt.execute();
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("DELETE user WHERE id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
}
