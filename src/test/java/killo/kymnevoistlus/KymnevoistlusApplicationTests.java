package killo.kymnevoistlus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import killo.kymnevoistlus.dto.TulemusedDto;
import killo.kymnevoistlus.service.KymnevoistlusService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class KymnevoistlusApplicationTests {


	@Autowired
	KymnevoistlusService kymnevoistlusService;

	@Test
	void contextLoads() {
	}

	@Test
	void testArvutaSkoor() {
		log.info(kymnevoistlusService.arvutaSkoor(11.423, "100 m jooks").toString());
	}

	@Test
	void getSkooridTest() {
		TulemusedDto tulemused = new TulemusedDto();
		// Erki Nool 2000. aasta Sydney olümpiamängud esimene päev
		tulemused.getTulemusedMap().put("100 m jooks", 10.68);
		tulemused.getTulemusedMap().put("kaugushüpe", 776.0);
		tulemused.getTulemusedMap().put("kuulitõuge", 15.11);
		tulemused.getTulemusedMap().put("kõrgushüpe", 200.0);
		tulemused.getTulemusedMap().put("400 m jooks", 46.71);
		// Teine päev
		tulemused.getTulemusedMap().put("110 m tõkkejooks", 14.48);
		tulemused.getTulemusedMap().put("kettaheide", 43.66);
		tulemused.getTulemusedMap().put("teivashüpe", 500.0);
		tulemused.getTulemusedMap().put("odavise", 65.82);
		tulemused.getTulemusedMap().put("1500 m jooks", 269.48);
		log.info(kymnevoistlusService.getSkoorid(tulemused).toString());
	}

}
