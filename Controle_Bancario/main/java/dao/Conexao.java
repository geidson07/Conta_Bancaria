/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amaury
 */
public class Conexao {
    private Connection conn;
    
    public Connection conectar() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/aulappoo?user=root&password=123");
        } catch(SQLException e) {
            System.out.println("errorororo");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return conn;
    }
    
    public void desconectar() {
        try {
            this.conn.close();
        } catch(SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
