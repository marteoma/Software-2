/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.models.Admin;
import com.software2.mrcheese.despachador.models.Conectar;
import com.software2.mrcheese.despachador.validators.AdminValidator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hhade
 */
@Controller
@RequestMapping("index.htm")
public class LoginController {

    private AdminValidator validator;
    private JdbcTemplate template;
    
    
    public LoginController() {
        this.validator = new AdminValidator();
        Conectar con = new Conectar();
        this.template = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("admin", new Admin());
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("admin") Admin admin, BindingResult result, SessionStatus status) {
        this.validator.validate(admin, result);

        if (result.hasErrors()) {
            return new ModelAndView("index").addObject("admin", new Admin());
        } else {
            String sql = "SELECT id, email, password FROM \"public\".\"Admin\" "
                    + "WHERE email = ? AND password = ?";
            List<Admin> datos = this.template.query(sql,
                    new Object[]{admin.getEmail(), admin.getPassword()},
                    new RowMapper<Admin>() {
                @Override
                public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            });
            return datos.isEmpty() == true ?
                    new ModelAndView("index").addObject("admin", new Admin()) ://.addObject("error", "Usuario incorrecto"):
                    new ModelAndView("main");
        }

        //return "main";
    }

}
