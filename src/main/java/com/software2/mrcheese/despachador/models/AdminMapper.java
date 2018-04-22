/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author hhade
 */
public class AdminMapper implements RowMapper<Admin>{

    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
    }
    
}
