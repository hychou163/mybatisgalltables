package com.hyjoy.mybatis;

import java.sql.*;

/**
 * 获取所有数据
 * Created by hyjoy on 2018/3/14.
 */
public class QueryAllTable {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/api?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        Statement stmt = connection.createStatement();
//
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(connection.getCatalog(), "root", null, new String[]{"TABLE"});
        while (resultSet.next()) {
            System.out.println("<table schema=\"api\" tableName=\"" + resultSet.getString("TABLE_NAME") + "\"/>");
        }
        resultSet.close();

        connection.close();

    }
}
