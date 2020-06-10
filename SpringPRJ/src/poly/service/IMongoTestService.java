package poly.service;

import poly.dto.LoginDTO;

public interface IMongoTestService {

	
	public boolean createCollection() throws Exception;

	public int logindata(LoginDTO lDTO) throws Exception;

	
	
}
