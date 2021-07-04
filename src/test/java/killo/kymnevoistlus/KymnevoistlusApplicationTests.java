package killo.kymnevoistlus;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import killo.kymnevoistlus.dto.SkooridDto;
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
	void getSkooridTest() {
		TulemusedDto tulemused = new TulemusedDto();
		Map<String, Double> tulemusedMap = tulemused.getTulemusedMap();
		// Erki Nool 2000. aasta Sydney olümpiamängud esimene päev
		tulemusedMap.put("100 m jooks", 10.68);
		tulemusedMap.put("kaugushüpe", 776.0);
		tulemusedMap.put("kuulitõuge", 15.11);
		tulemusedMap.put("kõrgushüpe", 200.0);
		tulemusedMap.put("400 m jooks", 46.71);
		// Teine päev
		tulemusedMap.put("110 m tõkkejooks", 14.48);
		tulemusedMap.put("kettaheide", 43.66);
		tulemusedMap.put("teivashüpe", 500.0);
		tulemusedMap.put("odavise", 65.82);
		tulemusedMap.put("1500 m jooks", 269.48);
		SkooridDto skoorid = kymnevoistlusService.getSkoorid(tulemused);
		log.info(tulemused.toString());
		Assert.isTrue(skoorid.getSumma().equals(8641), "Skoor kokku peab tulema 8641");
	}

}
