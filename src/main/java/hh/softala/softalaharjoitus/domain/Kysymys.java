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
	private Long id;
	
	private String kysymys;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vastausvaihtehto")
	private List<Vastaus> vastaukset;

	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Kysely kysely;

	
	public Kysymys() {
		
	}
	
	public Kysymys(String kysymys, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
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
	
	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {

		if (this.kysely != null)
			return "Kysymys [id=" + id + ", kysymys=" + kysymys + "kysely =" + this.getKysely() + "]";
		else
			return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";

	}
	

}
