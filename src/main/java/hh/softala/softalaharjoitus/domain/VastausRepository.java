package hh.softala.softalaharjoitus.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	
	List<Vastaus> findByVastaus(String vastaus);
	
	List<Vastaus> findByKysymys(Kysymys kysymys);

<<<<<<< HEAD

=======
>>>>>>> b12dfa6a1e4a964d36ae66bb8342599f86f236cc
}
