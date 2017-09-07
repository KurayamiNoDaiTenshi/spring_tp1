package dev.paie.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.util"})
public class DataSourceMySQLConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://s2.angelo-b.net:3306/sirh-paie?useSSL=false");
		dataSource.setUsername("sirh-paie");
		dataSource.setPassword("sirh-paie");
		return dataSource;
	}
}