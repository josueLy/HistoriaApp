/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.utilitarios;

import javax.swing.JOptionPane;

/**
 *
 * @author famleto
 */
public class ExcepcionGeneral extends Exception {
    
    public ExcepcionGeneral(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}
