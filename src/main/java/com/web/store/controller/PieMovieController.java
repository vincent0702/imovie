package com.web.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.model.HomeBean;
import com.web.store.service.ProductServiec;

//@SessionAttributes({"orderNo","orderDate"})
@Controller
public class PieMovieController {
	
	@Autowired
	ProductServiec service;
	
	@GetMapping(value= "/moviePie", produces = {"application/json"})
	protected ResponseEntity<List<Map<String,String>>> survey(Model model, HttpServletRequest request, HttpServletResponse response){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Integer> MovieList = service.getOrderedMidList();
		
		for(Integer Mid:MovieList) {
			Map<String,String> map = new HashMap<String, String>();
			String movieName = service.getMovieNameById(Mid);
			String moviePervent = service.getPercenstByMId(Mid);
			map.put("name", movieName);
			map.put("percent", moviePervent);
			
			list.add(map);
		}
		
		ResponseEntity<List<Map<String,String>>> re = new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/moviePieTest")//新增首頁圖畫面，回傳空表單
	public String homeIn(Model model) {
		return "Manager/PieMovie";
	}

}
