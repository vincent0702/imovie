package com.web.store.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.model.SurveyBean;
import com.web.store.service.ProductServiec;

import _01_register.model.MemberBean;

@Controller
@SessionAttributes({"orderNo","orderDate","LoginOK"})
public class SurveyController {

	@Autowired
	ProductServiec service;
	
	@GetMapping("/survey153")
	protected String toSurvey(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		MemberBean mb = (MemberBean)model.getAttribute("LoginOK");/////判斷使用者
		String orderno = request.getParameter("rate");
		List<SurveyBean> sb= service.getSurveyByNo(orderno);
		if(sb.size()!=0) {
			model.addAttribute("ratebefore","*您已經評論過此筆訂單");
			String yourcom = sb.get(0).getComment();
			String comtime = sb.get(0).getCommentTime();
			Integer satis = sb.get(0).getSatisfaction();
			model.addAttribute("yourcom",yourcom);
			model.addAttribute("comtime","*上次評論時間："+comtime);
			model.addAttribute("satis",satis);
			
		}
		
		String number = request.getParameter("orderNumber");
		String date = request.getParameter("orderDate");
		String movieName = (service.getProductById1((Integer.parseInt(request.getParameter("movie"))))).getMovieName();
		String roomName = (service.getProductById2((Integer.parseInt(request.getParameter("room"))))).getRoomName();
		model.addAttribute("orderNo",number);
		model.addAttribute("orderDate",date);
		model.addAttribute("movieName",movieName);
		model.addAttribute("roomName",roomName);
		return "survey"; //回到歷史清單
	}
	@PostMapping("/insertComment")
	protected String todb(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String aa = request.getParameter("comment");
		int rate = Integer.parseInt(request.getParameter("satisfy"));
		
		System.out.println(rate);
		System.out.println(aa);
		
		Date currentTime = new Date();
		SimpleDateFormat  sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String strDate = sdFormat.format(currentTime);

		String date = String.valueOf(model.getAttribute("orderDate"));
		String number = String.valueOf(model.getAttribute("orderNo"));
		SurveyBean surveybean = new SurveyBean(null,number,date,rate,aa,strDate);
		service.saveSurvey(surveybean);
		
		return "redirect:/allmyorder"; //回到歷史清單
	}
	@GetMapping("/surveyCancle")
	protected String cancleSurvey(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		return "redirect:/allmyorder"; //回到歷史清單
	}
	
	@GetMapping(value= "/satisfyRate", produces = {"application/json"})
	protected ResponseEntity<Double> survey(Model model, HttpServletRequest request, HttpServletResponse response){
		
		Double rate = service.getSatisfy();
		ResponseEntity<Double> re = new ResponseEntity<>(rate,HttpStatus.OK);
		return re;
		
	}
			
}
