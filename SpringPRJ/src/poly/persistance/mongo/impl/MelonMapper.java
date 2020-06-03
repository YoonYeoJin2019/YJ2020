package poly.persistance.mongo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;

import poly.dto.MelonDTO;
import poly.persistance.mongo.IMelonMapper;

@Component("MelonMapper")
public class MelonMapper implements IMelonMapper {

	@Autowired
	private MongoTemplate mongodb;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean createCollection(String colNm) throws Exception{
		
		log.info(this.getClass().getName()+".createCollection Start!");
		
		
		boolean res = false;
		
		// 기존에 등록된 컬렉션 이름이 존재하는지 체크하고, 존재하면 기존 컬렉션 삭제함
		if(mongodb.collectionExists(colNm)) {
			
			mongodb.dropCollection(colNm); // 기존 컬렉션 삭제
			
		}
		
		mongodb.createCollection(colNm).createIndex(new BasicDBObject("collect_time",1).append("rank", 1),"reankIdx");
		
		res = true;
		
		
		log.info(this.getClass().getName()+".createCollection Stop!");
		
		
		return res;
	}

	@Override
	public int insertRank(List<MelonDTO> pList, String colNm) throws Exception {
		// TODO Auto-generated method stub
		
		return 1;
	}
	
	
	
	
}
