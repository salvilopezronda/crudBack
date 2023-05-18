package com.example.crud.shared;

import com.example.crud.exceptions.AccesDataException;

public abstract class BaseController {

    public boolean comprobarAutorizacion(String autorizacion) throws AccesDataException {
        if (CrudConstants.ROL_ADMINISTRADOR.equalsIgnoreCase(autorizacion)) {
            return true;
        }
        throw new AccesDataException("No tiene los permisos necesarios para cceder a este recurso");
    }
}
