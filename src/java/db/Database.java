/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*; 

/**
 *
 * @author Msi
 */
public class Database {
    Connection con;
    public Connection connect() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "jsp_servlet"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
 
        Class.forName(dbDriver); 
        this.con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword); 
        return this.con;
    }
    public void close() throws SQLException, ClassNotFoundException {
        this.con.close();
    }
}
