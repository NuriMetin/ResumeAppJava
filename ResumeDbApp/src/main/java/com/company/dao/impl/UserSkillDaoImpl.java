package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {
    @Override
    public List<UserSkill> getAllSkillsByUserId(int userId) {
        List<UserSkill> userSkills=new ArrayList<UserSkill>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT \n" +
                    "    u.*, \n" +
                    "    us.skill_id, \n" +
                    "    s.name skill_name, \n" +
                    "    us.power\n" +
                    "FROM\n" +
                    "    user_skill us\n" +
                    "\tLEFT JOIN users u ON u.id = us.user_id\n" +
                    "\tLEFT JOIN skill s ON s.id = us.skill_id\n" +
                    "WHERE u.id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill userSkill=getUserSkill(rs);
                userSkills.add(userSkill);
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return userSkills;
    }

    private UserSkill getUserSkill(ResultSet rs) throws Exception{
        int userId =rs.getInt("id");
        int skillId=rs.getInt("skill_id");
        String skillName=rs.getString("skill_name");
        int power=rs.getInt("power");
        return new UserSkill(null, new User(userId),new Skill(skillId, skillName),power);
    }
}
