package com.sgu.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sgu.service.UserService;

public class AdminController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/terms_service")
	public String TermsService(Model model) {
		//Đăng xuất nếu cần thiết
	    //session.setAttribute("admin", null);
	    return "terms_service";
	}


	@GetMapping("/signin-admin")
	public String SignInAdminView(Model model) {
		String err_sign_admin = (String) session.getAttribute("err_sign_admin");
		model.addAttribute("err_sign_admin", err_sign_admin);
		session.setAttribute("err_sign_admin", null);
		return "signin-admin";
	}

	@PostMapping("/signin-admin")
	public String SignInAdminHandel(@ModelAttribute("login-name") String login_name,
			@ModelAttribute("pass") String pass, Model model) throws Exception {
		User admin = userService.findByIdAndRole(login_name, "admin");
		System.out.println(admin);
		if (admin == null) {
			session.setAttribute("err_sign_admin", "Username or Password is not correct!");
			return "redirect:/signin-admin";
		} else {
			String decodedValue = new String(Base64.getDecoder().decode(admin.getPassword()));
			if (!decodedValue.equals(pass)) {
				session.setAttribute("err_sign_admin", "Username or Password is not correct!");
				return "redirect:/signin-admin";
			} else {
				System.out.println(admin);
				session.setAttribute("admin", admin);
				return "redirect:/dashboard";
			}
		}
	}

	@GetMapping("/logout-admin")
	public String LogOutAdmin(Model model) {
		session.setAttribute("admin", null);
		return "redirect:/signin-admin";
	}


}
