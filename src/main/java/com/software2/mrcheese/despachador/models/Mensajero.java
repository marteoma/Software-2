/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.models;

import java.util.ArrayList;

/**
 *
 * @author hhade
 */
public class Mensajero {

    private String apellido;

    public Mensajero(String apellido, String nombre_mensajero, String id_mensajero, String placa) {
        this.apellido = apellido;
        this.nombre_mensajero = nombre_mensajero;
        this.id_mensajero = id_mensajero;
        this.placa = placa;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Mensajero() {
    }
    private String nombre_mensajero;
    private String id_mensajero;
    private String placa;
    private ArrayList<Pedido> pedidos = new ArrayList();

    /**
     * @return the nombre_mensajero
     */
    public String getNombre_mensajero() {
        return nombre_mensajero;
    }

    /**
     * @param nombre_mensajero the nombre_mensajero to set
     */
    public void setNombre_mensajero(String nombre_mensajero) {
        this.nombre_mensajero = nombre_mensajero;
    }

    /**
     * @return the id_nombre
     */
    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the pedidos
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the id_mensajero
     */
    public String getId_mensajero() {
        return id_mensajero;
    }

    /**
     * @param id_mensajero the id_mensajero to set
     */
    public void setId_mensajero(String id_mensajero) {
        this.id_mensajero = id_mensajero;
    }
}
