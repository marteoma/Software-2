/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Mensajero;
import com.software2.mrcheese.despachador.models.Pedido;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class AddController {

    private JdbcTemplate jdbcTemplate;

    public AddController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.GET)
    public ModelAndView mensajero() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("Mensajero", new Mensajero());
        return mav;
    }

    @RequestMapping(value = "addP.htm", method = RequestMethod.GET)
    public ModelAndView pedido() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addP");
        mav.addObject("Pedido", new Pedido());
        return mav;
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public ModelAndView mensajero(@ModelAttribute("Mensajero") Mensajero m,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request) {
        if (isNumeric(m.getNombre_mensajero()) == true || isNumeric(m.getApellido()) == true || m.getPlaca().length() > 10) {
            return new ModelAndView("redirect:/add.htm");
        } else {
            this.jdbcTemplate.update("INSERT INTO public.\"Mensajero\"(\n"
                    + "	 name, lastname, plate)\n"
                    + "	VALUES ( ?, ?, ?);", m.getNombre_mensajero(), m.getApellido(), m.getPlaca());
            return new ModelAndView("redirect:/mensajeros.htm");
        }
    }
    
    @RequestMapping(value = "addP.htm", method = RequestMethod.POST)
    public ModelAndView mensajero(@ModelAttribute("Pedido") Pedido p,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request) {
        if (isNumeric(p.getCliente()) == true || isNumeric(p.getContenido()) == true || isNumeric(p.getMensajero()) == true || p.getEstado().length() > 20) {
                return new ModelAndView("redirect:/addP.htm");
            } else {
                this.jdbcTemplate.update("INSERT INTO public.pedido(\n"
                        + "	contenido, estado,mensajero, cliente)\n"
                        + "	VALUES (?, ?, ?, ?);", p.getContenido(), p.getEstado(), p.getMensajero(), p.getCliente());
                return new ModelAndView("redirect:/pedidos.htm");

            }
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
