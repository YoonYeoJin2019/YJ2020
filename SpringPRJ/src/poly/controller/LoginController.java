package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.LoginDTO;
import poly.dto.MailDTO;
import poly.service.ILoginService;
import poly.service.IMailService;
import poly.service.IMongoTestService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.EncryptUtil;

@Controller
public class LoginController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="LoginService")
	private ILoginService loginservice;
	
	
	@Resource(name="MailService")
	private IMailService mailService;
	
	
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
	
	
	//회원가입 실행
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
	// 아이디 찾기 실행
	@RequestMapping(value="loginfindsh")
	public String Loginfindsh(HttpServletRequest request,HttpServletResponse response,Model model)throws Exception {
		
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");

		log.info(user_name+"이름");
		log.info(user_email+"메일");
		
		LoginDTO lDTO = new LoginDTO(); // 보내는 통
	
		log.info(user_name+"이름");
		log.info(user_email+"메일");
		
		try {
			
			lDTO.setUser_name(user_name);
			lDTO.setUser_email(EncryptUtil.encAES128CBC(user_email));
		
			lDTO = loginservice.idfindsh(lDTO);
						
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if (lDTO == null) {
			model.addAttribute("msg", "가입된 아이디가 없습니다.");
			model.addAttribute("url", "/loginfind.do");
		} else {
			model.addAttribute("msg", "가입된 아이디는 " + lDTO.getUser_id() + " 입니다.");
			model.addAttribute("url", "/login.do");
		}
		
	return "redirect";
	}
	//비밀번호 찾기 실행
	@RequestMapping(value="passfindsh")
	public String Passfindsh(HttpServletRequest request,HttpServletResponse response,Model model)throws Exception {
	
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_name = CmmUtil.nvl(request.getParameter("user_name"));
		String user_email = CmmUtil.nvl(EncryptUtil.encAES128CBC(request.getParameter("user_email")));
		
		log.info(user_name+"이름");
		log.info(user_email+"메일");
		log.info(user_id+"아이디");
		
		String msg="";
		String title="움직여 임시 비밀번호입니다.";
		String mail = CmmUtil.nvl(request.getParameter("user_email"));
			
		int result2 = 0;
		int result = 0;
		LoginDTO lDTO = new LoginDTO(); // 보내는 통
		MailDTO mDTO = new MailDTO();
		
		try {
				
			
			lDTO.setUser_id(user_id);
			lDTO.setUser_name(user_name);
			lDTO.setUser_email(user_email);
			
			
			lDTO = loginservice.passfindsh(lDTO);
			
			if(lDTO != null) {
				String user_password = EncryptUtil.getNewPw();
				
				lDTO.setUser_password(EncryptUtil.encHashSHA256(user_password));
				
				result2 = loginservice.upPW(lDTO);
				
				if(result2>0) {	
					
					msg+="안녕하세요 움직여입니다. 임시 비밀번호는 "+user_password+" 입니다";
	
					
					log.info(msg+"컨트롤러 메세지");
					log.info(title+"컨트롤러 제목");
					log.info(mail+"컨트롤러 받는사람");
					
					mDTO.setTitle(title);
					mDTO.setToMail(mail);
					mDTO.setContents(msg);
					
					result = mailService.doSendMail(mDTO);
					
					if(result>0) {
						model.addAttribute("msg","임시 비밀번호가 해당 이메일로 발송되었습니다.");
						model.addAttribute("url","/login.do");
					}else {
						model.addAttribute("msg","임시 비밀번호 발송에 실패하였습니다");
						model.addAttribute("url","/passfind.do");
					}
	
				}else {
					model.addAttribute("msg","임시 비밀번호 발송에 실패하였습니다");
					model.addAttribute("url","/passfind.do");
				}		
			}else {
				
				model.addAttribute("msg", "입력 정보를 다시 한번 확인해주세요");
				model.addAttribute("url", "/passfind.do");
					
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	return "redirect";
	}
	
	@RequestMapping(value = "setting")
	public String Setting(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) throws Exception{
		
		String user_nickname = (String) session.getAttribute("user_nickname");
		
		if(user_nickname==null) {
			
			model.addAttribute("msg", "접근 권한이 없습니다.");
			model.addAttribute("url", "/index.do");
			
			return "redirect";
			
		}
		
		
		log.info(user_nickname+"이게 닉네임인가???");
		
		LoginDTO lDTO = new LoginDTO();
		
		try {
			
		lDTO = loginservice.getuserinfo(user_nickname);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String um = EncryptUtil.decAES128CBC(lDTO.getUser_email());
		lDTO.setUser_email(um);
		
		log.info(lDTO.getUser_email()+"이메일---------");
		log.info(lDTO.getUser_id()+"아이디");
		log.info(lDTO.getUser_name()+"네임");
		log.info(lDTO.getUser_nickname()+"닉네임 -----------");
		
		
		
		model.addAttribute("lDTO", lDTO);
		
		
		lDTO = null;
		return "/login/setting";
	}
	
	@RequestMapping(value = "setting2")
	public String Setting2(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) {
		
		String user_nickname = (String) session.getAttribute("user_nickname");
		
		if(user_nickname==null) {
			
			model.addAttribute("msg", "접근 권한이 없습니다.");
			model.addAttribute("url", "/index.do");
			
			return "redirect";
			
		}	
		return "/login/setting2";
	}
	
	
	@RequestMapping(value = "setting2_sh")
	public String Setting2_sh(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session)throws Exception {
		
		String user_nickname = (String) session.getAttribute("user_nickname");	
		if(user_nickname==null) {
			model.addAttribute("msg", "접근 권한이 없습니다.");
			model.addAttribute("url", "/index.do");
			return "redirect";	
		}
		String user_password = CmmUtil.nvl(request.getParameter("newpass"));
		
		LoginDTO lDTO = new LoginDTO();
		
		String user_password2 = EncryptUtil.encHashSHA256(user_password);
		
		lDTO.setUser_nickname(user_nickname);
		lDTO.setUser_password(user_password2);	
		
		
		int res = 0;
		
		try {
		
			res = loginservice.updatepass(lDTO);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(res>0) {
			model.addAttribute("msg", "비밀번호가 변경되었습니다.");
			model.addAttribute("url", "/setting.do");
		}else {
			model.addAttribute("msg", "비밀번호가 변경에 실패하였습니다..");
			model.addAttribute("url", "/setting.do");
		}
	
		
		return "redirect";
	}
	
	
	@RequestMapping(value = "passCheck.do", method = RequestMethod.POST)
	public @ResponseBody int passCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_password = CmmUtil.nvl(request.getParameter("orgpass"));
		log.info("user_password : " + user_password);
		int count = 0;
	
		String user_password2 = EncryptUtil.encHashSHA256(user_password);

		count = loginservice.passCheck(user_password2);
		
		if (count > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
