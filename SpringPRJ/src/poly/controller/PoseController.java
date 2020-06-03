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
	
	
}
