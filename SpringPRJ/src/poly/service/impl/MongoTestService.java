package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
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
		
		String colNm = "DATE_INFO";
		
		int ress = 0;
				
		ress = mongoTestMapper.selectdata(colNm,lDTO.getUser_nickname(),lDTO.getDate_date());
		
		if(ress==0) {
		
		mongoTestMapper.insertdate(lDTO, colNm);
		}
		
		
		return res;
	}


	@Override
	public int inserthealth1(HealthDTO hDTO) throws Exception {
		
		int res = 0;
		
		String colNm = "HEALTH_INFO";
		
		 res = mongoTestMapper.inserthealth1(hDTO,colNm);
		
		return res;
	}


	@Override
	public int selecthealth1() throws Exception {
		// TODO Auto-generated method stub
		int res = 0;
		String colNm = "HEALTH_INFO";
		res = mongoTestMapper.selecthealth1(colNm);
		
		
		return res;
	}


	@Override
	public int selecthealth2() throws Exception {
		int res = 0;
		String colNm = "EXPLAIN_INFO";
		res = mongoTestMapper.selecthealth2(colNm);
		
	
		return res;
	}

	@Override
	public int inserthealth2(ExplainDTO eDTO) throws Exception {
		
		int res = 0;
		
		String colNm = "EXPLAIN_INFO";
		
		 res = mongoTestMapper.inserthealth2(eDTO,colNm);
		
		return res;
	}


	@Override
	public HealthDTO selecthealth3(String pose_name) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.selecthealth3(pose_name);
	}
	
	
	
}
