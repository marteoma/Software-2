/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.mrcheese.despachador.validators;

import com.software2.mrcheese.despachador.models.Admin;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author hhade
 */
public class AdminValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "required.nombre", "Ingrese el email");
    }
    
}
