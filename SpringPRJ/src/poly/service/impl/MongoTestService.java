package poly.service.impl;

import java.util.List;

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
	public HealthDTO selecthealth1() throws Exception {
		// TODO Auto-generated method stub

		String colNm = "HEALTH_INFO";	
		return mongoTestMapper.selecthealth1(colNm);
	}

	@Override
	public ExplainDTO selecthealth2() throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.selecthealth2();
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


	@Override
	public List<HealthDTO> getindexlist() throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.getindexlist();
	}


	@Override
	public ExplainDTO getready(String health_no) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.getready(health_no);
	}


	@Override
	public int ready_del(String health_no) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.ready_del(health_no);
	}


	@Override
	public HealthDTO getready_1_up(String health_no) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.getready_1_up(health_no);
	}


	@Override
	public int update_ready_1_up_sh(HealthDTO hDTO) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.update_ready_1_up_sh(hDTO);
	}


	@Override
	public int ready_2_up_sh(ExplainDTO eDTO) throws Exception {
		// TODO Auto-generated method stub
		return mongoTestMapper.ready_2_up_sh(eDTO);
	}



	
	
	
}
