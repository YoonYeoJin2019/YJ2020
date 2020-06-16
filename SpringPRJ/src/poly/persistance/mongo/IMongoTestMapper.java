package poly.persistance.mongo;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
import poly.dto.LoginDTO;

public interface IMongoTestMapper {

	public boolean createCollection(String colNm) throws Exception;

	public int insertdate(LoginDTO lDTO, String colNm)throws Exception;

	public int selectdata(String colNm, String user_nickname, String date_date)throws Exception;

	public int inserthealth1(HealthDTO hDTO, String colNm)throws Exception;

	public int selecthealth1(String colNm)throws Exception;

	public int selecthealth2(String colNm)throws Exception;

	public int inserthealth2(ExplainDTO eDTO, String colNm)throws Exception;

	public HealthDTO selecthealth3(String pose_name)throws Exception;

	
}
