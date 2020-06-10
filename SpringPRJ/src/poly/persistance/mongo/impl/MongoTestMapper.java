package poly.persistance.mongo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;

import poly.dto.LoginDTO;
import poly.persistance.mongo.IMongoTestMapper;


	
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
			BasicDBObject query2 = new BasicDBObject();
			query2.put("date_date", date_date);
			
			int cursor = 0;
			
			cursor = rCol.find(query,query2).count();
			
			
			System.out.println(cursor);
			
			return cursor;
		}



		
		
		
	}
	
