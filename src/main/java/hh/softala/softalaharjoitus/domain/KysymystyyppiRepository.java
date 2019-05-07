package hh.softala.softalaharjoitus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymystyyppiRepository extends CrudRepository<Kysymystyyppi, Long> {
	
	List<Kysymystyyppi> findByKysymystyyppi(String kysymystyyppi);

}
