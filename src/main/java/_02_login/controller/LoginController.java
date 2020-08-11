package _02_login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;
import _02_login.model.LoginBean;
import _02_login.validate.LoginBeanValidator;

@Controller
@RequestMapping
@SessionAttributes({"LoginOK"}) 
public class LoginController {
	
	String loginForm = "loginandregister";
	String loginOut = "logout";
	String forgetForm = "forgetForm";
	@Autowired
	MemberService memberService;
	


	@GetMapping("/_02_login/login")
	public String login00(HttpServletRequest request, Model model, 
		@CookieValue(value="user", required = false) String user,
		@CookieValue(value="password", required = false) String password, 
		@CookieValue(value="rm", required = false) Boolean rm 
			) {
//		String cookieName = "";
		if (user == null)
			user = "";
		if (password == null) {
			password = "";
		} else {
			password = GlobalService.decryptString(GlobalService.KEY, password);
		}
		
		if (rm != null) {
			rm = Boolean.valueOf(rm);
		} else {
			rm = false;
		}
			
		LoginBean bean = new LoginBean(user, password, rm);
//		HttpSession session = request.getSession();
//		System.out.println("@GetMapping(\"/login\"), session.isNew()=" + session.isNew() + ", requestURI=" + session.getAttribute("requestURI"));
		model.addAttribute(bean);		
		return loginForm;
	}
	
	@PostMapping("/_02_login/login")
	public String checkAccount(
			@ModelAttribute("loginBean") LoginBean bean,
			BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		LoginBeanValidator validator = new LoginBeanValidator();
		validator.validate(bean, result);
		if (result.hasErrors()) {
			return loginForm;
		}
		String password =bean.getPassword();
		MemberBean mb = null;
		try {
			// 呼叫 loginService物件的 checkIDPassword()，傳入userid與password兩個參數
			mb = memberService.checkIdPassword(bean.getUserId(),  
					GlobalService.getMD5Endocing(GlobalService.encryptString(password)));
			if (mb != null) {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				model.addAttribute("LoginOK", mb);
			} else {
				// NG, 登入失敗, userid與密碼的組合錯誤，放相關的錯誤訊息到 errorMsgMap 之內
				result.rejectValue("invalidCredentials", "", "該帳號不存在或密碼錯誤");
				return loginForm;
			}
		} catch (RuntimeException ex) {
			result.rejectValue("userId", "", ex.getMessage());
			return loginForm;
		}
		HttpSession session = request.getSession();
//		System.out.println("@PostMapping(\"/login\"), session.isNew()=" + session.isNew() + ", requestURI=" + session.getAttribute("requestURI"));
		processCookies(bean, request, response);
		String nextPath = (String)session.getAttribute("requestURI");
		if (nextPath == null) {
			nextPath = request.getContextPath();
		}
		return "redirect: " + nextPath;
	}

	
	private void processCookies(LoginBean bean, HttpServletRequest request, HttpServletResponse response) {
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		String userId = bean.getUserId();
		String password = bean.getPassword();
		Boolean rm = bean.isRememberMe();
		
		// rm存放瀏覽器送來之RememberMe的選項，如果使用者對RememberMe打勾，rm就不會是null
		if (bean.isRememberMe()) {
			cookieUser = new Cookie("user", userId);
			cookieUser.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(7 * 24 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		} else { // 使用者沒有對 RememberMe 打勾
			cookieUser = new Cookie("user", userId);
			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(0);
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		
	}
	
//	@GetMapping("/updatepwd/pwd")
//	public String getPassword(HttpServletRequest request, Model model,  String email, String tel ) {
//			
//		MemberBean bean = new MemberBean(email, tel);
//
//		model.addAttribute(bean);		
//		return loginForm;
//	}
//	
//	@PostMapping("/updatepwd/pwd")
//	public String checkAccount2(
//			@ModelAttribute("memberBean") MemberBean bean,
//			BindingResult result, Model model,
//			HttpServletRequest request, HttpServletResponse response) {
//		
//		LoginBeanValidator validator = new LoginBeanValidator();
//		validator.validate(bean, result);
//		if (result.hasErrors()) {
//			return forgetForm;
//		}
//		String password =bean.getPassword();
//		MemberBean mb = null;
//		try {
//			// 呼叫 loginService物件的 checkIDPassword()，傳入userid與password兩個參數
//			mb = memberService.checkMailTel(bean.getEmail(), bean.getTel());
//			if (mb != null) {
//				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
//				model.addAttribute("checkOK", mb);
//				memberService.updatePassword(mb);
//			} else {
//				// NG, 登入失敗, userid與密碼的組合錯誤，放相關的錯誤訊息到 errorMsgMap 之內
//				result.rejectValue("invalidCredentials", "", "該Email不存在或電話錯誤");
//				return forgetForm;
//			}
//		} catch (RuntimeException ex) {
//			result.rejectValue("userId", "", ex.getMessage());
//			return forgetForm;
//		}
//		HttpSession session = request.getSession();
////		System.out.println("@PostMapping(\"/login\"), session.isNew()=" + session.isNew() + ", requestURI=" + session.getAttribute("requestURI"));
////		processCookies(bean, request, response);
//		String nextPath = (String)session.getAttribute("requestURI");
//		if (nextPath == null) {
//			nextPath = request.getContextPath();
//		}
//		return "redirect: ";
//	}

}
