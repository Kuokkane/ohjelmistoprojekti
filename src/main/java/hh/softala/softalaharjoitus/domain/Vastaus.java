package hh.softala.softalaharjoitus.domain;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausId;
	private String vastausvaihtoehto;
	

	
	
	
	public Vastaus() {}


	public Vastaus(String vastausvaihtoehto) {
		super();
		this.vastausvaihtoehto = vastausvaihtoehto;
	}


	public Long getVastausId() {
		return vastausId;
	}


	public void setVastausId(Long vastausId) {
		this.vastausId = vastausId;
	}


	public String getVastausvaihtoehto() {
		return vastausvaihtoehto;
	}


	public void setVastausvaihtoehto(String vastausvaihtoehto) {
		this.vastausvaihtoehto = vastausvaihtoehto;
	}




	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", vastausvaihtoehto=" + vastausvaihtoehto + "]";
	}
	
	
	
	
}
