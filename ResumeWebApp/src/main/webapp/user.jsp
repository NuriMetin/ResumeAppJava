<%-- 
    Document   : user
    Created on : Jan 2, 2022, 10:49:19 PM
    Author     : metin.n
--%>
<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(1);
        %>
        <h1>Hello World!</h1
        <div>
            <form>
                <label>Name</label>
                <input type="text" value="<%=u.getName()%>">

                <label>Surname</label>
                <input type="text" value="<%=u.getSurname()%>">

                <label>Email</label>
                <input type="text" value="<%=u.getEmail()%>">
            </form>
        </div>
    </body>
</html>
