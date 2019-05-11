package hh.softala.softalaharjoitus.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysId;
	
	private String kysymys;
	private String kysymystyyppi;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vaihtoehto> vaihtoehdot;

	@ManyToOne
	@JoinColumn(name = "kyselyId")
	@JsonIgnore
	private Kysely kysely;
	
	/*
	@ManyToOne
	@JoinColumn(name = "kysymystyyppiId")
	@JsonIgnore
	private Kysymystyyppi kysymystyyppi;
	*/
	
	public Kysymys() {
		
	}
	
	public Kysymys(String kysymys, String kysymystyyppi, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		this.kysymystyyppi = kysymystyyppi;
		this.kysely = kysely;
	}

	public Long getKysymysId() {
		return kysymysId;
	}
	
	public void setId(Long kysymysId) {
		this.kysymysId = kysymysId;
	}
	
	public String getKysymys() {
		return kysymys;
	}
	
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public String getKysymystyyppi() {
		return kysymystyyppi;
	}

	public void setKysymystyyppi(String kysymystyyppi) {
		this.kysymystyyppi = kysymystyyppi;
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}


	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + ", kysymystyyppi=" + kysymystyyppi + ", kysely =" + this.getKysely() + "]";
		else
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + ", kysymystyyppi=" + kysymystyyppi + "]";

	}
	

}
