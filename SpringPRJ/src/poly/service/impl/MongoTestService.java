package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.LoginDTO;

import poly.persistance.mongo.IMongoTestMapper;
import poly.service.IMongoTestService;

@Service("MongoTestService")
public class MongoTestService implements IMongoTestService{

	@Resource(name="MongoTestMapper")
	private IMongoTestMapper mongoTestMapper;
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean createCollection() throws Exception {
		
		String colNm = "MyTestCollection";
		
		return mongoTestMapper.createCollection(colNm);
	}

	
	
	
	
	
	
	@Override
	public int logindata(LoginDTO lDTO) throws Exception {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		String colNm = "User_login";
		
		
		int ress = 0;
		
			
		ress = mongoTestMapper.selectdata(colNm,lDTO.getUser_nickname(),lDTO.getDate_date());
		
		if(ress==0) {
		
		mongoTestMapper.insertdate(lDTO, colNm);
		}
		
		
		return res;
	}


	
	
	
}
