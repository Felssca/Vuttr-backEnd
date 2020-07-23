package br.com.vuttr.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vuttr.domain.entity.VuttrTags;
import br.com.vuttr.domain.service.exception.ObjectNotFoundException;
import br.com.vuttr.repository.VuttrTagsRepository;
import io.swagger.annotations.ApiModel;

@Service
@ApiModel(description = "Serviços que acessam o repositório ou DAO TAGS")
public class VuttrTagsService {
	
	@Autowired
	VuttrTagsRepository vuttrTagsRepository;
	
	public VuttrTags findById(Integer id) throws ObjectNotFoundException{
		Optional<VuttrTags> optional = vuttrTagsRepository.findById(id);
		return optional.orElseThrow(()-> new ObjectNotFoundException("Resource not found using this id!"));		
	}
	
	public List<VuttrTags> findAllTags() throws ObjectNotFoundException{
		return vuttrTagsRepository.findAll();
	}
	
		
	@Transactional
	public List<VuttrTags> insertAllTags(List<VuttrTags> vuttrTags){
		return vuttrTagsRepository.saveAll(vuttrTags);
		
	}

}
