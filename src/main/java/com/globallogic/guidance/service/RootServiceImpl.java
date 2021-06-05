package com.globallogic.guidance.service;

import com.globallogic.guidance.entity.Root;
import com.globallogic.guidance.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RootServiceImpl implements RootService {
	@Autowired
	RootRepository rootRepository;

	public RootServiceImpl(RootRepository rootRepository) {
		this.rootRepository = rootRepository;
	}

	@Override
	public Root findById(Long id) {
		return rootRepository.findById(id).orElse(new Root());
	}

	@Override
	public List<Root> findAll() {
		return (List<Root>) rootRepository.findAll();
	}

	@Override
	public Root save(Root root) {
		return rootRepository.save(root);
	}

	@Override
	public void deleteById(Long id) {
		rootRepository.deleteById(id);
	}

	@Override
	public Root findByRootNumber(Long root_number) {
		return rootRepository.findNextById(root_number);
	}

}
