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
		
		String res2 = "";
		
		try {
			
			res = mongoservice.selecthealth1();
			
			res2 = Integer.toString(res+1);
			
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
	
	
	@RequestMapping(value="index_ready_2")
	public String Index_ready_2(HttpServletRequest request, HttpServletResponse response) {

		
		return "/pose/index_ready_2";
	}
	
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
		String j="";
		int result = 0;
		
		try {
			
			i = mongoservice.selecthealth2();
			j = Integer.toString(i+1);
	
			
			
			
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
	
	
	
	@RequestMapping(value="index_ready")
	public String Index_ready(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		return "/pose/index_ready";
	}
	
	@RequestMapping(value="index")
	public String Index(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		return "/pose/index";
	}
	
	
	
	
}
