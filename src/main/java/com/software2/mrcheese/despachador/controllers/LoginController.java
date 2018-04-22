/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.models.Admin;
import com.software2.mrcheese.despachador.models.AdminMapper;
import com.software2.mrcheese.despachador.models.Conectar;
import com.software2.mrcheese.despachador.validators.AdminValidator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
    private JdbcTemplate jdbcTemplate;


    public LoginController() {
        this.validator = new AdminValidator();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("admin", new Admin());
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String index(@ModelAttribute("admin") Admin admin, BindingResult result, SessionStatus status){
        this.validator.validate(admin, result);
        String sql= "SELECT id, email, password FROM \"public\".\"Admin\" WHERE email = ? AND password = ?";
        //PreparedStatementCreator sql = ;
       /* List datos = this.jdbcTemplate.queryForList(sql,
                new Object[]{admin.getEmail(), admin.getPassword()}, Admin.class);*/
        List<Admin> datos = this.jdbcTemplate.query(sql,
                new Object[]{admin.getEmail(), admin.getPassword()},
                new AdminMapper());
        return datos.isEmpty() == true ? "index" : "main";
        //return "main";
    }
    
    
    //Este método es de prueba, no tiene nada que ver con la aplicación, y será borrado después
    /*@RequestMapping(value="main.htm")
    public String main(){
        return "main";
    }*/
}
