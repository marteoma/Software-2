/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.controllers;

import com.software2.mrcheese.despachador.models.Cliente;
import com.software2.mrcheese.despachador.models.Conectar;
import com.software2.mrcheese.despachador.models.Mensajero;
import com.software2.mrcheese.despachador.models.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
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
    
    public EditController(){
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
     
        Pedido datos= this.selectPedido(id);
        mav.setViewName("edit");
        Pedido pedi =  new Pedido(id,datos.getContenido(),datos.getEstado(),datos.getMensajero(),datos.getCliente());
        mav.addObject("Pedido",pedi);
        return  mav;
        
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("Pedido")Pedido u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    
    ){
        int id =Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("UPDATE public.pedido\n" +
"	SET contenido=?, estado=?, mensajero=?, cliente=?\n" +
"	WHERE id_pedido =?;",u.getContenido(),u.getEstado(),u.getMensajero(),u.getCliente(),id);
        return new ModelAndView("redirect:/pedidos.htm");
    }
    
    public Pedido selectPedido( int id ){
       final Pedido pedido = new Pedido();
       String query = "SELECT contenido, estado, id_pedido, mensajero, cliente\n" +
"	FROM public.pedido WHERE id_pedido ='"+id+"'";
       return (Pedido) jdbcTemplate.query(query,new ResultSetExtractor<Pedido>(){
           @Override
           public Pedido extractData(ResultSet rs) throws SQLException, DataAccessException {
                  
                    if(rs.next()){
                       pedido.setContenido(rs.getString("contenido"));
                       pedido.setCliente(rs.getString("cliente"));
                       pedido.setEstado(rs.getString("estado"));
                       pedido.setMensajero(rs.getString("mensajero"));
                    }
                    return pedido;
           }
        
           });
    }
}
