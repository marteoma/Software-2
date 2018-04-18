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
public class FragmentsController {
    
    @RequestMapping("fragments/header.htm")
    public ModelAndView header(){
        return new ModelAndView();
    }
    
    @RequestMapping("fragments/nav.htm")
    public ModelAndView nav(){
        return new ModelAndView();
    }
    
    
}
