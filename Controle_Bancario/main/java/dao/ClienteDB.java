/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author amaury
 */
public class ClienteDB {
    private Connection conn;
    private Conexao conexao = new Conexao();
    private ResultSet rs;
    private PreparedStatement ps;
   
    
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        try {
            this.conn = conexao.conectar();
            ps = conn.prepareStatement("select *From clientes");
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setCpf(rs.getString("customer_cpf"));
                c.setName(rs.getString("customer_name"));
                
                clientes.add(c);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        
        return clientes;
    }
    
    public boolean inserir(Cliente c) {
        boolean ok;
        
        try {
            this.conn = conexao.conectar();
            ps = conn.prepareStatement("insert into clientes (customer_name, customer_cpf) values (?,?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getCpf());
            ps.executeUpdate();
            
            ok = true;
        } catch(Exception e) {
            e.printStackTrace();
            
            ok = false;
        } finally {
            conexao.desconectar();
        }
        
        if(ok) 
            return true;
        
        return false;
    }
}
