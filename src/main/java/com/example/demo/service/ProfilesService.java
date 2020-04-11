package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profiles;
import com.example.demo.service.dao.ProfilesDAO;

//@Service
@Transactional
public class ProfilesService {
	@Autowired
	private ProfilesDAO profilesDAO;

	public List<Profiles> findAll() {

		return (List<Profiles>) profilesDAO.findAll();
	}

	public Profiles findById(int id) {

		return profilesDAO.findById(id).orElse(null);
	}

}
