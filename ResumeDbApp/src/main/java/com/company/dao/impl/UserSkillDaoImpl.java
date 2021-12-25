package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillsByUserId(int userId) {
        List<UserSkill> userSkills = new ArrayList<UserSkill>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT \n"
                    + "						us.id,\n"
                    + "                        u.id user_id,\n"
                    + "                        u.name,\n"
                    + "                        u.surname,\n"
                    + "                        u.email,\n"
                    + "                        u.phone,\n"
                    + "                        u.profileDescription,\n"
                    + "                        u.address,\n"
                    + "                        u.birthdate,\n"
                    + "                        u.birthplace_id,\n"
                    + "                        u.nationality_id,\n"
                    + "                        us.skill_id, \n"
                    + "                        s.name skill_name, \n"
                    + "                        us.power\n"
                    + "                    FROM\n"
                    + "                        user_skill us\n"
                    + "                   LEFT JOIN users u ON u.id = us.user_id\n"
                    + "                   LEFT JOIN skill s ON s.id = us.skill_id\n"
                    + "                    WHERE u.id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill userSkill = getUserSkill(rs);
                userSkills.add(userSkill);
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return userSkills;
    }

    public boolean deleteUserSkill(int id) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("DELETE FROM resume.user_skill WHERE id=?");
            stmt.setInt(1, id);
            stmt.execute();
            result = true;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        int userId = rs.getInt("user_id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        return new UserSkill(id, new User(userId), new Skill(skillId, skillName), power);
    }

    public boolean insertUserSkill(UserSkill userSkill) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO resume.user_skill (user_id, skill_id, power) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userSkill.getUser().getId());
            stmt.setInt(2, userSkill.getSkill().getId());
            stmt.setInt(3, userSkill.getPower());
            result = stmt.execute();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }

    public boolean updateUserSkill(UserSkill userSkill) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE resume.user_skill SET user_id=?, skill_id=?, power=? where id=?");
            stmt.setInt(1, userSkill.getUser().getId());
            stmt.setInt(2, userSkill.getSkill().getId());
            stmt.setInt(3, userSkill.getPower());

            stmt.setInt(4, userSkill.getId());
            
            result = stmt.execute();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }
}
