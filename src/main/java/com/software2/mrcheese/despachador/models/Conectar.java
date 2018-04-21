/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Carlos Asprilla
 */
public class Conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.postgresql.Driver");
        datasource.setUrl("jdbc:postgresql:Pedidos");
        datasource.setUsername("Carlos");
        datasource.setPassword("carlos424");
        return datasource;
    }
    
}
