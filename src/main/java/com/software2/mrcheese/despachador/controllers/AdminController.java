/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Cliente;
import com.software2.mrcheese.despachador.models.Mensajero;
import com.software2.mrcheese.despachador.models.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class AdminController {
    static private String mensajero= "default";
    static private int pedido = 4 ;
    private JdbcTemplate jdbcTemplate;
    
    public AdminController(){
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping("mensajeros.htm")
    public ModelAndView mensajeros(){
        ModelAndView mav = new ModelAndView();
        String sql= "SELECT id, name, lastname, plate\n" +
"	FROM public.\"Mensajero\"\n" +
"	ORDER BY id ASC";
        List datos = this.jdbcTemplate.queryForList(sql); 
        mav.addObject("datos", datos);
        mav.setViewName("mensajeros");
        return  mav;
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
     /*
        ModelAndView mav = new ModelAndView();
        String sql= "SELECT id, name, lastname, plate\n" +
"	FROM public.\"Mensajero\"\n" +
"	ORDER BY id ASC";
         String sql2= "SELECT * FROM public.pedido ORDER BY id_pedido ASC ";
        List<Pedido> pedidos = pedido(); 
       
        List<Mensajero> mensajeros = mensajero();
        
        mav.addObject("mensajeros",mensajeros);
        mav.addObject("pedidos",pedidos);
        mav.addObject("pedido",pedido);
        mav.addObject("mensajero",mensajero);
        mav.setViewName("despachos");
        return mav;
       */
           return new ModelAndView();
    }       
    
}

