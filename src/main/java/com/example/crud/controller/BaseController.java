package com.example.crud.controller;

import com.example.crud.exceptions.AccesDataException;
import com.example.crud.shared.CrudConstants;
import org.springframework.expression.AccessException;

public abstract class BaseController {

    public boolean comprobarAutorizacion(String autorizacion) throws AccesDataException {
        if (CrudConstants.ROL_ADMINISTRADOR.equalsIgnoreCase(autorizacion)) {
            return true;
        }
        throw new AccesDataException("No tiene los permisos necesarios para cceder a este recurso");
    }
}
