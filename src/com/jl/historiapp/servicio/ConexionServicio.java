/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.servicio;

import com.jl.historiapp.dao.ConexionDao;
import java.sql.Connection;

/**
 *
 * @author Teo
 */
public class ConexionServicio {
    
    
    
    public static  Connection conectar(){
        return ConexionDao.conectar();
    }
}
