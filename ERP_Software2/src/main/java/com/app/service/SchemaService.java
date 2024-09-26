package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SchemaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addColumn(String tableName, String columnName, String columnType) {
		String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, columnType);
		jdbcTemplate.execute(sql);
	}

	public void removeColumn(String tableName, String columnName) {
		String sql = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
		jdbcTemplate.execute(sql);
	}

	public void updateColumnType(String tableName, String columnName, String newColumnType) {
		String sql = String.format("ALTER TABLE %s ALTER COLUMN %s TYPE %s", tableName, columnName, newColumnType);
		jdbcTemplate.execute(sql);
	}
}