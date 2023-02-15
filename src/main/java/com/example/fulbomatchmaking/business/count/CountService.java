package com.example.fulbomatchmaking.business.count;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.count.model.Count;
import com.example.fulbomatchmaking.business.count.model.CountRequest;
import com.example.fulbomatchmaking.repositories.CountRepository;

@Service
public class CountService {
	
	@Autowired 
	private CountRepository countRepository;
	
	
	public Count getCount(CountRequest request) {
		return countRepository.findByUsAndPass(request.getUs(), request.getPass());
	}
	


}
