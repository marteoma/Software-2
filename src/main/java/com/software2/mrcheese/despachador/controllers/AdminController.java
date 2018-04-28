/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hhade
 */
@Controller
public class AdminController {
    
    private JdbcTemplate jdbcTemplate;
    
    public AdminController(){
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping("mensajeros.htm")
    public ModelAndView mensajeros(){
        return new ModelAndView();
    }
    
    @RequestMapping("pedidos.htm")
    public ModelAndView pedidos(){
        ModelAndView mav = new ModelAndView();
        String sql= "SELECT * FROM public.pedido ORDER BY id_pedido ASC ";
        List datos = this.jdbcTemplate.queryForList(sql); 
        mav.addObject("datos", datos);
        mav.setViewName("pedidos");
        return  mav;
        
    }
  
    
    @RequestMapping("despachos.htm")
    public ModelAndView despachos(){
        return new ModelAndView();
    }        
}
