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
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vaihtoehto> vaihtoehdot;

	@ManyToOne
	@JoinColumn(name = "kyselyId")
	@JsonIgnore
	private Kysely kysely;
	
	@ManyToOne
	@JoinColumn(name = "kysymystyyppiId")
	@JsonIgnore
	private Kysymystyyppi kysymystyyppi;

	
	public Kysymys() {
		
	}
	
	public Kysymys(String kysymys, Kysely kysely, Kysymystyyppi kysymystyyppi) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
		this.kysymystyyppi = kysymystyyppi;
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

	public Kysymystyyppi getKysymystyyppi() {
		return kysymystyyppi;
	}

	public void setKysymystyyppi(Kysymystyyppi kysymystyyppi) {
		this.kysymystyyppi = kysymystyyppi;
	}

	@Override
	public String toString() {
		if (this.kysely != null && this.kysymystyyppi != null)
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "kysely =" + this.getKysely() + "kysymystyyppi=" + this.getKysymystyyppi() + "]";
		else
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "kysymystyyppi=" + this.getKysymystyyppi() + "]";

	}
	

}
