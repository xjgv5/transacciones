package com.xjgv.javaJDBC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=Mexico/General";
    private static String username = "root";
    private static String password = "admin";
    private static Connection conexion;

    public static Connection getInstance() throws SQLException {
        if (conexion == null){
            conexion = DriverManager.getConnection(url, username, password);
        }

        return conexion;
    }

}
