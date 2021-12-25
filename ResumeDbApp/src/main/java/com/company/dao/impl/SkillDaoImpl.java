package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {
    @Override
    public List<Skill> getAll() {
        List<Skill> skills=new ArrayList<Skill>();

        try(Connection c=connect()) {
            Statement stmt=c.createStatement();
            stmt.execute("SELECT * from skill");

            ResultSet rs=stmt.getResultSet();
            while (rs.next()){
                Skill skill=getSkill(rs);
                skills.add(skill);
            }
        }
        catch (Exception exp) {
            exp.printStackTrace();
        }

        return skills;
    }

    private Skill getSkill(ResultSet rs) throws Exception {
        int id=rs.getInt("id");
        String name=rs.getString("name");

        return new Skill(id,name);
    }
}
