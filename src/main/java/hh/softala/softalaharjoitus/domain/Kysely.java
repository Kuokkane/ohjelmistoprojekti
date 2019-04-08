package hh.softala.softalaharjoitus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Kysely {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nimi;
	private String johdanto;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Kysymys> kysymykset;

	public Kysely() {
		super();
	}

	public Kysely(String nimi, String johdanto) {
		super();
		this.nimi = nimi;
		this.johdanto = johdanto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getJohdanto() {
		return johdanto;
	}

	public void setJohdanto(String johdanto) {
		this.johdanto = johdanto;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [id=" + id + ", nimi=" + nimi + ", johdanto=" + johdanto + ", kysymykset=" + kysymykset + "]";
	}
	
	

}
