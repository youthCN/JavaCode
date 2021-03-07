package common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
        String sql = "select * from db";
        Statement statement = conn.createStatement();
        boolean execute = statement.execute(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("resultSet="+resultSet);
        resultSet.close();

        statement.close();
        conn.close();
    }
}
