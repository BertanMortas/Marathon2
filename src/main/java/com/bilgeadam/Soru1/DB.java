package com.bilgeadam.Soru1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private final String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    private final String url ="jdbc:mysql://localhost/sirket_calisan";
    private final String userName ="root";
    private final String userPass="Bm15481527";

    public Connection connection = null;

    public DB() {
        try {
            Class.forName(mysqlDriver);
            connection = DriverManager.getConnection(url,userName,userPass);
            if (!connection.isClosed()){
                System.out.println("Connection success");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
