package com.globallogic.guidance.service;

import com.globallogic.guidance.entity.Root;

import java.util.List;

public interface RootService {
	Root findById(Long id);
	List<Root> findAll();
	Root save(Root guidance);
	void deleteById(Long id);
	Root findByRootNumber(Long root_number);
}
