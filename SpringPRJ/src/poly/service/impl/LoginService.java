package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.LoginDTO;
import poly.persistance.mapper.ILoginMapper;
import poly.service.ILoginService;
import poly.util.EncryptUtil;

@Service("LoginService")
public class LoginService implements ILoginService {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="ILoginMapper")
	private ILoginMapper loginmapper;

	@Override
	public int signupsh(LoginDTO lDTO) throws Exception {
		
		String hash = EncryptUtil.encHashSHA256(lDTO.getUser_password());
		
		String aes = EncryptUtil.encAES128CBC(lDTO.getUser_email());
		
		lDTO.setUser_password(hash);
		lDTO.setUser_email(aes);
		
		
		return loginmapper.signupsh(lDTO);
	}

	@Override
	public LoginDTO loginsh(LoginDTO lDTO) throws Exception {

		String hash1 = EncryptUtil.encHashSHA256(lDTO.getUser_password());
		
		lDTO.setUser_password(hash1);
		
		log.info(lDTO.getUser_password()+"패스워드???");
		log.info(lDTO.getUser_id()+"아이디???");
		
		return loginmapper.loginsh(lDTO);
	}

	@Override
	public LoginDTO idfindsh(LoginDTO lDTO) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.idfindsh(lDTO);
	}

	@Override
	public LoginDTO passfindsh(LoginDTO lDTO) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.passfindsh(lDTO);
	}

	@Override
	public int upPW(LoginDTO lDTO) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.upPW(lDTO);
	}

	@Override
	public LoginDTO getuserinfo(String user_nickname) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.getuserinfo(user_nickname);
	}

	@Override
	public int passCheck(String user_password2) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.passCheck(user_password2);
	}

	@Override
	public int updatepass(LoginDTO lDTO) throws Exception {
		// TODO Auto-generated method stub
		return loginmapper.updatepass(lDTO);
	}
	
	
}
