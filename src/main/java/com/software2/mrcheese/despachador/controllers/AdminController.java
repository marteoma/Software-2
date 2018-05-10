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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author hhade
 */
@Controller
public class AdminController {

    static private String mensajero = "default";
    static private int pedido = 4;
    private JdbcTemplate jdbcTemplate;

    public AdminController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping("mensajeros.htm")
    public ModelAndView mensajeros() {
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT *"
                + "	FROM public.\"Mensajero\"\n"
                + "	ORDER BY id ASC";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("mensajeros");
        return mav;
    }

    @RequestMapping("pedidos.htm")
    public ModelAndView pedidos() {
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT * FROM public.\"Pedido\" ORDER BY id ASC ";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("pedidos");
        return mav;
    }
}
