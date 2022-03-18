package com.api.webapiloja.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.webapiloja.entities.Aplicativo;
import com.api.webapiloja.repositories.AplicativoRepository;



@RestController
@Api(value = "Loja")
public class LojaController {
	@Autowired
	private AplicativoRepository _aplicativoRepository;
	
	

	@RequestMapping(value = "/aplicativo", method = RequestMethod.GET, produces="application/json")
	public List<Aplicativo> Get(){
		return _aplicativoRepository.findAll();
	}
	
	@RequestMapping(value = "/aplicativo/{id}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<Aplicativo> GetById(@PathVariable(value = "id") UUID id){
		Optional<Aplicativo> aplicativo = _aplicativoRepository.findById(id);
		if(aplicativo.isPresent()) {
			return new ResponseEntity<Aplicativo>(aplicativo.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/aplicativo",method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public Aplicativo Post( @RequestBody Aplicativo aplicativo) {
		return _aplicativoRepository.save(aplicativo);
	}
	
	@RequestMapping(value = "/aplicativo/{id}", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	public ResponseEntity<Aplicativo> Put(@PathVariable(value = "id") UUID id, @RequestBody Aplicativo newAplicativo){
		Optional<Aplicativo> oldAplicativo = _aplicativoRepository.findById(id);
		if(oldAplicativo.isPresent()) {
			Aplicativo aplicativo = oldAplicativo.get();
			aplicativo.setAppCategory(newAplicativo.getAppCategory());
			aplicativo.setAppName(newAplicativo.getAppName());
			aplicativo.setAppPrice(newAplicativo.getAppPrice());
			return new ResponseEntity<Aplicativo>(aplicativo,HttpStatus.OK);
        }else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
}
