package hh.softala.softalaharjoitus.domain;



public class Kysymys {
	
	
	private long id;
	private String kysymys;
	public Kysymys(long id, String kysymys) {
		super();
		this.id = id;
		this.kysymys = kysymys;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";
	}
	
	
	
	
	
	

}
