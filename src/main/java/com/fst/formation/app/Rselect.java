/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.formation.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author rassil
 */
public class Rselect {
    
    
    public static ResultSet select(String sql){
        
      ResultSet rs=null;
      Connection con=Connect.ConnectDb();
      try{
      Statement pst=con.createStatement();
       rs=  pst.executeQuery(sql);
      
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex);
      }
      
      
    
  return rs;
    
  
    }
    
  public static void Insert(String sql) 
      {
          try{
      Connection con=Connect.ConnectDb();
           Statement pst=con.prepareStatement(sql);
           pst.execute(sql);
      }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
      }
      }
    
}
