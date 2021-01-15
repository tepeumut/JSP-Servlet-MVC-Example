/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Msi
 */
public class UserDao {

    Connection con;

    public UserDao() {
        Database db = new Database();
        try {
            con = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public List<User> listAll() throws Exception {
        List<User> users = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return users;
    }
    
    public User login(String username, String password) throws Exception {
        User user = new User();
        try {
            String sql = "SELECT * FROM users WHERE username=? AND password=? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return null;
    }
    
    public User find(int id) throws Exception {
        User user = new User();
        try {
            String sql = "SELECT * FROM users WHERE id=? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return user;
    }
    
    public boolean save(User user) throws Exception {
        int status = 0;
        try {
            String sql = "INSERT INTO users (first_name,last_name,username,password) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return status != 0;
    }
    
    public boolean update(User user) throws Exception {
        int status = 0;
        try {
            String sql = "UPDATE users SET first_name=?,last_name=?,username=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setInt(4, user.getId());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return status != 0;
    }
    
    public boolean delete(int id) throws Exception {
        int status = 0;
        try {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Veritabani Hatasi = " + ex.getMessage());
        }
        return status != 0;
    }
}
