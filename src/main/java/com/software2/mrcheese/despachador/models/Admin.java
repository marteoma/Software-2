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
public class Admin {
    
    private long id;
    
    private String email;
    
    private String password;

    public Admin(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }        

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
