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
   
    private long id;
    private long id_cliente;
    private String direccion;
    private String contenido;
    private String estado;
    private String cc_mensajero;

    public Pedido(long id, long id_cliente, String direccion, String contenido, String estado, String cc_mensajero) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.contenido = contenido;
        this.estado = estado;
        this.cc_mensajero = cc_mensajero;
    }

    public Pedido() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCc_mensajero() {
        return cc_mensajero;
    }

    public void setCc_mensajero(String cc_mensajero) {
        this.cc_mensajero = cc_mensajero;
    }
}