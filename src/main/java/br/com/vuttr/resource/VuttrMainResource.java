package br.com.vuttr.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vuttr.domain.entity.VuttrMain;
import br.com.vuttr.domain.service.VuttrMainService;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author felipessca
 *
 */

@RestController
@RequestMapping("/api/tools")
@CrossOrigin(origins = {

		"http://localhost:4200" }, allowedHeaders = "*", allowCredentials = "false", maxAge = 15
				* 60, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, })

public class VuttrMainResource {

	@Autowired
	private VuttrMainService vuttrMainService;

	@ApiOperation(value = "Expor verbos da API", notes = "Verbos Http aceitos para essa api")
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<?> CollectionOptions() {
		return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS, HttpMethod.DELETE)
				.build();
	}

	@ApiOperation(value = "Buscar VuttrMain pelo ID.", notes = "Metodo responsável por buscar tools por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VuttrMain> findVuttrMainById(@PathVariable Integer id) {
		VuttrMain vuttrMain = vuttrMainService.findByid(id);
		return ResponseEntity.ok(vuttrMain);
	}

	@ApiOperation(value = "Buscar VuttrMain por palavra.", notes = "Metodo responsável por buscar tools por palavras chave")
	@RequestMapping(value = "/title", method = RequestMethod.GET)
	public ResponseEntity<List<VuttrMain>> findVuttrMainByWord(
			@RequestParam(value = "name", required = false) String name) {
		List<VuttrMain> vuttrMain = vuttrMainService.findVuttrMainByWord(name);
		return ResponseEntity.ok(vuttrMain);
	}

	@ApiOperation(value = "Buscar todos os registor de VuttrMain ", notes = "Metodo responsável por buscar todos Vuttrs")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VuttrMain>> findAllVuttrMain() {
		List<VuttrMain> vuttrMainList = vuttrMainService.findAllVuttrMain();
		return ResponseEntity.ok(vuttrMainList);
	}

	@ApiOperation(value = "Inserir dados Vuttr sem as TAGs ", notes = "Metodo responsável por inserir os atributos Vuttrs sem utilizar as TAGS")
	@RequestMapping(path = "/main", method = RequestMethod.POST)
	public ResponseEntity<Void> insertVuttrMain(@RequestBody VuttrMain vuttrMain) {
		vuttrMainService.insertVuttrMain(vuttrMain);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vuttrMain.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Inserir dados Vuttr ", notes = "Metodo responsável por inserir os atributos Vuttrs")
	@RequestMapping(path = "/",method = RequestMethod.POST)
	public ResponseEntity<URI> insertVuttrMainTags(@RequestBody VuttrMain vuttrMain) {
		vuttrMainService.insertVuttrMain(vuttrMain);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vuttrMain.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Deletar registros por id ", notes = "Metodo responsável por deletar todos os registros por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVttrMainById(@PathVariable Integer id) {
		vuttrMainService.deleteVuttrMainById(id);
		return ResponseEntity.noContent().build();

	}

}
