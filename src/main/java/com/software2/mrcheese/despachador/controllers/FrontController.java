/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author hhade
 */

public class FrontController {
    @RequestMapping("main.htm")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        
        return mav;
    };
    
    @RequestMapping(value="main.htm",method=RequestMethod.POST)
    public String pasar(){
            return "main";
      }
}
