package _01_register.controller;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;
import _01_register.validator.MemberBeanValidator;



@Controller
@RequestMapping
@SessionAttributes({"checkOK"})
public class RegisterController {
	
	String rootDirectory = "d:\\images";
	String inputDataForm = "registerForm"; 
	String inputDataForm2 = "registerForm2"; 
	String forgetForm = "forgetForm";
	@Autowired
	MemberService memberService;
	
	@GetMapping("/_01_register/register")
	public String sendingEmptyForm(Model model) {
		MemberBean memberBean = new MemberBean();
		memberBean.setName("" );
		memberBean.setPassword("");
		memberBean.setPassword1("");
		memberBean.setMemberId("");
		memberBean.setAddress("");
		memberBean.setTel("");
		memberBean.setEmail("");
		model.addAttribute("memberBean", memberBean);
		return inputDataForm;
	}

	@PostMapping("/_01_register/register")
	public String processFormData(
			@ModelAttribute("memberBean") MemberBean bean,
			BindingResult result, Model model,
			HttpServletRequest request
			) {
		MemberBeanValidator validator = new MemberBeanValidator();
		validator.validate(bean, result);
		if (result.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤			
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
			return inputDataForm;
		}
		
		MultipartFile picture = bean.getMemberMultipartFile();
		String originalFilename = picture.getOriginalFilename();
		System.out.println(picture+"===========================");
		String ext = "";
		if (originalFilename.lastIndexOf(".") > -1) {
			ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		}
		
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			bean.setFileName(originalFilename);
		}
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				bean.setMemberImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		String password = bean.getPassword();
		password = GlobalService.getMD5Endocing(
				GlobalService.encryptString(password));
		bean.setPassword(password);
		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		bean.setRegisterTime(registerTime);
		// 檢查 memberId是否重複
		if (memberService.idExists(bean.getMemberId())) {
			result.rejectValue("memberId", "", "帳號已存在，請重新輸入");
			return inputDataForm;
		}
		
		try {
			memberService.saveMember(bean);
		} 
//		catch (org.hibernate.exception.ConstraintViolationException e) {
//			result.rejectValue("memberId", "", "帳號已存在，請重新輸入");
//			return inputDataForm;
//		} 
		catch (Exception ex) {
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
			result.rejectValue("memberId", "", "發生異常，請通知系統人員..." + ex.getMessage());
			return inputDataForm;
		}
		// 將上傳的檔案移到指定的資料夾, 目前註解此功能
		try {
			File imageFolder = new File(rootDirectory, "images");
			if (!imageFolder.exists())
				imageFolder.mkdirs();
			File file = new File(imageFolder, "MemberImage_" + bean.getMemberId() + ext);
			picture.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
//		return "redirect: " + request.getContextPath();
		return "redirect: ../_02_login/login";
	}
	@ModelAttribute
	public MemberBean prepareMemberBean(HttpServletRequest req) {
		MemberBean memberBean = new MemberBean();
		return memberBean;
	}
	@GetMapping(value = "/_01_register/mem/{pkey}")
	public String showDataForm(@PathVariable("pkey") Integer pkey, Model model) {
		MemberBean memberBean = memberService.get(pkey);
		model.addAttribute(memberBean);
		return inputDataForm2;
	}
	@PostMapping("/_01_register/mem/{pkey}")
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	// 
	public String modify(
			@ModelAttribute("memberBean") MemberBean bean, 
			BindingResult result, 
			Model model,
			@PathVariable Integer pkey, 
			HttpServletRequest request) {
		long sizeInBytes = 0;
		InputStream is = null;
		MultipartFile productImage = bean.getMemberMultipartFile();
		String originalFilename = productImage.getOriginalFilename();
		bean.setFileName(originalFilename);
		String password = bean.getPassword();
		password = GlobalService.getMD5Endocing(
				GlobalService.encryptString(password));
		bean.setPassword(password);
		//  建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty() ) {
			
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				bean.setMemberImage(blob);
				sizeInBytes = 1;
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else {
			sizeInBytes = -1;
		}
//		
		
		memberService.updateMember(bean,sizeInBytes);
		return "redirect:/_01_register/mem/{pkey}";
	}
	
	@ModelAttribute
	public void getMember(@PathVariable(value="pkey", required = false ) Integer pkey, Model model) {
		System.out.println("@ModelAttribute.getMember()...");
		if (pkey != null) {
			MemberBean memberBean = memberService.get(pkey);
			model.addAttribute("memberBean", memberBean);
			System.out.println("@ModelAttribute.getMember()...111");

		} else {
			MemberBean memberBean = new MemberBean();
			memberBean.setLogin("false");
			model.addAttribute("memberBean", memberBean);
			
			System.out.println("@ModelAttribute.getMember()...222");

		}
	}
	
	@ModelAttribute
	public void commonData(Model model) {
		Map<String, String> genderMap = new HashMap<>();
		genderMap.put("M", "Male");
		genderMap.put("F", "Female");
		model.addAttribute("genderMap", genderMap);
	}
	
	@GetMapping("/updatepwd/pwd")
	public String getPassword(HttpServletRequest request, Model model,  String email, String tel ) {
			
		MemberBean bean = new MemberBean(email, tel);

		model.addAttribute(bean);		
		return forgetForm;
	}
	@GetMapping("/clearcheckOK")
	public String clearcheckOK(HttpSession session,  Model model, SessionStatus status, HttpServletRequest req) {
		String name = "";
		MemberBean memberBean = (MemberBean) session.getAttribute("checkOK");
		if (memberBean != null) {
			name = memberBean.getName();
		}
//		model.addAttribute("memberName", name);
		status.setComplete();
		session.invalidate();
		return null;
	}
	@PostMapping("/updatepwd/pwd")
	public String checkAccount2(
//			Imovie/updatepwd/pwd
			@ModelAttribute("memberBean") MemberBean bean,
			BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("12315645665");
//		LoginBeanValidator validator = new LoginBeanValidator();
//		validator.validate(bean, result);
//		if (result.hasErrors()) {
//			System.out.println("44444444444");
//
//			return forgetForm;
//		}
		System.out.println("333333333333");

		String password =bean.getPassword();
		MemberBean mb = null;
		try {
			// 呼叫 loginService物件的 checkIDPassword()，傳入userid與password兩個參數
			mb = memberService.checkMailTel(bean.getEmail(), bean.getTel());
			if (mb != null) {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				System.out.println("成功成功成功成功成功成功成功成功");
				model.addAttribute("checkOK", mb);
				memberService.updatePassword(mb);
				System.out.println("成功成功成功成功成功成功成功成功aaaaaaaaaa");

			} else {
				// NG, 登入失敗, userid與密碼的組合錯誤，放相關的錯誤訊息到 errorMsgMap 之內
				System.out.println("gGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//				result.rejectValue("invalidCredentials", "", "該Email不存在或電話錯誤");
				model.addAttribute("error", "該Email不存在或電話錯誤");
				return forgetForm;
			}
		} catch (RuntimeException ex) {
			result.rejectValue("userId", "", ex.getMessage());
			return forgetForm;
		}
		HttpSession session = request.getSession();
//		System.out.println("@PostMapping(\"/login\"), session.isNew()=" + session.isNew() + ", requestURI=" + session.getAttribute("requestURI"));
//		processCookies(bean, request, response);
		String nextPath = (String)session.getAttribute("requestURI");
		if (nextPath == null) {
			nextPath = request.getContextPath();
		}
		//model.addAttribute("error", "該Email不存在或電話錯誤");
		
		return "redirect: ../_02_login/login";
	}	
}
