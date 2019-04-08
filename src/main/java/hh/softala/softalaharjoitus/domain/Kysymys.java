package hh.softala.softalaharjoitus.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Kysymys {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String kysymys;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vastausvaihtehto")
	private List<Vastaus> vastaukset;
	
	public Kysymys() {
		
	}
	

	
	public Kysymys(String kysymys) {

		super();
		this.kysymys = kysymys;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	@Override
	public String toString() {
		return "Kysymys [kysymys=" + kysymys + "]";
	}
	

}
