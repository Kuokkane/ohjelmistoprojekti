package hh.softala.softalaharjoitus.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Kysymys {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String uusiKysymys;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Kysely kysely;
	
	public Kysymys() {
		
	}
	
<<<<<<< HEAD
	public Kysymys(String kysymys, Kysely kysely) {
		super();
		this.kysymys = kysymys;
		this.kysely = kysely;
=======

	
	public Kysymys(String uusiKysymys) {

		super();
		this.uusiKysymys = uusiKysymys;
>>>>>>> 2fb6c292ff732a86b064f7c10b1db9ad03ee8416
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKysymys() {
		return uusiKysymys;
	}
	public void setKysymys(String uusiKysymys) {
		this.uusiKysymys = uusiKysymys;
	}
	
	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		if (this.kysely != null)
			return "Kysymys [id=" + id + ", kysymys=" + kysymys + "kysely =" + this.getKysely() + "]";
		else
			return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";
=======
		return "Kysymys [kysymys=" + uusiKysymys + "]";
>>>>>>> 2fb6c292ff732a86b064f7c10b1db9ad03ee8416
	}
	

}
