package killo.kymnevoistlus.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SkooridDto {

    private Map<String, Integer> skooridMap;
    private Integer summa;

    public SkooridDto() {
        this.skooridMap = new HashMap<String, Integer>();
        this.summa = 0;
    }
    
    public SkooridDto(Map<String, Integer> skoorid) {
        this.skooridMap = skoorid;
        this.summa = skoorid.values().stream().reduce(0, (vaheSumma, skoor) -> vaheSumma + skoor);
    }
}
