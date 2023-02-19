package com.example.fulbomatchmaking.business.generator;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fulbomatchmaking.business.generator.model.GenerateTeamsRequest;
import com.example.fulbomatchmaking.business.generator.model.GenerateTeamsResponse;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("generate")
public class TeamGeneratorController {
	
	@Autowired
    private TeamGeneratorService service;
   
	   @CrossOrigin
	   @PostMapping("/generateTeams")
	    public GenerateTeamsResponse create(@RequestBody GenerateTeamsRequest request) {		   	
		   try {
	        return service.generateTeams(request);
		   }catch(Exception e) {
			   System.out.println(e.getMessage());
			  return null;
		   }
	    }
	   
}
