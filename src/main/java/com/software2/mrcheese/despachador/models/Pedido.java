/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.models;

/**
 *
 * @author hhade
 */
public class Pedido {
   private String contenido;
    private int id_pedido;
    private String estado;
    private String mensajero;
    private String cliente;

    public Pedido(){
        
    }
    public Pedido(int id,String conten,String state,String Messenger,String client){
        id_pedido=id;
        contenido=conten;
        estado=state;
        mensajero=Messenger;
        cliente=client;
        
    }
    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the id_pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the mensajero
     */
    public String getMensajero() {
        return mensajero;
    }

    /**
     * @param mensajero the mensajero to set
     */
    public void setMensajero(String mensajero) {
        this.mensajero = mensajero;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
