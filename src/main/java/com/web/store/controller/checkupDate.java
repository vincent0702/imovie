package com.web.store.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.service.ProductServiec;

//@RequestMapping("_03_listBooks") 有另外folder再訂
//@SessionAttributes({"OrderCart","FoodCart"}) //"LoginOK"
@Controller
public class checkupDate {
	@Autowired
	ProductServiec service;
	
	@PostMapping(value= "/checkOrder", produces = {"application/json"})
	protected ResponseEntity<Map<String,String>> checkDate(Model model, HttpServletRequest request, HttpServletResponse response , 
			@RequestParam (value = "tStart") String start,
			@RequestParam (value = "tEnd") String end,
			@RequestParam (value = "tDate") String date,
			@RequestParam (value = "roomID") String roomidd
						) throws ServletException, IOException, ParseException {
		Map<String,String> map = new HashMap<>();
					System.out.println("已進來checkDate");		
		int roomId  = Integer.parseInt(roomidd.trim());
		boolean testDB = service.checkOrderTime(roomId,date,start,end);
		
		if(testDB) {
			map.put("OK","時段OK");
		}else {
			map.put("warning","選擇時段已被預訂，請重新選擇");
		}
		
		ResponseEntity<Map<String,String>> re = new ResponseEntity<>(map,HttpStatus.OK);
		return re;
							
							
	}
	
	
	
}
