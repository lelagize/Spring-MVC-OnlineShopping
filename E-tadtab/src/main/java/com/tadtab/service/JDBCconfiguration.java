package com.tadtab.service;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class JDBCconfiguration {
	@Bean
	public JDBCservice jDBCservice(){
		return new JDBCservice(dataSource());
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tadtab");
        dataSource.setUsername("tadtab");
        dataSource.setPassword("Tadele@12");
        return dataSource;
	}
}
