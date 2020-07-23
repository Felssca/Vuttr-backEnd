package br.com.vuttr.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vuttr.domain.entity.VuttrMain;
import br.com.vuttr.domain.service.exception.ObjectNotFoundException;
import br.com.vuttr.repository.VuttrMainRepository;
import br.com.vuttr.repository.VuttrTagsRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author felipessca
 *
 */
@Service
@ApiModel(description = "Serviços que acessam o repositório ou DAO")
public class VuttrMainService {

	@Autowired
	VuttrMainRepository vuttrMainRepository;
	@Autowired
	VuttrTagsRepository vuttrTagsRepository;

	@ApiModelProperty(notes ="Serviço responsável por buscas Vuttr por ID" )
	public VuttrMain findByid(Integer id) {
		Optional<VuttrMain> optional = vuttrMainRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Resource not found using this id!"));
	}
	
	@ApiModelProperty(notes ="Serviço responsável por buscas Vuttr por Palavras chave" )
	public List<VuttrMain> findVuttrMainByWord(String word) {
		Optional <List<VuttrMain>> optional = vuttrMainRepository.searchByTitleLike(word);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Resource not found using this id!"));
	}
	@ApiModelProperty(notes ="Serviço responsável por buscas todos Vuttr" )
	public List<VuttrMain> findAllVuttrMain() {
		return vuttrMainRepository.findAll();
	}

	@Transactional
	@ApiModelProperty(notes ="Serviço responsável por inserir dados Vuttr" )
	public VuttrMain insertVuttrMain(VuttrMain vuttrMain) {
		vuttrMain.setId(null);
		return vuttrMainRepository.save(vuttrMain);
	}

	@Transactional
	@ApiModelProperty(notes ="Serviço responsável por deletar Vuttr por ID" )
	public void deleteVuttrMainById(Integer id) {
		if (findByid(id) == null) {
			throw new ObjectNotFoundException("Resource not found using this id!");
		}
		vuttrMainRepository.deleteById(id);
	}


}
