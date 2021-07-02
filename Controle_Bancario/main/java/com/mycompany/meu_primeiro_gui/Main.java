/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.meu_primeiro_gui;

import dao.ClienteDB;
import gui.Login;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author amaury
 */
public class Main {
    public static void main(String[] args) {
        Login loginObj = new Login();
        loginObj.setVisible(true);
        loginObj.setLocationRelativeTo(null);
        loginObj.setTitle("Welcome to my system");
    }
}
