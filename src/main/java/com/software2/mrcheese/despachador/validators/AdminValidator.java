/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.validators;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author hhade
 */
public class AdminValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin) target;        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "required.nombre", "Ingrese el email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Ingrese la contraseña");

        List<Admin> datos = data(admin);
        if(datos.isEmpty()){
            errors.reject("invalid-user", "La contraseña o el correo no son correctos");
        }
        
    }
    
    /**
     * Busca los admins con el correo y el password pasados
     * @param admin Admin que se valida
     * @return Lista con 1 o 0 admins
     */
    private List<Admin> data(Admin admin){
        Conectar con = new Conectar();
        JdbcTemplate template = new JdbcTemplate(con.conectar());
        
        String sql = "SELECT id, email, password FROM \"public\".\"Admin\" "
                + "WHERE email = ? AND password = ?";
        List<Admin> datos = template.query(sql,
                new Object[]{admin.getEmail(), admin.getPassword()},
                new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        });
        return datos;
    }
}
