package poly.persistance.mapper;

import config.Mapper;
import poly.dto.LoginDTO;

@Mapper("ILoginMapper")
public interface ILoginMapper {

	int signupsh(LoginDTO lDTO) throws Exception;

	LoginDTO loginsh(LoginDTO lDTO)throws Exception;

	LoginDTO idfindsh(LoginDTO lDTO)throws Exception;

	LoginDTO passfindsh(LoginDTO lDTO)throws Exception;

	int upPW(LoginDTO lDTO)throws Exception;

	
	
	
}
