package com.tienda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection(
                             "jdbc:hsqldb:mem:mydb", "SA", "1234");
        
        // String bookTableSQL = "CREATE MEMORY TABLE PRODUCTO(ID INT IDENTITY NOT NULL PRIMARY KEY, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), PRICE INT, AMOUNT INT)";
        
        Statement st = conn.createStatement();
        // st.execute(bookTableSQL);
        // System.out.println(st);
        String sql = "SELECT *"+
        " FROM   INFORMATION_SCHEMA.TABLES";
        
        
        System.out.println(st.executeQuery(sql));
        DatabaseMetaData md = conn.getMetaData();
ResultSet rs = md.getTables(null, null, "%", null);
while (rs.next()) {
  System.out.println(rs.getString(3));
}
    }
}
