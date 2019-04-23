package hh.softala.softalaharjoitus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vaihtoehtoId;
	
	private String vaihtoehto;
	
	@ManyToOne
	@JoinColumn(name= "kysymysId")
	@JsonIgnore
	private Kysymys kysymys;
	
	public Vaihtoehto() {
		
	}
	
	public Vaihtoehto(String vaihtoehto, Kysymys kysymys) {
		super();
		this.vaihtoehto = vaihtoehto;
		this.kysymys = kysymys;
	}

	public Long getVaihtoehtoId() {
		return vaihtoehtoId;
	}

	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}

	public String getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
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
			return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", vaihtoehto=" + vaihtoehto + ", kysymys =" + this.getKysymys() + "]";
		else
		return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", vaihtoehto=" + vaihtoehto + "]";
	}
	
	
	

}
