
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

import hh.softala.softalaharjoitus.domain.Kysely;
import hh.softala.softalaharjoitus.domain.KyselyRepository;
import hh.softala.softalaharjoitus.domain.Kysymys;
import hh.softala.softalaharjoitus.domain.KysymysRepository;
import hh.softala.softalaharjoitus.domain.KysymystyyppiRepository;
import hh.softala.softalaharjoitus.domain.Vaihtoehto;
import hh.softala.softalaharjoitus.domain.VaihtoehtoRepository;
import hh.softala.softalaharjoitus.domain.Vastaus;
import hh.softala.softalaharjoitus.domain.VastausRepository;

@CrossOrigin
@Controller
public class KysymysController {

	@Autowired
	private KysymysRepository krepository;
	
	@Autowired
	private VastausRepository vrepository;
	
	@Autowired
	private VaihtoehtoRepository vvrepository;
	
	@Autowired
	private KyselyRepository kyrepository;
	
	@Autowired
	private KysymystyyppiRepository ktrepository;
	
	// resthomepage - löytyy endpointit
	@RequestMapping(value="/resthomepage", method=RequestMethod.GET)
		public String getResthomepage(Model model) {
		return "index";
	}
	
	//REST lisää vastaus tietylle kysymykselle
	@RequestMapping(value="/lisaaVastaus/{kysymysId}", method=RequestMethod.POST)
		public @ResponseBody Vastaus addVastaus (@RequestBody Vastaus vastaus, @PathVariable("kysymysId") Long kysymysId) {
		Kysymys kysymys = new Kysymys();
		kysymys.setId(kysymysId);
		vastaus.setKysymys(kysymys);		
		return vrepository.save(vastaus);
	}
	
	//REST lisää vastaukset yhden kyselyn kaikille kysymyksille
	@RequestMapping(value="/lisaaVastaukset/{kyselyId}", method=RequestMethod.POST)
		public @ResponseBody Vastaus lisaaVastaukset (@RequestBody Vastaus vastaus, @PathVariable("kyselyId") Long kyselyId, Kysymys kysymys) {
		Kysely kysely = new Kysely();
		kysely.setKyselyId(kyselyId);
		krepository.findById(kyselyId);
		vastaus.setKysymys(kysymys);		
		return vrepository.save(vastaus);
}
	
	//REST lisää vastausvaihtoehto tietylle kysymykselle
		@RequestMapping(value="/lisaaVastausvaihtoehto/{kysymysId}", method=RequestMethod.POST)
			public @ResponseBody Vaihtoehto addVastausvaihtoehto (@RequestBody Vaihtoehto vastausvaihtoehto, @PathVariable("kysymysId") Long kysymysId) {
			Kysymys kysymys = new Kysymys();
			kysymys.setId(kysymysId);
			vastausvaihtoehto.setKysymys(kysymys);		
			return vvrepository.save(vastausvaihtoehto);
			
		}
	
	//REST katso tietyn kysymyksen kaikki vastaukset
		@RequestMapping(value="/kysymyksenVastaukset/{kysymysId}", method=RequestMethod.GET)
		public @ResponseBody List<Vastaus> vastaukset(@PathVariable("kysymysId") Long id) {
			Kysymys kysymys = krepository.findById(id).orElse(null);
			return (List<Vastaus>) vrepository.findByKysymys(kysymys);
		}

	
	//REST etsi kaikki yhden monivalintakysymyksen vastausvaihtoehdot
		@RequestMapping(value="/kysymysVaihtoehdot/{kysymysId}", method=RequestMethod.GET)
		public @ResponseBody List<Vaihtoehto> vaihtoehtolista(@PathVariable("kysymysId") Long id){
			Kysymys kysymys = krepository.findById(id).orElse(null);
			return (List<Vaihtoehto>) vvrepository.findByKysymys(kysymys);
		}
		
	//REST etsi kaikki tietyn kyselyn kysymykset
	@RequestMapping(value="/kysely/{kyselyId}/kysymykset", method=RequestMethod.GET)
		public @ResponseBody List<Kysymys> kysymyslistaRest(){
			return (List<Kysymys>) krepository.findAll();
		}
		
	//REST etsi kysymys id:llä
	 @RequestMapping(value="/kysymys/{kysymysId}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysId") Long id){
	   	return krepository.findById(id);
	    }
		 
	//REST lisää kysymys
	@RequestMapping(value="/kysymys", method=RequestMethod.POST)
		public @ResponseBody Kysymys addKysymys (@RequestBody Kysymys kysymys) {
		return krepository.save(kysymys);
	}
		
	//REST muokkaa kysymystä
	@RequestMapping (value="/kysymys/muokkaa/{kysymysId}")
		public String editKysymys (@PathVariable("kysymysId") Long id, Model model) {
		model.addAttribute("kysymys", krepository.findById(id));
		return "muokkaa";
	}
	
	//REST etsi kaikki kyselyt
	@RequestMapping(value="/kyselyt", method=RequestMethod.GET)
		public @ResponseBody List<Kysely> kyselylistaRest(){
		return (List<Kysely>) kyrepository.findAll();
	}
	
	//REST etsi kysely id:llä
	 @RequestMapping(value="/kysely/{kyselyId}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("kyselyId") Long id){
	    	return kyrepository.findById(id);
	 }
	 
	//REST lisää kysely
	@RequestMapping(value="/kysely", method=RequestMethod.POST)
		public @ResponseBody Kysely addKysely (@RequestBody Kysely kysely) {
			return kyrepository.save(kysely);
	}
	
	// Lisää kysely HTML:na
	@RequestMapping(value="/luokysely", method=RequestMethod.GET)
	public String addKysely(Model model) {
		model.addAttribute("kysely", new Kysely());
		return "Luokysely";
	}
	
	//Tallenna HTML-lomakkeen tiedot
	@RequestMapping(value="/savekysely", method=RequestMethod.POST)
	public String save(Kysely kysely) {
		kyrepository.save(kysely);
		return "redirect:Luokysely";
	}
	
	//Lisää kysymys HTML:na
	@RequestMapping(value="/luokysymys", method=RequestMethod.GET)
	public String addKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kysymystyypit", ktrepository.findAll());
		return "luokysymys";
	}
	
	//Tallenna HTML-lomakkeen tiedot
		@RequestMapping(value="/savekysymys", method=RequestMethod.POST)
		public String save(Kysymys kysymys) {
			krepository.save(kysymys);
			return "redirect:Luokysymys";
		}
	
	 //REST muokkaa kyselyä
	@RequestMapping (value="/kysely/muokkaa/{kyselyId}")
	  public String editKysely (@PathVariable("kyselyId") Long id, Model model) {
		model.addAttribute("kysely", kyrepository.findById(id));
		return "muokkaa";
	}
	
	//REST etsi kaikki vastaukset
	@RequestMapping(value="/vastaukset", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> vastauslistaRest(){
		return (List<Vastaus>) vrepository.findAll();
	}
	
	//REST etsi vastaus id:llä
	 @RequestMapping(value="/vastaukset/{vastausId}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("vastausId") Long id){
	    	return vrepository.findById(id);
	    }
	 


}
