package hh.softala.softalaharjoitus.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Kysymys {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String uusiKysymys;
	
	public Kysymys() {
		
	}
	

	
	public Kysymys(String uusiKysymys) {

		super();
		this.uusiKysymys = uusiKysymys;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKysymys() {
		return uusiKysymys;
	}
	public void setKysymys(String uusiKysymys) {
		this.uusiKysymys = uusiKysymys;
	}
	
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + uusiKysymys + "]";
	}
	

}
