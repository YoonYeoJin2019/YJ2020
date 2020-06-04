package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoseController {

	
	@RequestMapping(value="pose")
	public String Pose(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		return "/pose/pose";
	}
	
	@RequestMapping(value="index_ready_1")
	public String Index_ready_1(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
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
