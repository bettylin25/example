package com.example.demo.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profiles;

@Repository
public interface ProfilesDAO extends CrudRepository<Profiles, Integer> {
//	@Autowired
//	private EntityManager entityManager;
//	
//	private Session getSession() {
//		return entityManager.unwrap(Session.class);
//	}
//	
//	public Profiles getById(int id) {
//		return this.getSession().get(Profiles.class, id);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Profiles> getAll(){
//		return this.getSession().createQuery("FROM Profiles").list();
//	}

}
