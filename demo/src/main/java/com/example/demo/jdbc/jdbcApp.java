package com.example.demo.jdbc;

import java.sql.*;

/**
 * 原生JDBC访问数据库
 * 加载JDBC驱动程序
 * 创建数据库的连接
 * 创建preparedStatement
 * 执行SQL语句
 * 处理结果集
 * 关闭JDBC对象资源
 */
public class jdbcApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        String url = "jdbc:mysql://127.0.0.1:3306/springLearn?serverTimezone=GMT" +
                "&useUnicode=true&characterEncoding=utf-8&useSSL=false";

        String username = "root";
        String password = "123456ok";

        //获取连接对象，并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);

        //获取语句对象
        Statement statement = connection.createStatement();

        ResultSet resultSet =  statement.executeQuery("select * from video");

        while (resultSet.next()){

            System.out.println("视频标题:"+resultSet.getString("title"));

        }
        statement.close();
    }
}
