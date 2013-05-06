package com.malcolm.note.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class JdbcUtil {
    private static final Logger log = Logger.getLogger(JdbcUtil.class);
    /**
     * 获取数据库连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConn() throws ClassNotFoundException, SQLException{
        String filePath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator).concat("note.db");
        log.debug("filePath=" + filePath);
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:"+filePath);
        return conn;
    }
}
