package br.com.vuttr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vuttr.domain.entity.VuttrTags;
import br.com.vuttr.domain.service.VuttrTagsService;

@RestController
@RequestMapping("/tags")
public class VuttrTagsResource {
	
	@Autowired
	VuttrTagsService vuttrTagsService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VuttrTags> findVuttrTagsById(@PathVariable Integer id) {
		VuttrTags vuttrTags = vuttrTagsService.findById(id);
		return ResponseEntity.ok(vuttrTags);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VuttrTags>> findAllTags(){
		List<VuttrTags> vuttrTagsList = vuttrTagsService.findAllTags();
		return ResponseEntity.ok(vuttrTagsList);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity <List<VuttrTags>> insertTags(@RequestBody List<VuttrTags> vuttrTags){
		vuttrTagsService.insertAllTags(vuttrTags);
		return ResponseEntity.ok(vuttrTags);
		
		
	}
	
	
	
	

}
