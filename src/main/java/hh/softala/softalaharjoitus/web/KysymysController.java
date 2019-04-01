package hh.softala.softalaharjoitus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.softala.softalaharjoitus.domain.Kysymys;
import hh.softala.softalaharjoitus.domain.KysymysRepository;

@CrossOrigin
@Controller
public class KysymysController {
	
	@Autowired 
	private KysymysRepository krepository;
	
	@RequestMapping(value="/kysymykset", method=RequestMethod.GET)
	public @ResponseBody List<Kysymys> kysymyslistaRest(){
		return (List<Kysymys>) krepository.findAll();
	
	}

	

}
