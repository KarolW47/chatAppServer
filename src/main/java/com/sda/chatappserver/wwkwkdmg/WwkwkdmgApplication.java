package com.sda.chatappserver.wwkwkdmg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@SpringBootApplication
public class WwkwkdmgApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwkwkdmgApplication.class, args);


    }}
 /*   @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        //ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }*/
