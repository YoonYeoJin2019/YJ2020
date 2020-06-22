package poly.service;

import java.util.List;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
import poly.dto.LoginDTO;

public interface IMongoTestService {

	
	public boolean createCollection() throws Exception;

	public int logindata(LoginDTO lDTO) throws Exception;

	public int inserthealth1(HealthDTO hDTO)throws Exception;

	public HealthDTO selecthealth1()throws Exception;

	public int inserthealth2(ExplainDTO eDTO)throws Exception;

	public HealthDTO selecthealth3(String pose_name)throws Exception;

	public List<HealthDTO> getindexlist()throws Exception;

	public ExplainDTO getready(String health_no)throws Exception;

	public int ready_del(String health_no)throws Exception;

	public HealthDTO getready_1_up(String health_no)throws Exception;

	public int update_ready_1_up_sh(HealthDTO hDTO)throws Exception;

	public int ready_2_up_sh(ExplainDTO eDTO)throws Exception;

	public ExplainDTO selecthealth2()throws Exception;


	
	
}
