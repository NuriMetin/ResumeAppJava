<%-- 
    Document   : skill
    Created on : Jan 2, 2022, 11:10:42 PM
    Author     : metin.n
--%>
<%@page import="java.util.List"%>
<%@page import="com.company.dao.inter.SkillDaoInter" %>
<%@page import="com.company.main.Context" %>
<%@page import="com.company.entity.Skill" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            SkillDaoInter skillDao = Context.instanceSkillDao();
            List<Skill> skills = skillDao.getAll();
        %>
        <h1>Hello World!</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <% for (Skill skill : skills) {%>
                <tr>
                    <td><%=skill.getId()%></td>
                    <td><%=skill.getName()%></td>
                    <td>
                        <form method="post" action="SkillController">
                            <input type="hidden" name="id" value="<%=skill.getId()%>">
                            <input type="submit" value="update">
                        </form>
                    </td>>
                </tr>
                <%}%>

            </tbody>
        </table>

    </body>
</html>
