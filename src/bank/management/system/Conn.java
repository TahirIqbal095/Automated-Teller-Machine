package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver); register the driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "mc@futbol"); // create connection
            s = c.createStatement(); // crate statement



        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
