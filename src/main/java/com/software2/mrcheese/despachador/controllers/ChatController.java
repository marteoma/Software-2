/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.conexiones.Conectar;
import com.software2.mrcheese.despachador.models.Cliente;
import com.software2.mrcheese.despachador.models.Mensajero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hhade
 */
@Controller
@RequestMapping("chat.htm")
public class ChatController {
    
    private JdbcTemplate template;
    
    public ChatController(){
        Conectar con = new Conectar();
        this.template = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView chat() {
        ModelAndView mav = new ModelAndView();        
        String mensajerosQuery = "SELECT id, name, lastname FROM \"public\".\"Mensajero\"";
        
        List<Cliente> clientes = clientes();
        List<Mensajero> mensajeros = mensajeros();
        
        mav.addObject("mensajeros", mensajeros);
        mav.addObject("clientes", clientes);
        return  mav;
    }
    
    public List<Cliente> clientes(){
        String clientesQuery = "SELECT id, name, lastname, address FROM \"public\".\"Cliente\"";
        List<Cliente> cs = template.query(clientesQuery,
                new Object[]{},
                new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Cliente(rs.getString(3), rs.getString(2),
                        rs.getString(1), rs.getString(4));
            }
        });
        return cs;
    }
    
    public List<Mensajero> mensajeros(){
        String mensajerosQuery = "SELECT id, name, lastname, plate FROM \"public\".\"Mensajero\"";
        List<Mensajero> cs = template.query(mensajerosQuery,
                new Object[]{},
                new RowMapper<Mensajero>() {
            @Override
            public Mensajero mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Mensajero(rs.getString(3), rs.getString(2),
                        rs.getString(1), rs.getString(4));
            }
        });
        return cs;
    }

    
    
}
