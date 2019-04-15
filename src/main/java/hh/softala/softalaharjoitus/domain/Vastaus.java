package hh.softala.softalaharjoitus.domain;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausId;
	
	private String vastaus;
	
	@ManyToOne
	@JoinColumn(name = "kysymysId")
	@JsonIgnore
	private Kysymys kysymys;
	
	public Vastaus() {}

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.kysymys = kysymys;
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
	
	public Kysymys getKysymys() {
		return kysymys;
	}
	
	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	@Override
	public String toString() {
		if (this.kysymys != null)
			return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + "kysymys =" + this.getKysymys() + "]";
		else
			return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + "]";
	}
	
	
	
	
}
