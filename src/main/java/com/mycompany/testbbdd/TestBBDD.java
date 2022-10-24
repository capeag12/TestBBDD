/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.testbbdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author capea
 */
public class TestBBDD {

    public static void main(String[] args) throws SQLException {
        
        Conexion cx = new Conexion("farmacia", "root", "");
        cx.conectar(); //Para realizar cualquier consulta primero debecos conectarnos con la BBDD, en caso de fallar esto nos retornará null, por lo que los demás metodos no darán NullPointerException
        
        ResultSet resultado= cx.realizarConsulta("SELECT * FROM `cliente`");
        ResultSetMetaData datos = resultado.getMetaData(); 
        while (resultado.next()) {            
            
            for (int i = 1; i <= datos.getColumnCount(); i++) {
                System.out.print(datos.getColumnName(i)+":"+resultado.getString(i)+"    ");
            }
            System.out.println("----------------------------------------\n");
        }
        
        cx.desconectar(); //Al acabar de trabajar con la BBDD debemos desconectarnos para evitar problemas 
        
    }
}
