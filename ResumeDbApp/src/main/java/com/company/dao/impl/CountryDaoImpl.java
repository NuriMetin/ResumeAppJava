package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    @Override
    public List<Country> getAll() {
        List<Country> countries=new ArrayList<Country>();

        try(Connection c=connect()){

            Statement stmt=c.createStatement();
            stmt.execute("SELECT * from country");

            ResultSet rs=stmt.getResultSet();
            while (rs.next()){
                Country country=getCountry(rs);
                countries.add(country);
            }
        }
        catch (Exception exp){
            exp.printStackTrace();
        }

        return countries;
    }

    private Country getCountry(ResultSet rs) throws Exception{
        int id=rs.getInt("id");
        String name=rs.getString("name");
        String nationality=rs.getString("nationality");

        return new Country(id,name,nationality);
    }
}
