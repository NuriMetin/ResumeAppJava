package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profileDescription");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");

        int birthplaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String natioanlityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");

        Country nationality = new Country(nationalityId, null, natioanlityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, email, phone, profileDescription, address, birthdate, nationality, birthplace);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("\n"
                    + "SELECT \n"
                    + "\tu.*,\n"
                    + "    n.name as birthplace,\n"
                    + "    c.nationality as nationality\n"
                    + "FROM users u\n"
                    + "LEFT JOIN country n on n.id=u.birthplace_id \n"
                    + "LEFT JOIN country c on c.id=u.nationality_id");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User user = getUser(rs);
                users.add(user);
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
            PreparedStatement stmt = c.prepareStatement("\n"
                    + "SELECT \n"
                    + "\tu.*,\n"
                    + "    n.name as birthplace,\n"
                    + "    c.nationality as nationality\n"
                    + "FROM users u\n"
                    + "LEFT JOIN country n on n.id=u.birthplace_id \n"
                    + "LEFT JOIN country c on c.id=u.nationality_id\n"
                    + "WHERE u.id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                user = getUser(rs);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE users SET name=?, surname=?,email=?,phone=?, profileDescription=?,address=?,birthdate=?,birthplace_id=?,nationality_id=? WHERE id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getBirthPlace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());
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
