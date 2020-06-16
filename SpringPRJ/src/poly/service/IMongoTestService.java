package poly.service;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
import poly.dto.LoginDTO;

public interface IMongoTestService {

	
	public boolean createCollection() throws Exception;

	public int logindata(LoginDTO lDTO) throws Exception;

	public int inserthealth1(HealthDTO hDTO)throws Exception;

	public int selecthealth1()throws Exception;

	public int selecthealth2()throws Exception;

	public int inserthealth2(ExplainDTO eDTO)throws Exception;

	public HealthDTO selecthealth3(String pose_name)throws Exception;

	
	
}
