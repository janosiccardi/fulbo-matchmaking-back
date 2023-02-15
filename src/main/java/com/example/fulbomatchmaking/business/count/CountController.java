package com.example.fulbomatchmaking.business.count;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.count.model.Count;
import com.example.fulbomatchmaking.business.count.model.CountRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("count")
public class CountController {

	@Autowired
	private CountService service;
		
	
	@PostMapping("/get")
	public Count getCount(@RequestBody CountRequest request) {
		return service.getCount(request);
	}
	
}
