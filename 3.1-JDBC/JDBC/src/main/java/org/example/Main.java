package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
         String sql = "SELECT city FROM info";
         String url="jdbc:postgresql://localhost/practice";
         String username="postgres";
         String password="1632coder";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);

        res.next();
        String name=res.getString(1);
        System.out.println(name);

    }
}
