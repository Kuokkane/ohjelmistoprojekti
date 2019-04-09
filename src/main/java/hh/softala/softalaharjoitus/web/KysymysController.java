package hh.softala.softalaharjoitus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.softala.softalaharjoitus.domain.Kysymys;
import hh.softala.softalaharjoitus.domain.KysymysRepository;
import hh.softala.softalaharjoitus.domain.Vastaus;
import hh.softala.softalaharjoitus.domain.VastausRepository;

@CrossOrigin
@Controller
public class KysymysController {

	@Autowired
	private KysymysRepository krepository;
	
	@Autowired
	private VastausRepository vrepository;

	//REST etsi kaikki kysymykset
	@RequestMapping(value="/kysymykset", method=RequestMethod.GET)
	public @ResponseBody List<Kysymys> kysymyslistaRest(){
		return (List<Kysymys>) krepository.findAll();
	
	}

	
	//REST etsi kysymys id:llä
	 @RequestMapping(value="/kysymykset/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysId") Long id){
	    	return krepository.findById(id);
	    }
	 
	 
	//REST lisää kysymys
	@RequestMapping(value="/kysymys", method=RequestMethod.POST)
		public @ResponseBody Kysymys addKysymys (@RequestBody Kysymys kysymys) {
		return krepository.save(kysymys);
	}
	
	 //REST muokkaa kysymystä
	  @RequestMapping (value="/muokkaa/{id}")
	  public String editKysymys (@PathVariable("kysymysId") Long id, Model model) {
		  model.addAttribute("kysymys", krepository.findById(id));
		  return "muokkaa";
	  }
	  
		//REST lisää vastaus
		@RequestMapping(value="/vastaus", method=RequestMethod.POST)
			public @ResponseBody Vastaus addVastaus (@RequestBody Vastaus vastaus) {
			return vrepository.save(vastaus);
		}

}
