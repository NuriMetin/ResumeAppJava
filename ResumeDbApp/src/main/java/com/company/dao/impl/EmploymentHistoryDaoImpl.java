package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.EmploymentHistory;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> employmentHistories=new ArrayList<EmploymentHistory>();
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("SELECT * FROM employment_history\n" +
                    "WHERE user_id=?");

            stmt.setInt(1,userId);
            stmt.execute();

            ResultSet rs=stmt.getResultSet();
            while (rs.next()){
                EmploymentHistory employmentHistory=getEmploymentHistory(rs);
                employmentHistories.add(employmentHistory);
            }
        }

        catch (Exception exp) {
            exp.printStackTrace();
        }
        return employmentHistories;
    }

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws  Exception{
        int id=rs.getInt("id");
        String header=rs.getString("header");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId=rs.getInt("user_id");
        return new EmploymentHistory(id,header,beginDate,endDate,jobDescription,new User(userId));
    }
}
