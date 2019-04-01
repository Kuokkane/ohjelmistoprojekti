package hh.softala.softalaharjoitus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.softala.softalaharjoitus.domain.Kysymys;
import hh.softala.softalaharjoitus.domain.KysymysRepository;

@SpringBootApplication
public class SoftalaharjoitusApplication {
private static final Logger log = LoggerFactory.getLogger(SoftalaharjoitusApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SoftalaharjoitusApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kysymysDemo(KysymysRepository krepository) {
		return (args) -> {
			log.info("Tallennetaan kysymyksiä");
			krepository.save(new Kysymys("Minkä vuoden opiskelija olet?"));
			krepository.save(new Kysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?"));
			krepository.save(new Kysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?"));
			krepository.save(new Kysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?"));
			krepository.save(new Kysymys("Miten kehittäisit Moodlea?"));
			log.info("Haetaan kaikki kysymykset");
			for (Kysymys kysymys : krepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}

}
