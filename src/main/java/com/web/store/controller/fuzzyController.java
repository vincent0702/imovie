package com.web.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.model.MovieBean;
import com.web.store.service.ProductServiec;

@Controller
public class fuzzyController {
	
	@Autowired
	ProductServiec service;
	
	@PostMapping(value= "/fuzzy.do", produces = {"application/json"})
	protected ResponseEntity<List<MovieBean>> searchType(Model model, HttpServletRequest request, HttpServletResponse response , 
			 @RequestParam (value = "fuzzyStr") String movieStr){
		
		List<MovieBean> Movie = service.getMovieByFuzzy(movieStr);
		ResponseEntity<List<MovieBean>> movie = new ResponseEntity<>(Movie,HttpStatus.OK);
		return movie;
		
	}
}
