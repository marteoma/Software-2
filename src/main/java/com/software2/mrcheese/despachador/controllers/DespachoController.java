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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class DespachoController {
    private JdbcTemplate jdbcTemplate;
   // estos atributos son para probar la consulta por eso estan definidos de una vez
    // nombre del mensajero
     private String mensajero= "default";
    //id del pedido al cual se le hara el update
     private int pedido = 4 ;
    
    public DespachoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
   @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView despachos(){
        ModelAndView mav = new ModelAndView();
        
        List<Pedido> pedidos = pedido(); 
       
      
        List<Mensajero> mensajeros = mensajero();
        
        mav.addObject("mensajeros",mensajeros);
        mav.addObject("pedidos",pedidos);    
        mav.addObject("pedido",pedido);
        mav.addObject("mensajero",mensajero);
        mav.setViewName("despachos");
        return mav;
        
    }        
    
public List<Mensajero> mensajero(){
        String mensajerosQuery = "SELECT id, name, lastname, plate FROM \"public\".\"Mensajero\"";
        List<Mensajero> cs = jdbcTemplate.query(mensajerosQuery,
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

     public List<Pedido> pedido(){
        String pedidosQuery = "SELECT contenido, estado, id_pedido, mensajero, cliente\n" +
"	FROM public.pedido WHERE mensajero is null ;";
       List<Pedido> cs = jdbcTemplate.query(pedidosQuery,
                new Object[]{},
                new RowMapper<Pedido>() {
            @Override
            public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Pedido(Integer.parseInt(rs.getString(3)), rs.getString(1),
                        rs.getString(2), rs.getString(4),rs.getString(5));
            }
        });
        return cs;
   }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
           
    ){
     
         this.jdbcTemplate.update("UPDATE public.pedido\n"
                + "	SET mensajero=?\n"
                + "	WHERE id_pedido =?;",mensajero,pedido);
          return new ModelAndView("redirect:/pedidos.htm");
         
     }

    /**
     * @param aMensajero the mensajero to set
     */
    @ModelAttribute("mensajero")
    public  void setMensajero(String aMensajero) {
        mensajero = aMensajero;
    }

    /**
     * @param u
     * 
     * 
     */
   
    public  void setPedido(int u){
        pedido = u;
    }
    
}
