package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<Skill>();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from skill");

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill skill = getSkill(rs);
                skills.add(skill);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return skills;
    }

    @Override
    public Skill getSkillById(int id) {
        Skill skill = null;

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from skill where id=" + id);

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                skill = getSkill(rs);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return skill;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO skill(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, skill.getName());
            result = stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE skill set name=? where id=?");
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            result = stmt.execute();

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(id, name);
    }

}
