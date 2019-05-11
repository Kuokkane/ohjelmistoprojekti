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
import hh.softala.softalaharjoitus.domain.Vaihtoehto;
import hh.softala.softalaharjoitus.domain.VaihtoehtoRepository;
import hh.softala.softalaharjoitus.domain.VastausRepository;

@SpringBootApplication
public class SoftalaharjoitusApplication {
private static final Logger log = LoggerFactory.getLogger(SoftalaharjoitusApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SoftalaharjoitusApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kysymysDemo(KysymysRepository krepository, KyselyRepository kyrepository, VastausRepository varepository, VaihtoehtoRepository vvrepository) {
		return (args) -> {
			log.info("Tallennetaan kysymyksiä");
			
			kyrepository.save(new Kysely("Moodle-kysely", "Tämän kyselyn tarkoituksena on kartoittaa Haaga-helian opiskelijoiden tyytyväisyyttä Moodlen toimintaan ja löytää mahdollisia kehittämiskohteita."));			
			
			krepository.save(new Kysymys("Minkä vuoden opiskelija olet?", "radio", kyrepository.findByNimi("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?", "radio", kyrepository.findByNimi("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?", "radio", kyrepository.findByNimi("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?", "radio", kyrepository.findByNimi("Moodle-kysely").get(0)));
			krepository.save(new Kysymys("Miten kehittäisit Moodlea?", "radio", kyrepository.findByNimi("Moodle-kysely").get(0)));
			
			vvrepository.save(new Vaihtoehto("1. vuoden", krepository.findByKysymys("Minkä vuoden opiskelija olet?").get(0)));
			vvrepository.save(new Vaihtoehto("2. vuoden", krepository.findByKysymys("Minkä vuoden opiskelija olet?").get(0)));
			vvrepository.save(new Vaihtoehto("3. vuoden", krepository.findByKysymys("Minkä vuoden opiskelija olet?").get(0)));
			vvrepository.save(new Vaihtoehto("Muu", krepository.findByKysymys("Minkä vuoden opiskelija olet?").get(0)));
			
			vvrepository.save(new Vaihtoehto("Tyytymätön", krepository.findByKysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?").get(0)));
			vvrepository.save(new Vaihtoehto("Melko tyytymätön", krepository.findByKysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?").get(0)));
			vvrepository.save(new Vaihtoehto("En osaa sanoa/neutraali", krepository.findByKysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?").get(0)));
			vvrepository.save(new Vaihtoehto("Melko tyytyväinen", krepository.findByKysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?").get(0)));
			vvrepository.save(new Vaihtoehto("Tyytyväinen", krepository.findByKysymys("Kuinka tyytyväinen olet kokonaisuutena Moodleen?").get(0)));
			
			vvrepository.save(new Vaihtoehto("Ei helppokäyttöinen", krepository.findByKysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?").get(0)));
			vvrepository.save(new Vaihtoehto("Ei kovin helppokäyttöinen", krepository.findByKysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?").get(0)));
			vvrepository.save(new Vaihtoehto("En osaa sanoa/neutraali", krepository.findByKysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?").get(0)));
			vvrepository.save(new Vaihtoehto("Melko helppokäyttöinen", krepository.findByKysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?").get(0)));
			vvrepository.save(new Vaihtoehto("Helppokäyttöinen", krepository.findByKysymys("Kuinka helppokäyttöinen Moodle mielestäsi on?").get(0)));
			
			vvrepository.save(new Vaihtoehto("Huonosti", krepository.findByKysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?").get(0)));
			vvrepository.save(new Vaihtoehto("Melko huonosti", krepository.findByKysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?").get(0)));
			vvrepository.save(new Vaihtoehto("En osaa sanoa/neutraali", krepository.findByKysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?").get(0)));
			vvrepository.save(new Vaihtoehto("Melko hyvin", krepository.findByKysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?").get(0)));
			vvrepository.save(new Vaihtoehto("Hyvin", krepository.findByKysymys("Kuinka hyvin Moodle pitää sinut ajan tasalla tärkeistä tapahtumista?").get(0)));
			
			log.info("Haetaan kaikki kysymykset");
			for (Kysymys kysymys : krepository.findAll()) {
				log.info(kysymys.toString());
			}
			
		
			
		};
	}

}
