package com.company.dao.inter;

import com.company.entity.Skill;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {

    public List<UserSkill> getAllSkillsByUserId(int userId);

    public boolean deleteUserSkill(int id);
    public boolean insertUserSkill(UserSkill userSkill);
    public boolean updateUserSkill(UserSkill userSkill);
}
