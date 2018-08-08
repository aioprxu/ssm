package com.aiopr.JDBC;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2018/1/29.
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //通过反射得到Driver类并注册
        Class.forName("com.mysql.cj.jdbc.Driver");
//        DriverManager.deregisterDriver(DriverManager.getDriver("com.mysql.jdbc.Driver"));
        //得到数据库连接
        Connection conn = dataSource.DATA_SOURCE.getConnection();
        System.out.println(conn);
        //创建执行SQL语句的statement创建执行SQL语句的statement
        Statement stmt = conn.createStatement();
        System.out.println(stmt);
        //得到结果集
        ResultSet rs = stmt.executeQuery("show databases");
        System.out.println(rs);
        //这里要加预处理，为了防止SQL注入
        //PreparedStatement preparedStatement = conn.createStatement();
        //打印所有被注册过的Driver
        Enumeration<Driver> enumeration = DriverManager.getDrivers();
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());

        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString(1));
        }

    }




}
//实验用枚举来得到单例
enum dataSource{
    DATA_SOURCE;
    private Connection connection = null;
    private dataSource() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "123456");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
