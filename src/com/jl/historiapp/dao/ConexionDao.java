/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Teo
 */
public class ConexionDao {
    public static  Connection conectar(){
        Connection con = null;
 
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/historiasdb?user=root&password=root";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}
 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}
