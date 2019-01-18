package com.kevin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author kevin
 * @version 1.0
 * @description     数据库连接工具类
 * @createDate 2018/12/25
 */
public class DBUtil {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        InputStream is = null;
        try {
            String file = "src/main/resources/db.properties";
            // 创建properties对象，用来加载properties文件
            Properties prop = new Properties();
            // 创建文件输入流
            is = new FileInputStream(file);
            // 加载配置文件
            prop.load(is);
            // 为变量赋值
            driver = prop.getProperty("jdbc.driver").trim();
            url = prop.getProperty("jdbc.url").trim();
            user = prop.getProperty("jdbc.user").trim();
            password = prop.getProperty("jdbc.password").trim();
            // 注册驱动
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 创建连接
      */
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 处理对象
     * @param conn
     * @return
     */
    public static Statement getStmt(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     *      处理对象
     * @param conn  数据库连接
     * @param sql   sql语句
     * @return
     */
    public static PreparedStatement getPstmt(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    /**
     * 动态输入参数
     * @param pstmt     处理对象
     * @param params    参数
     */
    public static void bindParam(PreparedStatement pstmt, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
