package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@RestController
public class HelloController {

	@GetMapping(path = "test")
	public Map<String, Object> hello() {
		Map<String, Object> response = new HashMap<>();
		response.put("name", "hello");

		return response;
	}

}
