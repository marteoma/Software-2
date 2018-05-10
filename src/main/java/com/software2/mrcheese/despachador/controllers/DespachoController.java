/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Mensajero;
import com.software2.mrcheese.despachador.models.Pedido;
import com.software2.mrcheese.despachador.models.Despacho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carlos Asprilla
 */
@Controller
public class DespachoController {

    private JdbcTemplate jdbcTemplate;


    public DespachoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView despachos() {
        ModelAndView mav = new ModelAndView();

        List<Pedido> pedidos = pedido();

        List<Mensajero> mensajeros = mensajero();

        mav.addObject("mensajeros", mensajeros);
        mav.addObject("pedidos", pedidos);
        mav.addObject("Despacho", new Despacho());
        mav.setViewName("despachos");
        return mav;

    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute Despacho despacho) {        
        int pedido = despacho.getPedido();
        String mensajero = despacho.getMensajero();
        this.jdbcTemplate.update("UPDATE public.\"Pedido\""
                + "	SET cc_mensajero = ?"
                + "	WHERE id = ?;", mensajero, pedido);
        return new ModelAndView("redirect:/pedidos.htm");
    }
    
    
    public List<Mensajero> mensajero() {
        String mensajerosQuery = "SELECT id, name, lastname, plate, cedula FROM \"public\".\"Mensajero\"";
        List<Mensajero> cs = jdbcTemplate.query(mensajerosQuery,
                new Object[]{},
                new RowMapper<Mensajero>() {
            @Override
            public Mensajero mapRow(ResultSet rs, int rowNum) throws SQLException {
                Mensajero m = new Mensajero();
                m.setId(rs.getLong(1));
                m.setName(rs.getString(2));
                m.setLastname(rs.getString(3));
                m.setPlate(rs.getString(4));
                m.setCedula(rs.getString(5));
                return m;
            }
        });
        return cs;
    }

    public List<Pedido> pedido() {
        String pedidosQuery = "SELECT contenido, estado, id, cc_mensajero, id_cliente, direccion"
                + "	FROM public.\"Pedido\" WHERE cc_mensajero is null ;";
        List<Pedido> cs = jdbcTemplate.query(pedidosQuery,
                new Object[]{},
                new RowMapper<Pedido>() {
            @Override
            public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pedido p = new Pedido();
                p.setContenido(rs.getString(1));
                p.setEstado(rs.getString(2));
                p.setId(rs.getLong(3));
                p.setCc_mensajero(rs.getString(4));
                p.setId_cliente(rs.getLong(5));
                p.setDireccion(rs.getString(6));
                return p;
            }
        });
        return cs;
    }
}


