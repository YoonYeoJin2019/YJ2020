package poly.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import poly.util.CmmUtil;

@Controller
public class PoseController {
	private Logger log = Logger.getLogger(this.getClass());
	
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
	public String Index_ready_1_sh(HttpServletRequest request, HttpServletResponse response) {
			
		String img_name = CmmUtil.nvl(request.getParameter("img_name"));
		String pose_name = CmmUtil.nvl(request.getParameter("pose_name"));
		String file_name = CmmUtil.nvl(request.getParameter("file_name"));
		String file_name2 = CmmUtil.nvl(request.getParameter("file_name2"));
		
		log.info(img_name+"이미지정보");
		log.info(pose_name+"운동이름정보");
		log.info(file_name+"파일정보");
		log.info(file_name2+"파일정보2");
		
		
		String path = "C:/git2/YJ2020/SpringPRJ/WebContent/pose/"+pose_name;
		
		
		
		log.info("파일이 들어갈 경로: " + path);

		Map returnObject = new HashMap();

		int result = 0;
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
		
		
		
		
		
		return "/pose/index_ready_1";
	}
	
	
	@RequestMapping(value="index_ready_2")
	public String Index_ready_2(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		return "/pose/index_ready_2";
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
