package _02_login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import _01_register.model.MemberBean;

@Controller
@RequestMapping("/_02_login")
@SessionAttributes({"LoginOK"}) 
public class LogoutController {

	
	@GetMapping("/logout")
	// @ModelAttribute("LoginOK") MemberBean memberBean,
	public String logout(HttpSession session,  Model model, SessionStatus status, HttpServletRequest req) {
		String name = "";
		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
		if (memberBean != null) {
			name = memberBean.getName();
		}
//		model.addAttribute("memberName", name);
		status.setComplete();
		session.invalidate();
		return "redirect: " + req.getContextPath();
	}
}
