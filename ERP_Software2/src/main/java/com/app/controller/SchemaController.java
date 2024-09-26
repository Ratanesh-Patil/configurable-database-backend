package com.app.controller;

import com.app.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schema")
@CrossOrigin("*")
public class SchemaController {

	@Autowired
	private SchemaService schemaService;

	@PostMapping("/addColumn")
	public void addColumn(@RequestParam String tableName, @RequestParam String columnName,
			@RequestParam String columnType) {
		schemaService.addColumn(tableName, columnName, columnType);
	}

	@PostMapping("/removeColumn")
	public void removeColumn(@RequestParam String tableName, @RequestParam String columnName) {
		schemaService.removeColumn(tableName, columnName);
	}

	@PostMapping("/updateColumnType")
	public void updateColumnType(@RequestParam String tableName, @RequestParam String columnName,
			@RequestParam String newColumnType) {
		schemaService.updateColumnType(tableName, columnName, newColumnType);
	}
}