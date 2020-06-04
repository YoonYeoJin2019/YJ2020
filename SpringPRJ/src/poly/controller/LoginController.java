package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="login")
	public String Login(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/login";
	}
	
	@RequestMapping(value="signup")
	public String Signup(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/signup";
	}
	
	@RequestMapping(value="passfind")
	public String Passfind(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/passfind";
	}
	
	@RequestMapping(value="loginfind")
	public String Loginfind(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/loginfind";
	}
}
