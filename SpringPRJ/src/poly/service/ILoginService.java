package poly.service;

import poly.dto.LoginDTO;

public interface ILoginService {

	int signupsh(LoginDTO lDTO) throws Exception;

	LoginDTO loginsh(LoginDTO lDTO)throws Exception;

}
