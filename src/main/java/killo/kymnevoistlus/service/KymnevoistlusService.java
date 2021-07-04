package killo.kymnevoistlus.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import killo.kymnevoistlus.dto.SkooridDto;
import killo.kymnevoistlus.dto.TulemusedDto;
import killo.kymnevoistlus.enums.JooksuAlaEnum;
import killo.kymnevoistlus.enums.ValjakuAlaEnum;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KymnevoistlusService {
    
    // skooride arvutamisel eeldan sisendtulemustelt jooksuaegasid sekundites, heite- ja viskealade tulemusi meetrites, hüpete tulemusi sentimeetrites
    public SkooridDto getSkoorid(TulemusedDto tulemused) {
        Map<String, Integer> skoorid = new HashMap<>();
        for (Map.Entry<String, Double> tulemus : tulemused.getTulemusedMap().entrySet()) {
            skoorid.put(tulemus.getKey(), arvutaSkoor(tulemus.getValue(), tulemus.getKey()));
        }
        return new SkooridDto(skoorid);
    }

    // Skoorid ümardan alla täisarvuni
    public Integer arvutaSkoor(Double tulemus, String alaNimetus) {
        Integer skoor = 0;
        if (tulemus == 0.0) {
            return 0;
        }
        try {
            try {
                JooksuAlaEnum ala = JooksuAlaEnum.fromString(alaNimetus);
                skoor = arvutaJooksualaSkoor(tulemus, ala);
                return skoor;
            } catch (IllegalArgumentException ile) {
                log.debug(ile.getMessage());
            }
            try {
                ValjakuAlaEnum ala = ValjakuAlaEnum.fromString(alaNimetus);
                skoor = arvutaValjakualaSkoor(tulemus, ala);
                return skoor;
            } catch (IllegalArgumentException ile) {
                log.debug(ile.getMessage());
            }
        } catch (Exception e) {
            log.error("Ala skoori arvutamisel tekkis viga: " + e.getMessage());
        }
        return skoor;
    }
    
    // kümnevõistluse jooskuala skoori arvutamise valem, kus P on tulemus:  A*(B–P)^C
    private Integer arvutaJooksualaSkoor(Double tulemus, JooksuAlaEnum ala) {
        return (int) (ala.getA() * Math.pow(ala.getB() - tulemus, ala.getC()));
    }
    
    // kümnevõistluse väljakuala skoori arvutamise valem, kus P on tulemus:  A*(P-B)^C
    private Integer arvutaValjakualaSkoor(Double tulemus, ValjakuAlaEnum ala) {
        return (int) (ala.getA() * Math.pow(tulemus - ala.getB(), ala.getC()));
    }
}
