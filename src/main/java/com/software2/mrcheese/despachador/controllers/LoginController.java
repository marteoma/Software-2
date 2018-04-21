/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.models.Admin;
import com.software2.mrcheese.despachador.validators.AdminValidator;
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

    public LoginController() {
        this.validator = new AdminValidator();
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
        return "main";
    }
    
    
    //Este método es de prueba, no tiene nada que ver con la aplicación, y será borrado después
    /*@RequestMapping(value="main.htm")
    public String main(){
        return "main";
    }*/
}
