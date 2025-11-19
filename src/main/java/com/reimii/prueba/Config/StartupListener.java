package com.reimii.prueba.Config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
class StartupListener {

    private final DataSource dataSource;

    public StartupListener(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        System.out.println("Application is ready");
        System.out.println("http://localhost:8080/");

        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(2)) {
                System.out.println("✅ Conexión OK con la base de datos");
                System.out.println("   URL: " + conn.getMetaData().getURL());
                System.out.println("   Usuario: " + conn.getMetaData().getUserName());
            } else {
                System.out.println("⚠️ No se ha podido validar la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
