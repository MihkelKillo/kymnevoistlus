package killo.kymnevoistlus.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class TulemusedDto {

    private Map<String, Double> tulemusedMap;

    public TulemusedDto() {
        this.tulemusedMap = new HashMap<String, Double>();
    }

    public TulemusedDto(Map<String, Double> tulemused) {
        this.tulemusedMap = tulemused;
    }
}
