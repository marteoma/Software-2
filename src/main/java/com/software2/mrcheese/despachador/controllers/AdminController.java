/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hhade
 */
@Controller
public class AdminController {
    
    @RequestMapping("mensajeros.htm")
    public ModelAndView mensajeros(){
        return new ModelAndView();
    }
    
    @RequestMapping("pedidos.htm")
    public ModelAndView pedidos(){
        return new ModelAndView();
    }
    
    @RequestMapping("despachos.htm")
    public ModelAndView despachos(){
        return new ModelAndView();
    }    
}
