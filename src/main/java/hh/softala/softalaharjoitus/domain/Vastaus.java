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
	
	private String vastaus;
	
	public Vastaus() {}

	public Vastaus(String vastaus) {
		super();
		this.vastaus = vastaus;
	}

	public Long getVastausId() {
		return vastausId;
	}

	public void setVastausId(Long vastausId) {
		this.vastausId = vastausId;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}


	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + "]";
	}
	
	
	
	
}
