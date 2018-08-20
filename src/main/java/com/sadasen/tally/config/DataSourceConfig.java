package com.sadasen.tally.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @date 2018年8月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Configuration
public class DataSourceConfig {
	
	@Bean(name="dataSource")
	public DataSource dataSource(Environment env) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		return ds;
	}

}
