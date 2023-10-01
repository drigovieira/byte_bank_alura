package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        try {
            return createDataSource().getConnection();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Não foi possível conectar ao banco de dados.");
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("rodrigo");
        config.setPassword("210517Rodrigo#");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

}
