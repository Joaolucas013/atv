package org.example.aluno.conexao;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {


    public Connection retornarConexao(){

        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HikariDataSource createDataSource(){
        HikariDataSource hikariConfig = new HikariDataSource();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/aluno_bank");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.setMaximumPoolSize(12);
        return hikariConfig;
    }


}

//public Connection retornarConexao(){
//
//        try {
//
//        return  DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/aluno_bank?user=root&password=root");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }