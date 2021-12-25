package com.company.main;

import com.company.dao.inter.*;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

public class Main {

    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();
        UserSkillDaoInter userSkillDao=Context.instanceUserSkillDao();
        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        CountryDaoInter countryDao=Context.instanceCountryDao();
        SkillDaoInter skillDao=Context.instanceSkillDao();

        try {
            User user = userDao.getById(1);
            Skill skill=skillDao.getAll().get(1);
            UserSkill userSkill=new UserSkill(3,user,skill,7);
            userSkillDao.updateUserSkill(userSkill);
            System.out.println(userSkill);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
        }


    }
}
