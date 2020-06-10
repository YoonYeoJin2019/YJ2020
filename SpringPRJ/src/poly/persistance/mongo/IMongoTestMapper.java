package poly.persistance.mongo;

import poly.dto.LoginDTO;

public interface IMongoTestMapper {

	public boolean createCollection(String colNm) throws Exception;

	public int insertdate(LoginDTO lDTO, String colNm)throws Exception;

	public int selectdata(String colNm, String user_nickname, String date_date)throws Exception;



	
	
}
