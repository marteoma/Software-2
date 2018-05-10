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
public class Mensajero {
    private long id;
    private String cedula;
    private String telefono;
    private String name;
    private String lastname;
    private String plate;

    public Mensajero(long id, String cedula, String telefono, String name, String lastname, String plate) {
        this.id = id;
        this.cedula = cedula;
        this.telefono = telefono;
        this.name = name;
        this.lastname = lastname;
        this.plate = plate;
    }

    public Mensajero() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    
    
}
