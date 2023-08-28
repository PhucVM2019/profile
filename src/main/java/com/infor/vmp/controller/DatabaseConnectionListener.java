package com.infor.vmp.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionListener {
	private static final Logger log = LogManager.getLogger(DatabaseConnectionListener.class);
	@Autowired
	private DataSource dataSource;

	@SuppressWarnings("unused")
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@EventListener(ApplicationReadyEvent.class)
	public void checkDatabaseConnectionMysql() {
		try (Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			String databaseProductName = metaData.getDatabaseProductName();
			log.info("Listener Connected to database: " + databaseProductName);
		} catch (SQLException e) {
			log.info("Listener failed to connect to the database: " + e.getMessage());
		}
	}
}
