package com.cloud.template.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "hikari")
public class HikariCPConfig {
    @Value("${hikari.driverclassname}")
    private String driverClassName;

    @Value("${hikari.jdbcurl}")
    private String jdbcUrl;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${hikari.idleTimeout}")
    private long idleTimeout;

    @Value("${hikari.connectTimeout}")
    private long connectTimeout;

    @Value("${hikari.maxLifetime}")
    private long maxLifetime;

    @Primary
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource hds = new HikariDataSource();
        hds.setJdbcUrl(jdbcUrl);
        hds.setDriverClassName(driverClassName);
        hds.setUsername(userName);
        hds.setPassword(password);
        hds.setMaximumPoolSize(maximumPoolSize);
        hds.setIdleTimeout(idleTimeout);
        hds.setConnectionTimeout(connectTimeout);
        hds.setMaxLifetime(maxLifetime);
        return hds;
    }

}