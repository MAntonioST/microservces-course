package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import com.devsuperior.hrworker.services.exceptions.ObjectNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repo;
	
	
	public List<Worker> findAll() {
	  return  repo.findAll();
	}

	public Worker findById(Long id) {
		Optional<Worker> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Worker.class.getName()));
	}
}
