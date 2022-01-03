package com.company.resumewebapp;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.company.main.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metin.n
 */
@WebServlet(name = "SkillController", urlPatterns = {"/SkillController"})
public class SkillController extends HttpServlet {

    SkillDaoInter skillDao = Context.instanceSkillDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = "C";
        int id = Integer.valueOf(request.getParameter("id"));

        Skill skill = new Skill(id, name);
        skillDao.updateSkill(skill);
        
        response.sendRedirect("skill.jsp");
    }
}
