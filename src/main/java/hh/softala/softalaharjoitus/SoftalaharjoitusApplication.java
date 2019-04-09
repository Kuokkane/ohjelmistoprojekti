package hh.softala.softalaharjoitus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.softala.softalaharjoitus.domain.KyselyRepository;
import hh.softala.softalaharjoitus.domain.Kysymys;
import hh.softala.softalaharjoitus.domain.Kysely;
import hh.softala.softalaharjoitus.domain.KysymysRepository;

@SpringBootApplication
public class SoftalaharjoitusApplication {
private static final Logger log = LoggerFactory.getLogger(SoftalaharjoitusApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SoftalaharjoitusApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kysymysDemo(KysymysRepository krepository, KyselyRepository kyrepository) {
		return (args) -> {
			log.info("Tallennetaan kysymyksiä");
			
			kyrepository.save(new Kysely("Moodle-kysely", "Tämän kyselyn tarkoituksena on kartoittaa Haaga-helian opiskelijoiden tyytyväisyyttä Moodlen toimintaan ja löytää mahdollisia kehittämiskohteita."));
			krepository.save(new Kysymys("Minkä vuoden opiskelija olet?", kyrepository.findByName("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?", kyrepository.findByName("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?", kyrepository.findByName("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?", kyrepository.findByName("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Miten kehittäisit Moodlea?", kyrepository.findByName("Moodle-kysely").get(0)));

			log.info("Haetaan kaikki kysymykset");
			for (Kysymys kysymys : krepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}

}
