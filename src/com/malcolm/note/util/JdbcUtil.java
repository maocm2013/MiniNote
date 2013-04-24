/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.util;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class JdbcUtil {
    /**
     * 获取数据库连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConn() throws ClassNotFoundException, SQLException{
        String filePath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator).concat("note.db");
        System.out.println("filePath=" + filePath);
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:"+filePath);
        return conn;
    }
}
