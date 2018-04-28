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
public class SendedMessage {
    
    public static String MENSAJERO = "Mensajero";
    
    public static String CLIENTE = "Cliente";
    
    private String receptor;
    
    private String message;
    
    private String date;
    
    private String receptorType;

    public SendedMessage(String receptor, String message, String date, String receptorType) {
        this.receptor = receptor;
        this.message = message;
        this.date = date;
        this.receptorType = receptorType;
    }

    public SendedMessage() {
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceptorType() {
        return receptorType;
    }

    public void setReceptorType(String receptorType) {
        this.receptorType = receptorType;
    }
    
    
}
