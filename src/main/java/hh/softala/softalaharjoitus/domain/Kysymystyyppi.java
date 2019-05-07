package hh.softala.softalaharjoitus.domain;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Kysymystyyppi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymystyyppiId;
	
	private String kysymystyyppi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymystyyppi")
	private List<Kysymys> kysymykset;
	
	public Kysymystyyppi() {}
	
	public Kysymystyyppi(String kysymystyyppi) {
		super();
		this.kysymystyyppi = kysymystyyppi;
	}

	public Long getKysymystyyppiId() {
		return kysymystyyppiId;
	}

	public void setKysymystyyppiId(Long kysymystyyppiId) {
		this.kysymystyyppiId = kysymystyyppiId;
	}

	public String getKysymystyyppi() {
		return kysymystyyppi;
	}

	public void setKysymystyyppi(String kysymystyyppi) {
		this.kysymystyyppi = kysymystyyppi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
			return "Kysymystyyppi [kysymystyyppiId=" + kysymystyyppiId + ", kysymystyyppi=" + kysymystyyppi + "]";
	}
}