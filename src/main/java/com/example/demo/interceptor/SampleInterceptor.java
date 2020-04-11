package com.example.demo.interceptor;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SampleInterceptor implements HandlerInterceptor {
	@Autowired
	private ObjectMapper mapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();

		if (uri.startsWith("/back")) {
			return true;
		}

		String password = request.getParameter("password");

		if ("mima".equals(password)) {
			return true;
		}

		this.addForbiddenMessage(request, response);

		return false;
	}

	private void addForbiddenMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		response.setStatus(HttpStatus.FORBIDDEN.value());

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		Map<String, Object> resp = new LinkedHashMap<>();

		resp.put("uri", uri);
		resp.put("message", "forbidden");

		response.getWriter().write(mapper.writeValueAsString(resp));
	}

}
