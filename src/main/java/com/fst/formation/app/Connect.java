/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.formation.app;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rassil
 */
public class Connect {
    
  
   
        public static Connection ConnectDb(){
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
          return con;
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
       
}
        
     
       public static void main(String[] args) {
        
           ConnectDb();
           
    }

        
    }
    
    
    

