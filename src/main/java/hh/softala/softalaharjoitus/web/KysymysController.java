package hh.softala.softalaharjoitus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KysymysController {
	
	
	@RequestMapping(value="/kysymykset", method=RequestMethod.GET)
	public @ResponseBody String kysymyslistaRest(){
		return "moi";
	
	}

	

}
