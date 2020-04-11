package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProfilesService;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class JDBCController {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ProfilesService profilesService;
	@Autowired
	private Environment env;

	@Value("#{'s'.length()}")
	private Integer length;

	@GetMapping(path = "profiles")
	public Object profiles(@RequestParam Integer id) {
		System.err.println("length=" + length);
		return profilesService.findById(id);
	}

	@GetMapping(path = "profilesAll")
	public Object profiles() {
		return profilesService.findAll();
	}

	@GetMapping(path = "select")
	public Object map() throws SQLException {
		Connection connection = dataSource.getConnection();
		List<Object> results = new ArrayList<>();

		try (Statement stat = connection.createStatement();
				ResultSet rs = stat.executeQuery("SELECT * FROM Profiles");) {
			ResultSetMetaData md = rs.getMetaData();

			int count = md.getColumnCount();

			while (rs.next()) {
				Map<String, Object> result = new LinkedHashMap<>();

				for (int i = 1; i <= count; i++) {
					String name = md.getColumnName(i);
					Object data = rs.getObject(i);

					result.put(name, data);

				}

				results.add(result);

			}
		}
		return results;
	}

}
