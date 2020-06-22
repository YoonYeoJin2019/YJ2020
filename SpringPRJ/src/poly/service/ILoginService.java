package poly.service;

import poly.dto.LoginDTO;

public interface ILoginService {

	int signupsh(LoginDTO lDTO) throws Exception;

	LoginDTO loginsh(LoginDTO lDTO)throws Exception;

	LoginDTO idfindsh(LoginDTO lDTO)throws Exception;

	LoginDTO passfindsh(LoginDTO lDTO)throws Exception;

	int upPW(LoginDTO lDTO)throws Exception;

	LoginDTO getuserinfo(String user_nickname)throws Exception;

	int passCheck(String user_password2)throws Exception;

	int updatepass(LoginDTO lDTO)throws Exception;

}
