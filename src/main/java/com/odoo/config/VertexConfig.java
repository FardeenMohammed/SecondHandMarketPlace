package com.odoo.config;

import io.vertx.core.Vertx;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertexConfig {

    @Bean
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    public Pool mysqlPool(Vertx vertx) {
        MySQLConnectOptions options = new MySQLConnectOptions()
                .setHost("localhost")
                .setPort(3306)
                .setDatabase("SE")
                .setUser("root")
                .setPassword("root123");

        PoolOptions poolOptions = new PoolOptions().setMaxSize(10);

        return Pool.pool(vertx, options, poolOptions);
    }
}
