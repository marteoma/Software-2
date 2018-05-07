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
public class Despacho{
        private String mensajero;
        private int pedido;
        
        public Despacho(){}
        
        public Despacho(String mensajero, int pedido){
            this.mensajero =mensajero;
            this.pedido = pedido;
        }

        public String getMensajero() {
            return mensajero;
        }


        public void setMensajero(String mensajero) {
            this.mensajero = mensajero;
        }


        public int getPedido() {
            return pedido;
        }

        public void setPedido(int pedido) {
            this.pedido = pedido;
        }
        
    }