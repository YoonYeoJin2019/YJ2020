package poly.service;

import java.util.List;

import poly.dto.LoginDTO;
import poly.dto.Search;

public interface ILoginService {

	int signupsh(LoginDTO lDTO) throws Exception;

	LoginDTO loginsh(LoginDTO lDTO)throws Exception;

	LoginDTO idfindsh(LoginDTO lDTO)throws Exception;

	LoginDTO passfindsh(LoginDTO lDTO)throws Exception;

	int upPW(LoginDTO lDTO)throws Exception;

	LoginDTO getuserinfo(String user_nickname)throws Exception;

	int passCheck(String user_password2)throws Exception;

	int updatepass(LoginDTO lDTO)throws Exception;

	int cntpage2(Search search)throws Exception;

	List<LoginDTO> getuserinfo2(Search search)throws Exception;

	LoginDTO getuserinfo3(String user_no)throws Exception;

}
