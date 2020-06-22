package poly.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import poly.dto.ExplainDTO;
import poly.dto.HealthDTO;
import poly.service.IMongoTestService;
import poly.util.CmmUtil;

@Controller
public class PoseController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	
	@Resource(name="MongoTestService")
	private IMongoTestService mongoservice;
	
	
	@RequestMapping(value="pose")
	public String Pose(HttpServletRequest request, HttpServletResponse response) {
			
		return "/pose/pose";
	}
	
	// 운동 등록1 페이지
	@RequestMapping(value="index_ready_1")
	public String Index_ready_1(HttpServletRequest request, HttpServletResponse response) {
		
		return "/pose/index_ready_1";
	}
	

	// 운동 등록1 실행
	@RequestMapping(value="index_ready_1_sh")
	public String Index_ready_1_sh(HttpServletRequest request, HttpServletResponse response,Model model) {
			
		String img_name = CmmUtil.nvl(request.getParameter("img_name"));
		String pose_name = CmmUtil.nvl(request.getParameter("pose_name"));
		String file_name = CmmUtil.nvl(request.getParameter("file_name"));
		String file_name2 = CmmUtil.nvl(request.getParameter("file_name2"));
		String num = "";
		String health_no="";
		if(img_name.equals("")||pose_name.equals("")||file_name.equals("")||file_name2.equals("")) {
			
			model.addAttribute("msg", "등록을 다시 한번 확인해주세요");
			model.addAttribute("url", "/index.do");
			return "redirect";
		}
		
		log.info(img_name+"이미지정보");
		log.info(pose_name+"운동이름정보");
		log.info(file_name+"파일정보");
		log.info(file_name2+"파일정보2");
		
		
		HealthDTO hDTO = new HealthDTO();
		
		int result = 0;
		
		int res = 0;
		
		String res2 = "1";
		
		try {
			
			hDTO = mongoservice.selecthealth1();
				
			if(hDTO.getHealth_no()!=null) {
			res = Integer.parseInt(hDTO.getHealth_no());
			res2 = Integer.toString(res+1);
			}
			
			log.info(res2+"res2입니다?");		
			hDTO.setHealth_img(img_name);
			hDTO.setHealth_name(pose_name);
			hDTO.setHealth_file(file_name);
			hDTO.setHealth_file2(file_name2);
			hDTO.setHealth_no(res2);

			result = mongoservice.inserthealth1(hDTO);
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+res2+"/";
		
		log.info("파일이 들어갈 경로: " + path);

		Map returnObject = new HashMap();

		
		try {
			
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();
			
			// 디렉토리가 없다면 생성
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = mhsr.getFile(fieldName);
			String origName;
			origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

			if ("".equals(origName)) {
				log.info("파일없음");
				continue;

			}
				
			log.info("세미 :" + path);
			log.info("오리지널네임 :" + origName);
			
			String ext = origName.substring(origName.lastIndexOf('.'));
					
			File serverFile = new File(path + origName);
			mfile.transferTo(serverFile);
			// log.info("어떤게 :"+ File.pathSeparator);
			log.info("세미 :" + path);
		
			Map file = new HashMap();
			file.put("orgName", origName);
			file.put("sfile", serverFile);
			resultList.add(file);
		
		}
		returnObject.put("files", resultList);
		returnObject.put("params", mhsr.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result>0) {
			log.info("ready_2로 값 넘기기");
			log.info("res2 : "+res2);
			model.addAttribute("health_no",res2);
			log.info("pose_name : "+pose_name);
			model.addAttribute("pose_name", pose_name);
			
			
			return "/pose/index_ready_2";
		}else {
			model.addAttribute("msg", "등록실패~");
			model.addAttribute("url", "/index.do");
			return "redirect";
		}	
		
	}
	
	// 운동 등록 2 페이지
	@RequestMapping(value="index_ready_2")
	public String Index_ready_2(HttpServletRequest request, HttpServletResponse response) {

		
		return "/pose/index_ready_2";
	}
	
	// 운동 등록2 실행
	@RequestMapping(value="index_ready_2_sh")
	public String Index_ready_2_sh(HttpServletRequest request, HttpServletResponse response,Model model) {

		String img_name = CmmUtil.nvl(request.getParameter("img_name"));
		String explain_content = CmmUtil.nvl(request.getParameter("EXPLAIN_CONTENT"));
		String pose_name = CmmUtil.nvl(request.getParameter("pose_name"));
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));
		
		
		
	if(img_name.equals("")||pose_name.equals("")||explain_content.equals("")) {
			
			model.addAttribute("msg", "등록을 다시 한번 확인해주세요");
			model.addAttribute("url", "/index.do");
			return "redirect";
		}	
		
		
		ExplainDTO eDTO = new ExplainDTO();
		
		
		int i=0;
		String j="1";
		int result = 0;
		
		try {
			
			eDTO = mongoservice.selecthealth2();
			
			if(eDTO.getExplain_no()!=null) {
				i = Integer.parseInt(eDTO.getExplain_no());
				
				j = Integer.toString(i+1);
			}
			
			eDTO.setHealth_no(health_no);
			eDTO.setExplain_img(img_name);
			eDTO.setExplain_content(explain_content);
			eDTO.setExplain_no(j);

			result = mongoservice.inserthealth2(eDTO);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();

		}
		
		
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+health_no+"/to/";
		
		log.info("파일이 들어갈 경로: " + path);

		Map returnObject = new HashMap();

		
		try {
			
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();
			
			// 디렉토리가 없다면 생성
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = mhsr.getFile(fieldName);
			String origName;
			origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

			if ("".equals(origName)) {
				log.info("파일없음");
				continue;

			}
				
			log.info("세미 :" + path);
			log.info("오리지널네임 :" + origName);
			
			String ext = origName.substring(origName.lastIndexOf('.'));
					
			File serverFile = new File(path + origName);
			mfile.transferTo(serverFile);
			// log.info("어떤게 :"+ File.pathSeparator);
			log.info("세미 :" + path);
		
			Map file = new HashMap();
			file.put("orgName", origName);
			file.put("sfile", serverFile);
			resultList.add(file);
		
		}
		returnObject.put("files", resultList);
		returnObject.put("params", mhsr.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result>0) {
			
			model.addAttribute("msg","등록 되었습니다.");
			model.addAttribute("url","/index.do");
			return "redirect";
	
		}else {
			model.addAttribute("msg","등록에 실패하였습니다." );
			model.addAttribute("url","/index.do");
			return "redirect";
		}	
		
		
		
	}
	
	
	//운동 준비 페이지
	@RequestMapping(value="index_ready")
	public String Index_ready(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("Health_no"));
		String health_name = CmmUtil.nvl(request.getParameter("Health_name"));
		
		ExplainDTO eDTO = new ExplainDTO();
		
		try {
			
			eDTO = mongoservice.getready(health_no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("eDTO",eDTO);
		model.addAttribute("health_name", health_name);
		
		
		return "/pose/index_ready";
	}
	
	
	//메인 페이지
	@RequestMapping(value="index")
	public String Index(HttpServletRequest request, HttpServletResponse responsem,Model model) {
		
		List<HealthDTO> hList = new ArrayList<HealthDTO>();
		
		try {
		
			hList = mongoservice.getindexlist();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(hList==null) {
			hList = new ArrayList<HealthDTO>();
		}
			
		model.addAttribute("hList",hList);
		
		hList = null;
		
		return "/pose/index";
	}
	
	
	// 운동 삭제
	@RequestMapping(value="index_ready_del")
	public String Index_ready_del(HttpServletRequest request, HttpServletResponse responsem,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));
		
		int result = 0;
			
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+health_no;
		
		deleteFolder(path);
		
		try {
				
			result = mongoservice.ready_del(health_no);
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("msg","해당 운동이 삭제 되었습니다.");
		model.addAttribute("url","/index.do");
		
		return "redirect";
	}


	// 운동 수정1 페이지
	@RequestMapping(value="index_ready_1_up")
	public String Index_ready_1_up(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));
		
		HealthDTO hDTO = new HealthDTO();
		
		
		try {
			
			hDTO = mongoservice.getready_1_up(health_no);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("hDTO", hDTO);
		
		return "/pose/index_ready_1_up";
	}
	
	// 운동 수정2 페이지
	@RequestMapping(value="index_ready_2_up")
	public String Index_ready_2_up(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));
		String health_name = CmmUtil.nvl(request.getParameter("pose_name"));

		
		ExplainDTO eDTO = new ExplainDTO();
		
		try {
			
			eDTO = mongoservice.getready(health_no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("eDTO",eDTO);
		model.addAttribute("health_name",health_name);
		
		return "/pose/index_ready_2_up";
	}
	
	// 운동 수정1 페이지 실행
	@RequestMapping(value="index_ready_1_up_sh")
	public String Index_ready_1_up_sh(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));

		HealthDTO hDTO = new HealthDTO();
		
		try {
				
			hDTO = mongoservice.getready_1_up(health_no);
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
		String org_img_name = hDTO.getHealth_img();
		String org_file_name = hDTO.getHealth_file();
		String org_file_name2 = hDTO.getHealth_file2();
		
		log.info(org_img_name+"앤가??");
		log.info(org_file_name+"앤가??");
		log.info(org_file_name2+"앤가??");
		
		hDTO = null;
		
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+health_no+"/";
	
		hDTO = new HealthDTO();
		
		String pose_name = CmmUtil.nvl(request.getParameter("pose_name"));
		
		hDTO.setHealth_name(pose_name);
		hDTO.setHealth_no(health_no);
		
		
		String img_name = CmmUtil.nvl(request.getParameter("img_name"));
		if(img_name.equals("")) {	
			hDTO.setHealth_img(org_img_name);
		}else {	
			delfile(path+org_img_name);
			hDTO.setHealth_img(img_name);
		}
		
		String file_name = CmmUtil.nvl(request.getParameter("file_name"));
		if(file_name.equals("")) {
			hDTO.setHealth_file(org_file_name);
		}else {
			delfile(path+org_file_name);
			hDTO.setHealth_file(file_name);
		}
	
		String file_name2 = CmmUtil.nvl(request.getParameter("file_name2"));
		
		if(file_name2.equals("")) {
			hDTO.setHealth_file2(org_file_name2);
		}else {
			delfile(path+org_file_name2);
			hDTO.setHealth_file2(file_name2);
			
		}
		
		int res = 0;
		
		try {
			
			res = mongoservice.update_ready_1_up_sh(hDTO);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		log.info("파일이 들어갈 경로: " + path);

		Map returnObject = new HashMap();

	
		try {
			
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();
			
			// 디렉토리가 없다면 생성
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = mhsr.getFile(fieldName);
			String origName;
			origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

			if ("".equals(origName)) {
				log.info("파일없음");
				continue;

			}
				
			log.info("세미 :" + path);
			log.info("오리지널네임 :" + origName);
			
			String ext = origName.substring(origName.lastIndexOf('.'));
					
			File serverFile = new File(path + origName);
			mfile.transferTo(serverFile);
			// log.info("어떤게 :"+ File.pathSeparator);
			log.info("세미 :" + path);
		
			Map file = new HashMap();
			file.put("orgName", origName);
			file.put("sfile", serverFile);
			resultList.add(file);
		
		}
		returnObject.put("files", resultList);
		returnObject.put("params", mhsr.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if(res>0) {
			model.addAttribute("msg", "수정 1페이지가 완료되었습니다");
			model.addAttribute("url", "/index_ready_2_up.do?health_no="+health_no+"&pose_name="+pose_name);
		}else {
			model.addAttribute("msg", "수정 1페이지가 실패하였습니다");
			model.addAttribute("url", "/index_ready_1_up.do?health_no="+health_no);
		}
	
		hDTO = null;
		
		return "redirect";
	}
	// 운동 수정2 페이지 실행
	@RequestMapping(value="index_ready_2_up_sh")
	public String Index_ready_2_up_sh(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String health_no = CmmUtil.nvl(request.getParameter("health_no"));
		String health_name = CmmUtil.nvl(request.getParameter("pose_name"));
		String img_name = CmmUtil.nvl(request.getParameter("img_name"));
		String explain_content = CmmUtil.nvl(request.getParameter("EXPLAIN_CONTENT"));
			
		
		log.info(health_name+"얘 걔가 아니냐??");
		
		ExplainDTO eDTO = new ExplainDTO();
		
		try {
			
			eDTO = mongoservice.getready(health_no);
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String img_nameorg = eDTO.getExplain_img();
		String explain_no = eDTO.getExplain_no();
		
		eDTO = null;
		
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+health_no+"/to/";
		
		eDTO = new ExplainDTO();
		
		if(img_name.equals("")) {
			eDTO.setExplain_img(img_nameorg);
		}else {
			delfile(path+img_nameorg);
			eDTO.setExplain_img(img_name);
		}
		
		eDTO.setExplain_content(explain_content);
		eDTO.setExplain_no(explain_no);
		eDTO.setHealth_no(health_no);
		
		
		int res = 0;
		
		try {
			
			res = mongoservice.ready_2_up_sh(eDTO);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Map returnObject = new HashMap();

		
		try {
			
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();
			
			// 디렉토리가 없다면 생성
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = mhsr.getFile(fieldName);
			String origName;
			origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

			if ("".equals(origName)) {
				log.info("파일없음");
				continue;

			}
				
			log.info("세미 :" + path);
			log.info("오리지널네임 :" + origName);
			
			String ext = origName.substring(origName.lastIndexOf('.'));
					
			File serverFile = new File(path + origName);
			mfile.transferTo(serverFile);
			// log.info("어떤게 :"+ File.pathSeparator);
			log.info("세미 :" + path);
		
			Map file = new HashMap();
			file.put("orgName", origName);
			file.put("sfile", serverFile);
			resultList.add(file);
		
		}
		returnObject.put("files", resultList);
		returnObject.put("params", mhsr.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		eDTO = null;
		
		if(res>0) {
			
			model.addAttribute("msg","변경 완료 되었습니다.");
			model.addAttribute("url","/index_ready.do?Health_no="+health_no+"&Health_name="+health_name);
			
		}else {
			
			model.addAttribute("msg","변경이 실패하였습니다.");
			model.addAttribute("url","/index_ready.do?Health_no="+health_no+"&Health_name="+health_name);
		}
		
		
		return "redirect";
	}
	
	
public static void deleteFolder(String path) {
		
	    File folder = new File(path);
	    try {
		if(folder.exists()){
                File[] folder_list = folder.listFiles(); //파일리스트 얻어오기
				
		for (int i = 0; i < folder_list.length; i++) {
		    if(folder_list[i].isFile()) {
			folder_list[i].delete();
		    }else {
			deleteFolder(folder_list[i].getPath()); //재귀함수호출
		    }
		    folder_list[i].delete();
		 }
		 folder.delete(); //폴더 삭제
	       }
	   } catch (Exception e) {
		e.getStackTrace();
	   }
    }
	
public static void delfile(String path) {
System.out.println(path + "이거 삭제한다고 ...");
	File file = new File(path); 
	try {
	
		if(file.exists()) {
			file.delete();
			System.out.println("파일 삭제 !");
		}else {
			System.out.println("파일 없음");
		}
	}catch(Exception e){
		e.printStackTrace();
	}	
}
	
}
