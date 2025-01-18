package com.caleb.umlestudodecaso.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caleb.umlestudodecaso.repositories.CategoryRepository;
import com.caleb.umlestudodecaso.domain.*;
import com.caleb.umlestudodecaso.services.exception.*;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	public Category find(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", kind: " + Category.class.getName()));
	}

}
