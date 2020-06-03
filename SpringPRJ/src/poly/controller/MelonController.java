package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IMelonService;

@Controller
public class MelonController {
	
	@Resource(name = "MelonService")
	private IMelonService melonService;
	
	@RequestMapping(value = "melon/collectMelonRank")
	@ResponseBody
	public String collectMelonRank(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
		melonService.collectMelonRank();
		
		
		
		return "success";
		
	}

}
