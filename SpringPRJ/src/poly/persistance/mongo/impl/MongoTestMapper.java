package poly.persistance.mongo.impl;

import java.util.ArrayList;
import java.util.List;

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
		public HealthDTO selecthealth1(String colNm) throws Exception {
			
			HealthDTO hDTO = new HealthDTO();
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("health_no", +1);
			
			Cursor cursor = rCol.find().sort(query).limit(1);
			
			while(cursor.hasNext()) {
				
				hDTO = new HealthDTO();
				
				final DBObject current = cursor.next();
									
				 String health_no = CmmUtil.nvl((String) current.get("health_no"));
				 String health_name = CmmUtil.nvl((String) current.get("health_name"));
				 String health_file = CmmUtil.nvl((String) current.get("health_file"));
				 String health_file2 = CmmUtil.nvl((String) current.get("health_file2"));
				 String health_img = CmmUtil.nvl((String) current.get("health_img"));
					 
				 hDTO.setHealth_no(health_no);
				 hDTO.setHealth_file(health_file);
				 hDTO.setHealth_name(health_name);
				 hDTO.setHealth_file2(health_file2);
				 hDTO.setHealth_img(health_img);
				 
			}
			
			return hDTO;
		}


		@Override
		public ExplainDTO selecthealth2() throws Exception {
			
			ExplainDTO eDTO = new ExplainDTO();
			
			String colNm = "EXPLAIN_INFO";
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("explain_no", +1);
			
			Cursor cursor = rCol.find().sort(query).limit(1);
			
			while(cursor.hasNext()) {
				
				eDTO = new ExplainDTO();
				
				final DBObject current = cursor.next();
									
				 String explain_no = CmmUtil.nvl((String) current.get("explain_no"));
				 String explain_content = CmmUtil.nvl((String) current.get("explain_content"));
				 String explain_img = CmmUtil.nvl((String) current.get("explain_img"));			
				 String health_no = CmmUtil.nvl((String) current.get("health_no"));
				 
				eDTO.setExplain_content(explain_content);
				eDTO.setExplain_img(explain_img);
				eDTO.setExplain_no(explain_no);
				eDTO.setHealth_no(health_no);
				
			}		
			
			return eDTO;
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


		@Override
		public List<HealthDTO> getindexlist() throws Exception {
			
			List<HealthDTO> eList = new ArrayList<HealthDTO>();
			String colNm = "HEALTH_INFO";
			DBCollection rCol = mongodb.getCollection(colNm);
			Cursor cursor = rCol.find();
			
			HealthDTO hDTO = null;
			
			while (cursor.hasNext()) {
		
				hDTO = new HealthDTO();
				
				final DBObject current = cursor.next();
				
				 String health_no = CmmUtil.nvl((String) current.get("health_no"));
				 String health_name = CmmUtil.nvl((String) current.get("health_name"));
				 String health_file = CmmUtil.nvl((String) current.get("health_file"));
				 String health_file2 = CmmUtil.nvl((String) current.get("health_file2"));
				 String health_img = CmmUtil.nvl((String) current.get("health_img"));
					 
				 hDTO.setHealth_no(health_no);
				 hDTO.setHealth_file(health_file);
				 hDTO.setHealth_name(health_name);
				 hDTO.setHealth_file2(health_file2);
				 hDTO.setHealth_img(health_img);
				 			 
				 eList.add(hDTO);
				 
				 hDTO = null;		 
			}		
			
			return eList;
		}


		@Override
		public ExplainDTO getready(String health_no) throws Exception {
			// TODO Auto-generated method stub
			ExplainDTO eDTO = null;
			String colNm = "EXPLAIN_INFO";
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("health_no", health_no);
			
			Cursor cursor = rCol.find(query);
			
			
			
			
			while(cursor.hasNext()) {
				
				eDTO = new ExplainDTO();
				
				final DBObject current = cursor.next();
				

							
				 String explain_no = CmmUtil.nvl((String) current.get("explain_no"));
				 String explain_content = CmmUtil.nvl((String) current.get("explain_content"));
				 String explain_img = CmmUtil.nvl((String) current.get("explain_img"));			
				 
				eDTO.setExplain_content(explain_content);
				eDTO.setExplain_img(explain_img);
				eDTO.setExplain_no(explain_no);
				eDTO.setHealth_no(health_no);
				
			}

			return eDTO;
		}


		@Override
		public int ready_del(String health_no) throws Exception {
		
			String colNm = "EXPLAIN_INFO";
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("health_no", health_no);	
			rCol.remove(query);
			
			 colNm = "HEALTH_INFO";
			 rCol = mongodb.getCollection(colNm);
			 rCol.remove(query);
			 

			return 1;
		}


		@Override
		public HealthDTO getready_1_up(String health_no) throws Exception {
			HealthDTO hDTO = null;
			String colNm = "HEALTH_INFO";
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject query = new BasicDBObject();
			query.put("health_no", health_no);
			
			Cursor cursor = rCol.find(query);
			
			while(cursor.hasNext()) {
				
				hDTO = new HealthDTO();
				
				final DBObject current = cursor.next();					
				 
				 String health_name = CmmUtil.nvl((String) current.get("health_name"));
				 String health_file = CmmUtil.nvl((String) current.get("health_file"));
				 String health_file2 = CmmUtil.nvl((String) current.get("health_file2"));
				 String health_img = CmmUtil.nvl((String) current.get("health_img"));			 
		
				 
				 hDTO.setHealth_no(health_no);
				 hDTO.setHealth_file(health_file);
				 hDTO.setHealth_name(health_name);
				 hDTO.setHealth_file2(health_file2);
				 hDTO.setHealth_img(health_img);
				
			}
			
			
			return hDTO;
		}


		@Override
		public int update_ready_1_up_sh(HealthDTO hDTO) throws Exception {
	
			int res = 0;
			
			String colNm = "HEALTH_INFO";
			
			DBCollection rCol = mongodb.getCollection(colNm);
			
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.put("health_no",hDTO.getHealth_no());
			updateQuery.put("health_name",hDTO.getHealth_name());
			updateQuery.put("health_file",hDTO.getHealth_file());
			updateQuery.put("health_file2",hDTO.getHealth_file2());
			updateQuery.put("health_img",hDTO.getHealth_img());
			
			BasicDBObject searchQuery = new BasicDBObject().append("health_no",hDTO.getHealth_no());
			
			rCol.update(searchQuery, updateQuery);
			
			res = 1;
			
			return res;
		}
		
		@Override
		public int ready_2_up_sh(ExplainDTO eDTO) throws Exception {
		
			int res = 0;
			
			String colNm = "EXPLAIN_INFO";
			
			DBCollection rCol = mongodb.getCollection(colNm);
			BasicDBObject updateQuery = new BasicDBObject();
			
			updateQuery.put("explain_no",eDTO.getExplain_no());
			updateQuery.put("explain_content",eDTO.getExplain_content());
			updateQuery.put("explain_img",eDTO.getExplain_img());
			updateQuery.put("health_no",eDTO.getHealth_no());
			
			BasicDBObject searchQuery = new BasicDBObject().append("health_no",eDTO.getHealth_no());
			
			rCol.update(searchQuery, updateQuery);
			
			res = 1;
			
			return res;
		}




		
		
		
		
		
	}
	
