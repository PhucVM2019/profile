package com.infor.vmp.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionTest implements InitializingBean {
	private static final Logger log = LogManager.getLogger(DatabaseConnectionTest.class);
	private DataSource dataSource = null;

	@Autowired
	public DatabaseConnectionTest(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception  {
		log.info("BEGIN CHECK CONNECT TO DATABASE MYSQL");
		try (Connection connection = dataSource.getConnection()) {
			log.info("Connected to the database successfully!");
		} catch (SQLException e) {
			log.error("Failed to connect to the database: " + e.getMessage());
		}
		log.info("END CHECK CONNECT TO DATABASE MYSQL");
	}

}
