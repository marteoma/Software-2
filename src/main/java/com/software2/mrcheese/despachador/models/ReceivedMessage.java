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
public class ReceivedMessage {
    
    public static String MENSAJERO = "Mensajero";
    
    public static String CLIENTE = "Cliente";
    
    private String idSender;
    
    private String message;
    
    private String senderType;
    
    private String date;

    public ReceivedMessage(String idSender, String message, String senderType, String date) {
        this.idSender = idSender;
        this.message = message;
        this.senderType = senderType;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    public ReceivedMessage() {
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }
    
    
}
