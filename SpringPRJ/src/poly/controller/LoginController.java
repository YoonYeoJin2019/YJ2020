package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.LoginDTO;
import poly.service.ILoginService;
import poly.service.IMongoTestService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Controller
public class LoginController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="LoginService")
	private ILoginService loginservice;
	
	
	@Resource(name="MongoTestService")
	private IMongoTestService mongoservice;
	
	
	@RequestMapping(value="redirect")
	public String Redirect(HttpServletRequest request,HttpServletResponse response) {
	
	return "/redirect";
	}
	
	
	//로그인 페이지
	@RequestMapping(value="login")
	public String Login(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/login";
	}
	
	//로그아웃
	@RequestMapping(value="logout")
	public String Logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
	
		
		session.invalidate();
		
	return "pose/index";
	}
	
	
	//로그인 실행
	@RequestMapping(value="loginsh")
	public String Loginsh(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) {
	
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_password = CmmUtil.nvl(request.getParameter("user_password"));
		String user_nickname = "";
			
		String date_date = DateUtil.getDateTime("yyyy-MM-dd");
		
		//lDTO.setDate_date(date_date);
		
		int res = 0;
		
		
		
		LoginDTO lDTO = new LoginDTO();
		log.info("패스워드.."+user_password);
		
		
		try {
			
			lDTO.setUser_id(user_id);
			lDTO.setUser_password(user_password);
			
			lDTO = loginservice.loginsh(lDTO);
				
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(lDTO==null) {
			model.addAttribute("msg", "로그인에 실패하셨습니다.");
			model.addAttribute("url", "/login.do");
			return "redirect";
		}else if(!(lDTO.getUser_stat().equals("0"))){
			model.addAttribute("msg", "정지 혹은 탈퇴 회원입니다..");
			model.addAttribute("url", "/login.do");
			return "redirect";
		}else {
	
			
			session.setAttribute("user_nickname", lDTO.getUser_nickname());
			session.setAttribute("user_auth", lDTO.getUser_auth());
			
			user_nickname = lDTO.getUser_nickname();
			
			lDTO = null;
			
			lDTO = new LoginDTO();
			
			lDTO.setUser_nickname(user_nickname);
			lDTO.setDate_date(date_date);
			
			try {
				
				res = mongoservice.logindata(lDTO);
						
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			

			lDTO = null;
			
			return "pose/index";
		}
		
		
	
	}
	
	
	
	@RequestMapping(value="signup")
	public String Signup(HttpServletRequest request,HttpServletResponse response) {
	
	return "/login/signup";
	}
	
	@RequestMapping(value="signupsh")
	public String Signupsh(HttpServletRequest request,HttpServletResponse response,Model model) {
	
		
		log.info(this.getClass().getName() + ".signupsh start!");
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_name = CmmUtil.nvl(request.getParameter("user_name"));
		String user_password = CmmUtil.nvl(request.getParameter("user_password"));
		String user_nickname = CmmUtil.nvl(request.getParameter("user_nickname"));
		String user_email = CmmUtil.nvl(request.getParameter("user_email"));
		String user_auth = "0";
		String user_stat = "0";
		
		LoginDTO lDTO = new LoginDTO();
		
		int result = 0;
		
		try {
			
			lDTO.setUser_id(user_id);
			lDTO.setUser_name(user_name);
			lDTO.setUser_password(user_password);
			lDTO.setUser_nickname(user_nickname);
			lDTO.setUser_email(user_email);
			lDTO.setUser_auth(user_auth);
			lDTO.setUser_stat(user_stat);
			
			
			result = loginservice.signupsh(lDTO);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(result>0) {
			
			model.addAttribute("msg","회원가입에 성공하였습니다." );
			model.addAttribute("url","/signup.do" );
		
			
		}else {
			model.addAttribute("msg","회원가입에 실패하였습니다." );
			model.addAttribute("url","/signup.do" );
			
		}
		
		lDTO = null;
		
		return "redirect";
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
