/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Mensajero;
import com.software2.mrcheese.despachador.models.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carlos Asprilla
 */
@Controller
public class EditController {

    private JdbcTemplate jdbcTemplate;

    public EditController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    
    
    @RequestMapping(value = "editM.htm", method = RequestMethod.GET)
    public ModelAndView mensajeros(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        long id = Long.parseLong(request.getParameter("id"));
        Mensajero m = selectMensajero(id);
        mav.setViewName("editM");
        mav.addObject("Mensajero", m);
        return mav;
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.GET)
    public ModelAndView pedidos(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        long id = Long.parseLong(request.getParameter("id"));
        Pedido p = selectPedido(id);
        mav.setViewName("edit");
        mav.addObject("Pedido", p);
        return mav;
    }
    
    @RequestMapping(value = "editM.htm", method = RequestMethod.POST)
    public ModelAndView mensajero(@ModelAttribute("Mensajero") Mensajero m,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("UPDATE public.\"Mensajero\""
                        + "	SET name=?, lastname=?, plate=?"
                        + "	WHERE id =?;", m.getName(), m.getLastname(), m.getPlate(), id);                
        return new ModelAndView("redirect:/mensajeros.htm");
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView pedidos(@ModelAttribute("Pedido") Pedido u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));        
        this.jdbcTemplate.update("UPDATE public.\"Pedido\""
                        + "	SET contenido=?, estado=?, cc_mensajero=?"
                        + "	WHERE id =?;",
                u.getContenido(), u.getEstado(), u.getCc_mensajero(), id);
        return new ModelAndView("redirect:/pedidos.htm");
    }        

    public Pedido selectPedido(long id) {
        final Pedido pedido = new Pedido();
        String query = "SELECT id, id_cliente, direccion, contenido, estado, cc_mensajero\n"
                + "	FROM public.\"Pedido\" WHERE id ='" + id + "'";
        return (Pedido) jdbcTemplate.query(query, new ResultSetExtractor<Pedido>() {
            @Override
            public Pedido extractData(ResultSet rs) throws SQLException, DataAccessException {

                if (rs.next()) {
                    pedido.setId(rs.getLong(1));
                    pedido.setId_cliente(rs.getLong(2));
                    pedido.setDireccion(rs.getString(3));
                    pedido.setContenido(rs.getString(4));
                    pedido.setEstado(rs.getString(5));
                    pedido.setCc_mensajero(rs.getString(6));
                }
                return pedido;
            }

        });
    }

    public Mensajero selectMensajero(long id) {
        final Mensajero m = new Mensajero();
        String query = "SELECT id, cedula, telefono, name, lastname, plate\n"
                + "	FROM public.\"Mensajero\"\n"
                + "	WHERE id= '" + id + "'";
        return (Mensajero) jdbcTemplate.query(query, new ResultSetExtractor<Mensajero>() {
            @Override
            public Mensajero extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    m.setId(rs.getLong(1));
                    m.setCedula(rs.getString(2));
                    m.setTelefono(rs.getString(3));
                    m.setName(rs.getString(4));
                    m.setLastname(rs.getString(5));
                    m.setPlate(rs.getString(6));
                }
                return m;
            }

        });
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
