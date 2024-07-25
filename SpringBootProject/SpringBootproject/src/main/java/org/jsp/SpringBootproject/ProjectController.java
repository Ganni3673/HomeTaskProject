package org.jsp.SpringBootproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProjectController {
	@RequestMapping("/text")
	public String firstHandaller()
	{
		return "ganesh jadhav";
	}

}
