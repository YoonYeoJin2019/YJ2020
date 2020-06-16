package poly.persistance.mongo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
import poly.dto.LoginDTO;
import poly.persistance.mongo.IMongoTestMapper;
import poly.util.CmmUtil;


	
	@Component("MongoTestMapper")
	public class MongoTestMapper implements IMongoTestMapper{
		
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
			
			mongodb.createCollection(colNm).createIndex(new BasicDBObject("user_id1",1), "testIdx1");
			
			res = true;
			
			
			log.info(this.getClass().getName()+".createCollection Stop!");
			
			
			return res;
		}


		@Override
		public int insertdate(LoginDTO lDTO, String colNm) throws Exception {
			
			int res = 0;
					
			if(lDTO!=null) {
				mongodb.insert(lDTO, colNm);
				res = 1;
			}
				
			return res;
	
		}


		@Override
		public int selectdata(String colNm, String user_nickname, String date_date) throws Exception {
			// TODO Auto-generated method stub
			
	
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("user_nickname", user_nickname);
			query.put("date_date", date_date);
			
			log.info(date_date);
			
			int cursor = 0;
			
			cursor = rCol.find(query).count();
			
			
			System.out.println(cursor);
			
			return cursor;
		}


		@Override
		public int inserthealth1(HealthDTO hDTO, String colNm) throws Exception {
			// TODO Auto-generated method stub		
			int res = 0;
			
			if(hDTO!=null) {
				mongodb.insert(hDTO, colNm);
				res = 1;
			}
				
			return res;
		}


		@Override
		public int selecthealth1(String colNm) throws Exception {
			
			DBCollection rCol = mongodb.getCollection(colNm);
			int cursor = 0;
			cursor = rCol.find().count();
			
			return cursor;
		}

		@Override
		public int selecthealth2(String colNm) throws Exception {
			
			DBCollection rCol = mongodb.getCollection(colNm);
			int cursor = 0;
			cursor = rCol.find().count();
			
			return cursor;
		}


		@Override
		public int inserthealth2(ExplainDTO eDTO, String colNm) throws Exception {
			
			int res = 0;
			
			if(eDTO!=null) {
				mongodb.insert(eDTO, colNm);
				res = 1;
			}
				
			return res;
		}


		@Override
		public HealthDTO selecthealth3(String pose_name) throws Exception {
			
			HealthDTO hDTO = null;
			String colNm = "HEALTH_INFO";
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("pose_name", pose_name);
			
			Cursor cursor = rCol.find(query);
			
			while(cursor.hasNext()) {
				
				hDTO = new HealthDTO();
				
				final DBObject current = cursor.next();
				
				String health_no = CmmUtil.nvl((String) current.get("health_no"));
			
				hDTO.setHealth_no(health_no);
				
			}

			
			

			
			return hDTO;
		}

		
		
		
	}
	
